import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        // Read the equation from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter equation: ");
        String equation = scanner.nextLine();

        // Connect to the server and send the equation
        Socket socket = new Socket("localhost", 5000);
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        output.println(equation);
        BufferedReader input = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));

        // Read the result from the server
        double result = Double.parseDouble(input.readLine());
        System.out.println("Result: " + result);
        socket.close();
        scanner.close();
    }
}
