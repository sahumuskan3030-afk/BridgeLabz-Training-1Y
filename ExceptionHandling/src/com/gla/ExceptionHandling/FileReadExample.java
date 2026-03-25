package com.gla.ExceptionHandling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadExample {
    public static void main(String[] args) {
        try {
            // Attempt to open and read the file
            BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
            String line;

            // Read and print file contents line by line
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            // Handle exception if file does not exist or cannot be read
            System.out.println("File not found or unable to read the file.");
        }
    }
}

