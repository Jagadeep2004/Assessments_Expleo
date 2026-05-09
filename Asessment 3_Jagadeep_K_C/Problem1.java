package Assessment03;


import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class Problem1 {

    public static void main(String[] args) {

        Map<String, Integer> wordCount = new TreeMap<>();

        try {
            
            Path path = Paths.get("words.txt");

            
            List<String> lines = Files.read(path);

            for (String line : lines) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    word = word.toLowerCase();
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }

            
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            System.out.println("Unique words : " + wordCount.size());

        } catch (NoSuchFileException e) {
            System.out.println("Not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}