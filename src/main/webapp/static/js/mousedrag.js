$(document).ready(function()
 {
  $(".box").mousedown(function(e)
  {
    $(".box").css("cursor","move");
    var offset = $(this).offset();
    var x = e.pageX - offset.left;
    var y = e.pageY - offset.top;
    $(document).bind("mousemove",function(ev)
    {
      $(".box").stop;
      var _x = ev.pageX - x;
      var _y = ev.pageY - y;
      $(".box").animate({left:_x+"px",top:_y+"px"},10);
      
    });
  });
  $(document).mouseup(function(){

    $(this).unbind("mousemove");
  })
 })