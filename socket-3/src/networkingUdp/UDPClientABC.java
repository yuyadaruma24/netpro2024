package networkingUdp;
import java.io.IOError;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientABC {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            String sendMessage = "abc";
            byte[] sendDate = sendMessage.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendDate, sendDate.length, serverAddress, 9876);
            socket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String receiveMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("受信: " + receiveMessage);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
 