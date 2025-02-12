function initSwitchTab() {
    let tabSession = document.querySelector('.tab .tab-session');
    let tabFriend =document.querySelector('.tab .tab-friend');
    let lists =document.querySelectorAll('.list');
    tabSession.onclick = function () {
        tabSession.style.backgroundImage = "url('img/Chat.png')";
        tabFriend.style.backgroundImage = "url('img/User1.png')";
        lists[0].classList= 'list';
        lists[1].classList='list hide';

    }
    tabFriend.onclick = function () {
        tabSession.style.backgroundImage = "url('img/Chat1.png')";
        tabFriend.style.backgroundImage = "url('img/User.png')";
        lists[0].classList='list hide';
        lists[1].classList='list';
    }
}
initSwitchTab();
function getUserInfo() {
    $.ajax({
        type: 'get',
        url: 'userInfo',
        success: function(body) {
            // 从服务器获取到数据.
            // 校验结果是否有效.
            if (body.userId && body.userId > 0) {
                // 如果结果有效, 则把用户名显示到界面上.
                // 同时也可以记录 userId 到 html 标签的属性中. (以备后用)
                let userDiv = document.querySelector('.main .left .user');
                userDiv.innerHTML = body.username;
                userDiv.setAttribute("user-id", body.userId);
            } else {
                // 如果结果无效, 当前未登录! 则跳转到登录页面.
                alert("当前用户未登录!");
                location.assign('login.html');
            }
        }
    });
}

getUserInfo();
function getFriendList() {
 $.ajax({
    type: 'get',
    url: 'friendList',
    success: function(body) {
        let friendListUL = document.querySelector('#friend-list');
        friendListUL.innerHTML = '';
        for(let friend of body) {
            let li = document.createElement('li');
            li.innerHTML = '<h4>' + friend.friendName+'</h4>';
            li.setAttribute("friend-id", friend.friendId);
            friendListUL.appendChild(li);
        }
    },
    error:function () {
        alert("获取好友列表失败!");

    }
 });
}
getFriendList();
function getSessionList() {
    $.ajax({
        type: 'get',
        url: 'sessionList',
        success: function(body) {
            let sessionListUL = document.querySelector('#session-list');
            sessionListUL.innerHTML = '';
            for (let session of body) {
                if (session.lastMessage.length > 10){
            session.lastMessage = session.lastMessage.substring(0, 10) + '...';
        }
                 let li = document.createElement('li');
                 li.setAttribute("session-id", session.sessionId);
                 li.innerHTML = '<h3>' + session.friend[0].friendName+'</h3>'+'<p>'+session.lastMessage+'</p>';
                 sessionListUL.appendChild(li);
             }
            li.onclick = function() {
                // 这个写法, 就能保证, 点击哪个 li 标签
                // 此处对应的 clickSession 函数的参数就能拿到哪个 li 标签.
                clickSession(li);
            }
        }
    });
}
getSessionList();
function clickSession(currentLi) {
    // 1. 设置高亮
    let allLis = document.querySelectorAll('#session-list>li');
    activeSession(allLis, currentLi);
    // 2. 获取指定会话的历史消息 TODO
    let sessionId = currentLi.getAttribute("message-session-id");
    getHistoryMessage(sessionId);
}
function activeSession(allLis, currentLi) {
    // 这里的循环遍历, 更主要的目的是取消未被选中的 li 标签的 className
    for (let li of allLis) {
        if (li == currentLi) {
            li.className = 'selected';
        } else {
            li.className = '';
        }
    }
}