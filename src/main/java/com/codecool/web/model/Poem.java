package com.codecool.web.model;

public final class Poem {
    private final int id;
    private final String content;
    private final String title;
    private final String date;

    public Poem(int id, String content, String title, String date) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }
}
