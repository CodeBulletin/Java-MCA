import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static final int port = 8080;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Socket client = new Socket("localhost", port);
            PrintWriter writer = new PrintWriter(
                client.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
            System.out.print("Enter your name: ");
            writer.println(sc.nextLine());

            Thread inputThread = new Thread(new Runnable() {
                public void run() {
                    try {
                        while (true) {
                            System.out.println("out> " + reader.readLine());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            inputThread.start();

            while (true) {
                System.out.print("");
                String input = sc.nextLine().trim();
                if (input.toLowerCase() == "exit") break;
                writer.println(input);
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}