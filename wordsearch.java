//package filewordsearch;


import java.io.*;
import java.util.Scanner;


public class wordsearch {

    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter the filename: ");
        String fileName = scanner.nextLine();

       
        System.out.print("Enter the text to write to the file: ");
        String text = scanner.nextLine();

        
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
            return;
        }

       
        System.out.print("Enter the keyword to search for: ");
        String keyword = scanner.nextLine();

       
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int lineNumber = 1;
            int position = -1;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].equals(keyword)) {
                        count++;
                        System.out.println("Keyword found at line " + lineNumber + ", position " + i + ".");
                    }
                }
                lineNumber++;
            }
            reader.close();

            if (count == 0) {
                System.out.println("Keyword not found in file.");
            } else {
                System.out.println("Keyword found " + count + " times in file.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }
    }
    
}