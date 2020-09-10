function set_flex_direction() {
    let _isMobile = /Mobile|webOS|BlackBerry|IEMobile|MeeGo|mini|Fennec|Windows Phone|Android|iP(ad|od|hone)/i.test(navigator.userAgent);
    let _clientWidth = document.documentElement.clientWidth;

    if (_isMobile || _clientWidth < 768) {
        document.getElementById("main").style.flexDirection="column";
        document.getElementById("menu").style.flexDirection="row";
        document.getElementById("convert").classList.add("rotate");
    } else {
        document.getElementById("main").style.flexDirection="row";
        document.getElementById("menu").style.flexDirection="column";
        document.getElementById("convert").classList.remove("rotate");
    }
}

window.onload = function() {
    set_flex_direction();
};

window.onresize = function() {
    set_flex_direction();
};
