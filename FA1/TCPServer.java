import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import Bot.Bot;

public class TCPServer {
    public static final int port = 8080;
    public static void main(String[] args) {
        ServerSocket socket;
        try {
            socket = new ServerSocket(port);
            while (true) {
                Socket client = socket.accept();
                ClientHandler handler = new ClientHandler(client);
                Thread t = new Thread(handler);
                t.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {
    Socket client;
    BufferedReader reader;
    PrintWriter writer;
    Bot bot;
    @Override
    public void run() {
        try {
            reader = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
            writer = new PrintWriter(client.getOutputStream(), true);
            String name = reader.readLine();
            System.out.println("Connected with: " + name);
            bot = new Bot();
            while(true) {
                String input = reader.readLine().trim();
                if (input == "exit") break;
                writer.println(bot.getReply(input));
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    ClientHandler(Socket client) {
        this.client = client;
    }
}