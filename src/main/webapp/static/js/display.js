
    $(document).ready(function () {
        $("#menu1").click(function(){ 
          $("#tab1").css("display","block");
          $("#tab2").css("display","none");
          $("#tab3").css("display","none");
          $("#tab4").css("display","none");
          $("#tab5").css("display","none");
      })
        $("#menu2").click(function(){ 
          $("#tab2").css("display","block");
          $("#tab1").css("display","none");
          $("#tab3").css("display","none");
          $("#tab4").css("display","none");
          $("#tab5").css("display","none");
      })
        $("#menu3").click(function(){ 
          $("#tab3").css("display","block");
          $("#tab1").css("display","none");
          $("#tab2").css("display","none");
          $("#tab4").css("display","none");
          $("#tab5").css("display","none");
      })
        $("#menu4").click(function(){ 
          $("#tab4").css("display","block");
          $("#tab1").css("display","none");
          $("#tab3").css("display","none");
          $("#tab2").css("display","none");
          $("#tab5").css("display","none");
      })
        $("#menu5").click(function(){ 
          $("#tab5").css("display","block");
          $("#tab1").css("display","none");
          $("#tab3").css("display","none");
          $("#tab4").css("display","none");
          $("#tab2").css("display","none");
      })
    });

