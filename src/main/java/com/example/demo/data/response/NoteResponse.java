package com.example.demo.data.response;

import java.util.UUID;

public class NoteResponse {
    private UUID id;
    private String title;
    private String content;

    public NoteResponse() {
    }

    public NoteResponse(UUID id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
