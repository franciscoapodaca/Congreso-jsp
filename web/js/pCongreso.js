/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function toggle2(div_id) {
    var el = document.getElementById(div_id);
    if ( el.style.display == 'none' ) { el.style.display = 'block';}
    else {el.style.display = 'none';}
}
function blanket_size2(popUpDiv2Var) {
    if (typeof window.innerWidth != 'undefined') {
        viewportheight = window.innerHeight;
    } else {
        viewportheight = document.documentElement.clientHeight;
    }
    if ((viewportheight > document.body.parentNode.scrollHeight) && (viewportheight > document.body.parentNode.clientHeight)) {
        blanket_height = viewportheight;
    } else {
        if (document.body.parentNode.clientHeight > document.body.parentNode.scrollHeight) {
            blanket_height = document.body.parentNode.clientHeight;
        } else {
            blanket_height = document.body.parentNode.scrollHeight;
        }
    }
    var blanket = document.getElementById('blanket');
    blanket.style.height = blanket_height + 'px';
    var popUpDiv2 = document.getElementById(popUpDiv2Var);
    popUpDiv2_height=blanket_height/2-200;//200 is half popup's height
    popUpDiv2.style.top = popUpDiv2_height + 'px';
}
function window_pos2(popUpDiv2Var) {
    if (typeof window.innerWidth != 'undefined') {
        viewportwidth = window.innerHeight;
    } else {
        viewportwidth = document.documentElement.clientHeight;
    }
    if ((viewportwidth > document.body.parentNode.scrollWidth) && (viewportwidth > document.body.parentNode.clientWidth)) {
        window_width = viewportwidth;
    } else {
        if (document.body.parentNode.clientWidth > document.body.parentNode.scrollWidth) {
            window_width = document.body.parentNode.clientWidth;
        } else {
            window_width = document.body.parentNode.scrollWidth;
        }
    }
    var popUpDiv2 = document.getElementById(popUpDiv2Var);
    window_width=window_width/2-400;//200 is half popup's width
    popUpDiv2.style.left = window_width + 'px';
}
function popup2(windowname) {
    blanket_size2(windowname);
    window_pos2(windowname);
    toggle2('blanket');
    toggle2(windowname);     
}