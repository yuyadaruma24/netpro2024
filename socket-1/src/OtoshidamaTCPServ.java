import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class OtoshidamaTCPServ {
    public static void main(String arg[]){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("ポートを入力してください(5000など)");
            int port = scanner.nextInt();
            System.out.println("localhost" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port);
            Socket socket = server.accept();
            System.out.println("接続しました。相手の入力を待っています......");
            ObjectInputStream ois = new ObjectInputStream((socket.getInputStream()));
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());


            while (true) {

                Otoshidama otoshidama = (Otoshidama) ois.readObject();

                String ageOtoshidama = otoshidama.getAge();
                if (ageOtoshidama.equals("exit") || ageOtoshidama.equals("quit")) {
                    break;
                }
                System.out.println("年齢は" + ageOtoshidama + "歳。");
                String amoutOfOtoshidama = otoshidama.getOtoshidama();
                System.out.println("お年玉の希望金額は" + amoutOfOtoshidama +"円。");

                
                Otoshidama response = new Otoshidama();
                response.setAge("サーバーです。あけましておめでとう。" + ageOtoshidama + "歳のあなたのお年玉の金額は・・・");
                response.setOtoshidama(response.caliculateOtoshidama(Integer.parseInt(ageOtoshidama), amoutOfOtoshidama));

                oos.writeObject(response);
                oos.flush();

                
            }
            ois.close();
            oos.close();
            // socketの終了。
            scanner.close();
            socket.close();
            server.close();

        }
        catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
