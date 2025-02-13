package com.bite.java_chartoom.model;

import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-02-12-23:33
 */
public class MessageSessionMapper {
    List<Integer> getSessionIdsByUserId(int userId);
    List<Friend> getFriendListByUserId(int userId,int selfUserId);
}
