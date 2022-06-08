package com.sheikh.telegram;

public class Message {

    private String author;
    private String message;
    private long milliseconds;
    private String imageUrl;

    public Message(String author, String message, long milliseconds , String imageUrl) {
        this.author = author;
        this.message = message;
        this.milliseconds = milliseconds;
        this.imageUrl = imageUrl;
    }

    public Message() {}

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public String getauthor() {
        return author;
    }

    public String getmessage() {
        return message;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    public void setmessage(String message) {
        this.message = message;
    }
}

