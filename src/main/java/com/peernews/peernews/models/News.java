package com.peernews.peernews.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "news")
public class News {
    private String id;
    private String title;
    private String content;
    private String authorId;
    private String date;
    
    // constructor
    public News(String title, String content, String authorId, String date) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.date = date;
    }

    // getters and setters
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public String getAuthorId() {
        return authorId;
    }
    public String getDate() {
        return date;
    }
    public String getId() {
        return id;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
