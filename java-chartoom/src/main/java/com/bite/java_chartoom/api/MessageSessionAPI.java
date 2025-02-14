package com.bite.java_chartoom.api;

import com.bite.java_chartoom.model.Friend;
import com.bite.java_chartoom.model.MessageSession;
import com.bite.java_chartoom.model.MessageSessionMapper;
import com.bite.java_chartoom.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-02-13-23:11
 */
@Slf4j
@RestController
public class MessageSessionAPI {
    @Resource
    private MessageSessionMapper messageSessionMapper;
    @GetMapping("/sessionList")
    @ResponseBody
    public Object getMessageSessionList(HttpServletRequest request) {
        List<MessageSession>messageSessionList = new ArrayList<>();
        HttpSession session =request.getSession(false);
        if (session == null) {
        log.info("[getMessageSessionList] 当前用户未登录!");
        return  messageSessionList;
        }
        User user = (User) session.getAttribute("user");
        if(user == null){
            log.info("[getMessageSessionList] 当前用户未登录!");
            return messageSessionList;
        }
       List<Integer> sessionIdList =  messageSessionMapper.getSessionIdsByUserId(user.getUserId());
       for (Integer sessionId : sessionIdList) {
           MessageSession messageSession = new MessageSession();
           List <Friend> friends = messageSessionMapper.getFriendListByUserId(sessionId, user.getUserId());
            messageSession.setFriends(friends);
            messageSession.setLastMessage("nihao");
            messageSessionList.add(messageSession);
       }
        return messageSessionList;
    }

}
