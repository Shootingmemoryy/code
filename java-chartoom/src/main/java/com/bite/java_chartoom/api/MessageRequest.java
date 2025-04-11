package com.bite.java_chartoom.api;



/**
 * @Shootingmemory
 * @create 2025-02-27-17:34
 */
public class MessageRequest {
    private String type = "message";
    private int sessionId;
    private String content;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}