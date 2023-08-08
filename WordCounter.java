package ArrayList.Internship;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordCounter {
    public static void main(String[] args) {
        String inputText = getUserInput();
        String[] words = splitWords(inputText);
        int totalWords = countWords(words);

        System.out.println("Total number of words: " + totalWords);

        // Number of unique words
        int uniqueWords = countUniqueWords(words);
        System.out.println("Number of unique words: " + uniqueWords);

        // Frequency of each word
        displayWordFrequency(words);
    }

    public static String getUserInput() {
        System.out.println("Enter 'T' to input text or 'F' to input a file:");
        String choice = System.console().readLine().trim().toLowerCase();

        if (choice.equals("t")) {
            System.out.println("Enter the text:");
            return System.console().readLine();
        } else if (choice.equals("f")) {
            System.out.println("Enter the file path:");
            String filePath = System.console().readLine();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append('\n');
                }
                return sb.toString();
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
                return getUserInput();
            }
        } else {
            System.out.println("Invalid choice. Please try again.");
            return getUserInput();
        }
    }

    public static String[] splitWords(String text) {
        return text.split("\\W+");
    }

    public static int countWords(String[] words) {
        return words.length;
    }

    public static int countUniqueWords(String[] words) {
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        return uniqueWords.size();
    }

    public static void displayWordFrequency(String[] words) {
        Arrays.sort(words);

        int count = 1;
        for (int i = 1; i < words.length; i++) {
            if (words[i].equals(words[i - 1])) {
                count++;
            } else {
                System.out.println(words[i - 1] + ": " + count);
                count = 1;
            }
        }
        System.out.println(words[words.length - 1] + ": " + count);
    }
}
