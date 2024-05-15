import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class OtoshidamaTEPClient {
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");
            while (true) {
                System.out.println("お年玉チェック!!");
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                System.out.println("年齢を入力してください(例:18)");
                String age = scanner.next();
                System.out.println("希望金額は??");
                String Otoshidama = scanner.next();
                scanner.close();

                Otoshidama otoshidama = new Otoshidama();
                otoshidama.setAge(age);
                otoshidama.setOtoshidama(Otoshidama);
                oos.writeObject(otoshidama);
                oos.flush();

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                Otoshidama result = (Otoshidama) ois.readObject();

                String replayAge = result.getAge();
                System.out.println(replayAge);
                String replayOtoshidama = result.getOtoshidama();
                System.out.println(replayOtoshidama);
                ois.close();
                oos.close();
                socket.close();
            }
            
        }
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
