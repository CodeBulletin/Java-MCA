import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws Exception {
        // Read the required format from the end-user
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter date and time format: ");
        String format = reader.readLine();

        // Create a datagram socket and send the format to the server
        DatagramSocket socket = new DatagramSocket();
        byte[] data = format.getBytes();
        InetAddress address = InetAddress.getByName("localhost");
        int port = 5000;
        DatagramPacket packet = 
            new DatagramPacket(data, data.length, address, port);
        socket.send(packet);

        // Receive the date and time from the server
        byte[] buffer = new byte[1024];
        packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        String dateTime = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Date and time: " + dateTime);
    }
}
