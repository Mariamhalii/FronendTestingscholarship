package com.filesreaderpackage;

import java.io.*;

import com.filesreaderpackage.studentcoursesdata.*;
import com.filesreaderpackage.read.files.readConvertTextFile;
import com.filesreaderpackage.read.files.readConvetXmlfile;

public class test  {

    public static void main(String[] args) throws IOException {
//        readConvertTextFile read = new readConvertTextFile();
//        read.readTxtfile();
//        read.convertTxtFileToCsv();
//        read.AddColumn("G:\\FWD projects\\csvStudent.csv",",",0);
//        Students printAllStudentData = new Students();
//        printAllStudentData.printStudentData();
        readConvetXmlfile read = new readConvetXmlfile();
        read.convertXmlFileToCsv();
   }
}
