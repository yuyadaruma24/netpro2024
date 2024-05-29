package networkingUdp;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastClientKadai {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            InetAddress group = InetAddress.getByName("224.0.0.1");
            int port = 12345;

            String command = "SOME_COMMAND";

            byte[] buffer = command.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
            socket.send(packet);

            System.out.println("Command sent: " + command);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(socket != null && !socket.isClosed()){
                socket.close();
            }
        }
    }
}
