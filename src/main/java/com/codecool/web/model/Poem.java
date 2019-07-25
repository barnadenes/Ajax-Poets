package com.codecool.web.model;

import java.util.Date;

public final class Poem {
    private final int user_id;
    private final String content;
    private final String title;
    private final Date date;

    public Poem(int user_id, String content, String title, Date date) {
        this.user_id = user_id;
        this.content = content;
        this.title = title;
        this.date = date;
    }

    public int getUser_id() {
        return user_id;
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
