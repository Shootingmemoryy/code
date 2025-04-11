package com.bite.java_chartoom.model;




import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-02-12-23:24
 */
public class MessageSession {
    private int sessionId;
    private List<Friend> friends;
    private String lastMessage;

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}