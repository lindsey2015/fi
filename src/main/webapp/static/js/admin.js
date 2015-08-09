$(document).ready(function() {
    $('#menu').tabify();
    $('#menu2').tabify();
});

function selectALL(name) {
    var all = document.getElementsByName("selectall");
    var el = document.getElementsByName("select");
    for (var i = 0; i < el.length; i++) {
        if (el[i].type == "checkbox" && el[i].name == name) {
            el[i].checked = !el[i].checked;

        }
    }
}

$(function() {
    $(".div2").click(function() {
        $(this).next("div").slideToggle("fast").siblings(".div3:visible").slideUp("fast");
    });
});