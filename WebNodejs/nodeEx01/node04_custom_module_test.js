var http = require('http');

var myModule= require("./node04_custom_module_create");
var server = http.createServer(function(request, response){
	response.writeHead(200,{"Content-type":"text/html; charset=utf-8"});
	
	//모듕명.변수명
	response.write("<ol><li> 번호 : " + myModule.num+ "</li>");
	response.write("<li>아이디 : " + myModule.userid + "</li>");
	response.write("<li>주소 : " + myModule.addr+ "</li>");
	
	//모듈명.함수명()
	response.write("<li>msg() : "+myModule.msg() + "</li>");
	response.write("<li>hap(6,7) : " + myModule.hap(6,7) + "</li>");
	response.end("<li>gugudan(7)<Br/> : " + myModule.gugudan(7) + "</li></ol>");
	
});

server.listen(12000, function(){
	console.log("server start .... http://127.0.0.1:12000");
});