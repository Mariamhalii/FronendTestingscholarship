package com.filesreaderpackage.studentcoursesdata;

import com.filesreaderpackage.read.files.readConvertTextFile;
import java.io.IOException;

public class Students {

    readConvertTextFile readfile;

    public void printStudentData() {
        System.out.println("-------------------------------\n"+"Current Student List\n"+"-------------------------------");
        try {
            readfile = new readConvertTextFile();
            readfile.readFinal("G:\\FWD projects\\csvStudent.csv",",");
        } catch (IOException e) {

        }
    }

}
