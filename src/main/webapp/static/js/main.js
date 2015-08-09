$(function() {
    $(".div2").click(function() {
        $(this).next("div").slideToggle("fast").siblings(".div3:visible").slideUp("fast");
    });
});

$(document).ready(function() {
    $(".save").on('click', function() {
        $(document.body).append("<div id='mask'></div>");
        $("#mask").addClass("mask").fadeIn("slow");
        $(".newpassword").fadeIn("slow");
    });

    $(".close_btn").on('click', function() {
        $("#new_password").fadeOut("fast");
        $("#mask").css({
            display: 'none'
        });
    });
});

$(document).ready(function() {
    $('#menu').tabify();
    $('#menu2').tabify();
});

function ShowHidden() {
    var obj = document.getElementById("vehicle");
    var txtShowHidden = document.getElementById("ShowHidden"); 
    var txtShowHidden1 = document.getElementById("ShowHidden1");
    if (obj.value == "全程陆运") {
        txtShowHidden.style.display = "block";
        txtShowHidden1.style.display = "none";
    } else {
        txtShowHidden1.style.display = "block";
        txtShowHidden.style.display = "none";
    }
}

$(document).ready(function() {
    $(".newpassword").mousedown(function(e) {
        $(".newpassword").css("cursor", "move");
        var offset = $(this).offset();
        var x = e.pageX - offset.left;
        var y = e.pageY - offset.top;
        $(document).bind("mousemove", function(ev) {
            $(".newpassword").stop;
            var _x = ev.pageX - x;
            var _y = ev.pageY - y;
            $(".newpassword").animate({
                left: _x + "px",
                top: _y + "px"
            }, 10);
        });
    });
    $(document).mouseup(function() {
        $(this).unbind("mousemove");
    });
});