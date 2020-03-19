package com.company;

import javafx.util.Pair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Document implements Serializable {
    private String id;
    private String name;
    private String location;

    private List<Pair<String, String>> tags;

    public Document(String title, String loc) {
        tags = new ArrayList<Pair<String, String>>();
        location = loc;
        name = title;
    }

    public void addTag(Pair<String, String> newTag) {
        tags.add(newTag);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
