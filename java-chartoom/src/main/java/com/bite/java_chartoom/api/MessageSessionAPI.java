package com.bite.java_chartoom.api;


import com.bite.java_chartoom.model.Friend;
import com.bite.java_chartoom.model.MessageSession;
import com.bite.java_chartoom.model.MessageSessionMapper;
import com.bite.java_chartoom.model.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import java.util.List;

@RestController
public class MessageSessionAPI {
    @Resource
    private MessageSessionMapper messageSessionMapper;



    @GetMapping("/sessionList")
    @ResponseBody
    public Object getMessageSessionList(HttpServletRequest req) {
        List<MessageSession> messageSessionList = new ArrayList<>();
        // 1. 获取到当前用户的 userId (从 spring 的 session 中获取)
        HttpSession session = req.getSession(false);
        if (session == null) {
            System.out.println("[getMessageSessionList] session == null");
            return messageSessionList;
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            System.out.println("[getMessageSessionList] user == null");
            return messageSessionList;
        }
        // 2. 根据 userId 查询数据库, 查出来有哪些会话id
        List<Integer> sessionIdList = messageSessionMapper.getSessionIdsByUserId(user.getUserId());
        for (int sessionId : sessionIdList) {
            MessageSession messageSession = new MessageSession();
            messageSession.setSessionId(sessionId);
            // 3. 遍历会话id, 查询出每个会话里涉及到的好友都有谁
            List<Friend> friends = messageSessionMapper.getFriendsBySessionId(sessionId, user.getUserId());
            messageSession.setFriends(friends);
            // 4. 遍历会话id, 查询出每个会话的最后一条消息
            //    有可能出现按照会话 id 查不到消息的情况 (新创建的会话可能还没来得及发消息呢
            messageSessionList.add(messageSession);
        }
        // 最终目标就是构造出一个 MessageSession 对象数组
        return messageSessionList;
    }
}
