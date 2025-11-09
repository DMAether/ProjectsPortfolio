var scroll;
var screen_1 = true;
var screen_2 = false;
var screen_3 = false;
var _1;
var _2;
var _3;
window.onload = function() {
    _1 = document.getElementById('who');
    _2 = document.getElementById('how');
    _3 = document.getElementById('delivery');
};
window.onscroll = function() {
    //console.log(document.documentElement.scrollTop);
    scroll = document.documentElement.scrollTop;
    if (scroll >= 300 && screen_1) {
        _1.classList.add('hide');
        screen_1 = false;
    } else if (scroll <300 && !screen_1) {
        _1.classList.remove('hide');
        _1.classList.add('show');
        _1.classList.remove('show');
        screen_1 = true;
    }
    if(scroll >= 300 && scroll < 800 && !screen_2) {
        _2.classList.add('show');
        screen_2 = true;
    } else if(screen_2 && scroll >= 800) {
        _2.classList.remove('show');
        _2.classList.add('hide');
        screen_2 = false;
    } else if (screen_2 && scroll <300) {
        _2.classList.remove('show');
        _2.classList.add('hide');
        screen_2 = false;
    }
    if(scroll >= 800 && !screen_3) {
        _3.classList.add('show');
        screen_3 = true;
    } else if(scroll < 800 && screen_3) {
        _3.classList.remove('show');
        _3.classList.add('hide');
        screen_3 = false;
    }

};

function redirect(page) {
    window.location.replace('./'+ page + '.html');
}