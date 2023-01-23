package com.filesreaderpackage.read.files;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class readConvetXmlfile {
    File xmlFile = new File("G:\\FWD projects\\coursedata.xml");
    File xmlstyle = new File("G:\\FWD projects\\coursestyle.xml");

    Scanner scanxml;
    File convertedfile;
    FileWriter Writer;
    String finalxml;

    public void readXmlFile(){
        try {
            scanxml = new Scanner(xmlFile);
        } catch (Exception e) {
            System.out.println("Can't read the xml file!!!");
        }
//        System.out.println(scanxml.nextLine());
    }

    public void convertXmlFileToCsv() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            StreamSource stylesource = new StreamSource(xmlstyle);
            Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);
            Source source = new DOMSource(document);
            Result outputTarget = new StreamResult(new File("G:\\FWD projects\\xmloutputcourse.csv"));
            transformer.transform(source, outputTarget);

        } catch (Exception e) {
            System.out.println("this code not executed");
        }
    }
}
