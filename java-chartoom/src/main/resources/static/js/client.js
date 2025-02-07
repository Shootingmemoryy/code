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
function getFridendList() {
 $.ajax({
    type: 'get';
    url: 'friendList',
    success: function(body) {
        let friendListUL = document.querySelector('#friend-List');
        friendListUL.innerHTML = '';
        for(let friend of body) {
            let li = document.createElement('li');
            li.innerHTML = '<h4>'+friend.frindName+'</h4>';
            li.setAttribute("friend-id", friend.friendId);
            friendListUL.appendChild(li);
        }
    }
    error:function () {
        alert("获取好友列表失败!");
        
    }
 });
}