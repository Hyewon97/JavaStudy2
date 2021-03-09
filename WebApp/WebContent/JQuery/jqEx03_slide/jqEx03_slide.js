$(function(){
    //마우스 오버: 사진 내려오기 아웃 사진올라가기
    $('#menu').hover(function(){
        //마우스 오버일떄 실행
        $('#labbel1').slideDown();
    }, function(){
        //마우스를 벗어나면 실행됨
        $('#labbel1').slideUp();
    })
    $('#about').hover(function(){
        //마우스 오버일떄 실행
        $('#labbel2').slideDown();
    }, function(){
        //마우스를 벗어나면 실행됨
        $('#labbel2').slideUp();
    })
    $('#work').hover(function(){
        //마우스 오버일떄 실행
        $('#labbel3').slideDown();
    }, function(){
        //마우스를 벗어나면 실행됨
        $('#labbel3').slideUp();
    })
    $('#contact').hover(function(){
        //마우스 오버일떄 실행
        $('#labbel4').slideDown();
    }, function(){
        //마우스를 벗어나면 실행됨
        $('#labbel4').slideUp();
    })
 });