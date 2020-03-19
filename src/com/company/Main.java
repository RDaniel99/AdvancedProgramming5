package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Document doc1 = new Document("report1", "D:/tmp/report_result_0010.html");
        Document doc2 = new Document("report2", "D:/tmp/report_result_0016.html");

        Catalog catalog = new Catalog();
        catalog.addDocument(doc1);
        catalog.addDocument(doc2);

        catalog.save("object");

        Catalog catalog2 = new Catalog();

        try {
            catalog2.load("object");
        } catch(IOException e) {
            System.out.println("IOException");
        }

        catalog2.printDocs();

        catalog2.view("D:/tmp/report_result_0016.html");
    }
}
