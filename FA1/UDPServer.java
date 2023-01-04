import java.net.*;

import Bot.Bot;

public class UDPServer {
    static final int port = 8080;
    static final Bot bot = new Bot();
    public static void main(String args[]) throws Exception {
        DatagramSocket socket = new DatagramSocket(port);
        
        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            InetAddress addr = packet.getAddress();
            int cport = packet.getPort();
            String input = new String(packet.getData());
            String output = bot.getReply(input.trim());
            DatagramPacket response = new DatagramPacket(
                output.getBytes(), output.getBytes().length, addr, cport);
            socket.send(response);
        }
    }
}