import java.net.*;
import java.util.Scanner;

class UDPClient {
    static final int sport = 8080;
    public static void main(String args[]) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("localhost");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String message = sc.nextLine();
            byte buffer[] = message.getBytes();
            DatagramPacket packet = 
                new DatagramPacket(buffer, buffer.length, addr, sport);
            socket.send(packet);

            byte[] rbuffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(rbuffer, rbuffer.length);
            socket.receive(response);
            String output = new String(rbuffer);
            System.out.println("out> " + output);
        }
    }
}
