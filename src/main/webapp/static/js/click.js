
    $(document).ready(function ()  { 
    $(".click").on('click', function () {
      $(document.body).append("<div id='mask'></div>");
      $("#mask").addClass("mask").fadeIn("fast");
      $("#detail").fadeIn("fast");
    });

    $("#save").on('click', function () {
      $(document.body).append("<div id='mask'></div>");
      $("#mask").addClass("mask").fadeIn("fast");
      $("#new_password").fadeIn("fast");
    });

    $(".add").on('click', function () {
      $(document.body).append("<div id='mask'></div>");
      $("#mask").addClass("mask").fadeIn("fast");
      $("#adduser").fadeIn("fast");
    });

     $(".manage_userInfo").on('click', function () {
      $(document.body).append("<div id='mask'></div>");
      $("#mask").addClass("mask").fadeIn("fast");
      $(".userInfo").fadeIn("fast");
    });

     $(".relatpro").on('click', function () {
      $(document.body).append("<div id='mask'></div>");
      $("#mask").addClass("mask").fadeIn("fast");
      $(".ralated_product").fadeIn("fast");
    });


    $(".close_btn").on('click', function () {
      $(".close_btn").parent().parent().fadeOut("fast");
      $("#mask").css({ display: 'none' });
    });

    });
