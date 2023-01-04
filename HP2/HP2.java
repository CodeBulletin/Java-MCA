import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class HP2 {
    public static void main(String[] args) {
        // Accept a search token from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a search token: ");
        String searchToken = scanner.nextLine();

        try {
            // Open the file using RandomAccessFile
            RandomAccessFile file = new RandomAccessFile("input.txt", "r");

            // Read the file and search for the search token
            String line;
            int count = 0;
            while ((line = file.readLine()) != null) {
                int index = line.indexOf(searchToken);
                while (index != -1) {
                    count++;
                    index = line.indexOf(searchToken, index + 1);
                }
            }

            // Display the total number of occurrences of the search token
            System.out.println("Total occurrences: " + count);

            // Close the file
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
