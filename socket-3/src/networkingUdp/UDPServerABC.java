package networkingUdp;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPServerABC {
    public static void main(String[] args) {
        String upperMessage;
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String receiveMessage = new String(receivePacket.getData(), 0 , receivePacket.getLength());
            System.out.println("受信" + receiveMessage);
            upperMessage = receiveMessage.toUpperCase();
            
            String sendMessage = upperMessage;
            byte[] sendDate = sendMessage.getBytes();
            InetAddress ClientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            DatagramPacket sendPacket = new DatagramPacket(sendDate, sendDate.length, ClientAddress, clientPort);
            socket.send(sendPacket);
        } catch(Exception e){
            e.printStackTrace();
        }finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
