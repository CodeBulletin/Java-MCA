import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EP4 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: EP4 <file>");
            System.exit(1);
        }
        try {
            WordFrequencyCounter.run(args[0]);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class WordFrequencyCounter {
    public static void run(String fileName) throws IOException {
        Map<String, Integer> wordCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase();
                    if (wordCounts.containsKey(word)) {
                        wordCounts.put(word, wordCounts.get(word) + 1);
                    } else {
                        wordCounts.put(word, 1);
                    }
                }
            }
        }

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }
}