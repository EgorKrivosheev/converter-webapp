'use strict';

function setFlexDirection() {
    let _isMobile = /Mobile|webOS|BlackBerry|IEMobile|MeeGo|mini|Fennec|Windows Phone|Android|iP(ad|od|hone)/i.test(navigator.userAgent);
    let _clientWidth = document.documentElement.clientWidth;
    let _main = document.getElementById("main");

    if (_isMobile || _clientWidth < 768) {
        _main.classList.add('mobile');
    } else {
        _main.classList.remove("mobile");
    }
}

window.onload = function() {
    setFlexDirection();
};

window.onresize = function() {
    setFlexDirection();
};
