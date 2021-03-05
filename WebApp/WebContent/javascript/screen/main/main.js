function imageMover(){
    var x=0;
    var y=0;
    var stepX = -5;
    var stepY = -5;
    var nabi = document.getElementById("nabi");
    console.log(x);
    x = x +stepX;
    y = y +stepY;
    nabi.style.left = x+ "px";
    nabi.style.top = y+"px";
    if(x<=-1000){
        stepX =5;
    }
    if(y<=-850){
        stepY =5;
    }
    if(x==350){
        stepX = -5;
    }
    if(y==0){
        stepY = -5;
    }
}
function previous(){
    history.go(-1);
}