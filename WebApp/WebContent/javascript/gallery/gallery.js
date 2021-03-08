//이미지넣기
var imgTag="";
for(var i=1; i<=5; i++){
    for(var j=1; j<=15; j++){
        if(j<10){
            imgTag +="<img src='img/00"+j+".png' onclick='modalClick(this.src)'/>";
        }
        if(j>=10){
            imgTag +="<img src='img/0"+j+".png' onclick='modalClick(this.src)'/>";
        }
    }
    document.getElementById("imgLst").innerHTML = imgTag;
}

//클릭시 닫기
function close111(){
    document.getElementById("modalback").style.display="none";
    document.getElementById("modal").style.display="none";
    document.getElementById("imgLst").style.display="block";
}

//이동
var popup;
var eventX, eventY, divX, divY, moveX, moveY, flag=false;
function setMoveStart(){
    //마우스를 클릭했을때 ture로바꿔줌
    flag=true;

    //마우스를 누르면 이벤트가 발생한 곳의 x,y 좌표를 구한다.
    eventX = event.clientX;
    eventY = event.clientY;
    
    //팝업창의 좌표 구하기
    divX = parseInt(popup.left);
    divY = parseInt(popup.top);
    
    //마우스를 이동하면 이동한 곳의 좌표를 구한다 이벤트 x, y 좌표를 구한다.
    document.onmousemove = setMouseDrag;
}
//드래그하면 움직이기
function setMouseDrag(){
    if(flag){
        moveX = event.clientX;
        moveY = event.clientY;

        //나중에 발생한 이벤트 좌표 - 이전에 발생한 이벤트 좌표
        var x = moveX - eventX;
        var y = moveY - eventY;

        //팝업 이동하기
        popup.left = divX + x + "px";
        popup.top = divY + y + "px";
    }
}
//드래그 놓으면
function setFlag(){
    flag = false;
}
document.onmouseup = setFlag;

//모달에 내용집어넣기
function modalClick(selImg){
    document.getElementById('imgName').innerHTML= selImg.substr(selImg.length-7, 7); //이름
    document.getElementById("modalImg").src = selImg; //사진

    //block으로만들어서 보여주게함
    document.getElementById('modal').style.display='block';
    document.getElementById('modalback').style.display='block';

    var xx = event.clientX -750;
    var yy = event.clientY - 370;
    console.log("z =" + xx + "  y = " + yy)
    popup= document.getElementById("modal").style
    popup.left= xx +"px";
    popup.top= yy +"px";
}z