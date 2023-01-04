import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
    public static void main(String[] args) throws Exception {
        // Create a datagram socket and wait for requests
        DatagramSocket socket = new DatagramSocket(5000);
        while (true) {
            // Receive the format from the client
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String format = new String(
                packet.getData(),
                0, 
                packet.getLength());
            // Send the date and time to the client
            Date date = new Date();
            SimpleDateFormat sdf;
            try {
                // Use the requested format if it is valid
                sdf = new SimpleDateFormat(format);
            } catch (IllegalArgumentException e) {
                // Use a default format if the requested format is not valid
                sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            }
            String dateTime = sdf.format(date);
            byte[] data = dateTime.getBytes();
            packet = 
                new DatagramPacket(
                    data, data.length,
                    packet.getAddress(), packet.getPort());
            socket.send(packet);
        }
    }
}
