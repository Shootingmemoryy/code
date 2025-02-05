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