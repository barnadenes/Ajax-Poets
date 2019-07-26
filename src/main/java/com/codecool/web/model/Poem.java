package com.codecool.web.model;

import java.util.Date;

public final class Poem {
    private final int id;
    private final String content;
    private final String title;
    private final Date date;

    public Poem(int id, String content, String title, Date date) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.date = date;
    }

    public int id() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }
}
