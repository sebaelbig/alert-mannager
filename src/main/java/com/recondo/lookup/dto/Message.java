package com.recondo.lookup.dto;

public class Message {
    private String text;
    private Long id; // Optional, only set if the message already exists

    public Message() {}

    public Message(String text) {
        this.text = text;
    }

    public Message(String text, Long id) {
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
