function myFunction() {
    $("#helper-text").css("opacity", "0.3");


    var num = Math.round(Math.random() * 12) + 1;
    var value = num;

    if (num == 1) {
        value = "The Wheel of Fortune"
    } else if (num == 11) {
        value ="The Fool"
    } else if (num == 12) {
        value = "The Star"
    } else if (num == 13) {
        value = "The Moon"
    }

    $("#circle").css("-webkit-animation", "flip 1s cubic-bezier(1,.37,.63,.82)")

    setTimeout(function(){$("#number").text(value)}, 500);;
}

$("#circle").bind('oanimationend animationend webkitAnimationEnd', function() {
    $("#circle").css("-webkit-animation", "updown 4s linear infinite")
});