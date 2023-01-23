package com.filesreaderpackage.read.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class readConvertTextFile {
    public readConvertTextFile() throws IOException {
    }

    File file = new File("G:\\FWD projects\\student-data.txt"); // File path for the text file
    Scanner Scan;
    File file2;
    FileWriter Writer;
    String csv;

        //this is the method to read the text file from the hard disk
    public void readTxtfile() {
        try {
            Scan = new Scanner(file);
        } catch (Exception e) {
            System.out.println("File doesn't exist.");
        }

        System.out.println(Scan.nextLine());
    }

    //This is the method to Convert the text file to CSV file
    public void convertTxtFileToCsv() {
        try {
            file2 = new File("G:\\FWD projects\\csvStudent.csv");
            Writer = new FileWriter(file2);
            Scan = new Scanner(file);
            if (Scan.hasNext()) {
                csv = Scan.nextLine().replace("#", ",").replace("$", "\n");
                System.out.println(csv);
                Writer.append(csv);
                Writer.append("\n");
                Writer.flush();
            }
        } catch (Exception e) {
            System.out.println("this code not executed");
        }
    }


    public void AddColumn(String filePath, String delimiter, int colPos) {
        try {
            List<String> data = Files.readAllLines(Paths.get(filePath));
            PrintWriter pw = new PrintWriter(filePath);

            FileWriter fw = new FileWriter(filePath, true);
            pw = new PrintWriter(fw);

            for (int i = 0; i < data.size(); i++) {

                String[] line = data.get(i).split(delimiter);
                List<String> record = new ArrayList<String>(Arrays.asList(line));
                if (i==0){
                    record.add(colPos,"id");
                }
                else{
                record.add(colPos, String.valueOf(i));
                }
                pw.println(String.join(delimiter, record));
                System.out.println(String.join(delimiter, record));
            }
            pw.close();

        } catch (Exception e) {
            System.out.println("Not executed" + e);
        }

    }
    public void readFinal(String filePath, String delimiter){
        try {
            List<String> data = Files.readAllLines(Paths.get(filePath));
            for (int i = 0; i < data.size(); i++) {

                String[] line = data.get(i).split(delimiter);
                List<String> record = new ArrayList<String>(Arrays.asList(line));
                String recordfield =String.join(delimiter, record);
                String[] fields = recordfield.split(delimiter);
                for(String field : fields) {
                    System.out.print(String.format("%-30s",field));

                }
                System.out.println();
            }
        }
        catch (Exception e){

        }
    }
}

