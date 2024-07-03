package com.peernews.peernews.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "news")
public class News {
    private String id;
    private String title;
    private String content;
    
    // constructor
    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // getters and setters
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
