package com.company;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private List<Document> documentList;

    public Catalog() {
        documentList = new ArrayList<Document>();
    }

    public void addDocument(Document doc) {
        documentList.add(doc);
    }

    public int getIndexDocument(Document doc) {
        for(int i = 0; i < documentList.size(); i++) {
            if(documentList.get(i).getId().equals(doc.getId())) {
                return i;
            }
        }

        return -1;
    }

    public void save(String location) {
        try {
            FileOutputStream file = new FileOutputStream(location);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(this);

            out.close();
            file.close();

            System.out.println("Object serialized");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    public void load(String location) throws IOException {
        try {
            FileInputStream file = new FileInputStream(location);
            ObjectInputStream in = new ObjectInputStream(file);

            Catalog temp = (Catalog)in.readObject();
            this.documentList = temp.documentList;
        } catch (FileNotFoundException e) {
            System.out.println("Catalog not found");
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
    }

    public void view(String location) {
        for (Document document : documentList) {
            if (document.getLocation().equals(location)) {
                try {
                    Desktop desktop = Desktop.getDesktop();
                    File file = new File(location);
                    desktop.open(file);
                } catch (IOException e) {
                    System.out.println("File error");
                }
            }
        }
    }
}
