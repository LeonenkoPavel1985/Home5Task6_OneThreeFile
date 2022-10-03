package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        String pathFile_1;
        String pathFile_2;
        String pathFile_3;
        String pathFile_write;

        System.out.println("Enter the path to the first file or its name:");
        pathFile_1 = scanner.next();

        System.out.println("Enter the path to the second file or its name:");
        pathFile_2 = scanner.next();

        System.out.println("Enter the path to the third file or its name:");
        pathFile_3 = scanner.next();

        System.out.println("Enter the path to the file to be written or its name:");
        pathFile_write = scanner.next();

        scanner.close();

        String [] fileName = {pathFile_1,pathFile_2,pathFile_3};
        File file = new File(pathFile_write);
        FileWriter output = new FileWriter(file);

        try {
            for (int i = 0; i < fileName.length; i++) {
                BufferedReader objBufferedReader = new BufferedReader(new FileReader(getDictionaryFilePath(fileName[i])));
                String line;

                while ((line = objBufferedReader.readLine()) != null) {
                    line = line.replace("","");
                    output.write(line);
                }
                objBufferedReader.close();
            }
            output.close();
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static String getDictionaryFilePath(String fileName) throws Exception {
        String dictionaryFolderPath = null;
        File configFolder = new File(fileName);
        try {
            dictionaryFolderPath = configFolder.getAbsolutePath();
        }
        catch (Exception e) {
            throw  new Exception(e);
        }
        return dictionaryFolderPath;
    }
}
