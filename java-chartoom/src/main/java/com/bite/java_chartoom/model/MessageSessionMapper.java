package com.bite.java_chartoom.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-02-12-23:33
 */
@Mapper
public interface MessageSessionMapper {
    List<Integer> getSessionIdsByUserId(int userId);
    List<Friend> getFriendsBySessionId(int sessionId, int selfUserId);
}
