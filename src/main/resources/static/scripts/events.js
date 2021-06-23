'use strict';

/* Constants */
const _CANVAS = document.getElementById("bgCanvas"),
    _CANVAS_CONTEXT = _CANVAS.getContext('2d');
/* Variables */
let _width,
    _height,
    _font_size,
    _letters;

function setVariables() {
    _width = _CANVAS.width = document.documentElement.clientWidth;
    _height = _CANVAS.height = document.documentElement.clientHeight;
    // Font-size equals 3vh
    _font_size = Math.trunc(_height * 0.03);
    // Initial array equals [1,1,...,1] where count equals width divided by font-size
    _letters = Array(Math.round(_width / _font_size) + 1).join("0").split('');
}

function getComputedStylePropertyValue(element, property) {
    return getComputedStyle(document.querySelector(element)).getPropertyValue(property);
}

/*
 Example rgb(0, 0, 0) -> rgba(0, 0, 0, 1)
 */
function getRGBAofRGB(rgb, alpha) {
    // If rgb have not RGB format or alpha more that 1 or less that 0
    if (rgb.search(/rgb\((\d{1,3})[ ,] ?(\d{1,3})[ ,] ?(\d{1,3})\)/gi) === -1 || alpha > 1 || alpha < 0)
        return "rgba(0, 128, 0, 0.15)";
    let buf = rgb.trim();
    // Delete rgb and ()
    buf = buf.substring(4, buf.length - 1);
    // Initialize array of [0,0,0] or [0 0 0]
    let arr = buf.indexOf(',') === -1 ?
        buf.split(" ", 3) :
        buf.split(",", 3);
    // If array not have 3 items
    if (arr.length !== 3) return "rgba(0, 128, 0, 0.15)";
    return "rgba(" + arr[0].trim() + ", " + arr[1].trim() + ", " + arr[2].trim() + ", " + alpha + ")";
}

function setBgMatrix() {
    _CANVAS_CONTEXT.font = _font_size + 'px sans-serif';
    // Background-color equals body's background-color
    _CANVAS_CONTEXT.fillStyle=getRGBAofRGB(getComputedStylePropertyValue(":root", "--rgb-body-background"), 0.15);
    _CANVAS_CONTEXT.fillRect(0,0, _width, _height);
    // Color text equals background-color header and footer
    _CANVAS_CONTEXT.fillStyle=getComputedStylePropertyValue(":root", "--header-footer-background");
    _letters.map(function(y_pos, index) {
        // Random symbol
        let _text = String.fromCharCode(Math.floor(Math.random() * 65535));
        // Position on X
        let _x_pos = index * _font_size;
        // Set symbol on X and Y
        _CANVAS_CONTEXT.fillText(_text, _x_pos, parseInt(y_pos));
        // If y_pos more that height + random (true return 0, false + font-size)
        _letters[index] = (y_pos > _height + Math.random() * _height) ? 0 : y_pos + _font_size;
    });
}

// Initialize variables
setVariables();

function setMobileVersion() {
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
    setTimeout(function() {
        _CANVAS.classList.remove('preloader');
    }, 1000);
    setMobileVersion();
};

window.onresize = function() {
    setVariables();
    setMobileVersion();
};

setInterval(setBgMatrix, 1000 / 30);
