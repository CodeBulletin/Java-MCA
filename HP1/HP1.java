import java.io.*;

public class HP1 {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));

            // Same can be down using FileReader and FileWriter like
            
            // FileReader in = new FileReader("input.txt");
            // FileWriter out = new FileWriter("output.txt");
            String line;
            while ((line = in.readLine()) != null) {
                int vowelCount = 0;
                int consonantCount = 0;
                int spaceCount = 0;
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if (ch == 'a' || ch == 'e' || ch == 'i' ||
                            ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E'
                            || ch == 'I' || ch == 'O' || ch == 'U') {
                        vowelCount++;
                    } else if (ch == ' ') {
                        spaceCount++;
                    } else if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
                        consonantCount++;
                    }
                }
                out.write(line + " (vowels: " + vowelCount +
                    ", consonants: " + consonantCount + ", spaces: "
                    + spaceCount + ")");
                out.newLine();
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}