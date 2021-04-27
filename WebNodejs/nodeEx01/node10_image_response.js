/**
 * 웹브라우저에 이미지 표시
 */

var http = require('http');
var fs = require("fs");

var server = http.createServer((req, res)=>{
	
	//이미지 파일을 읽기를 하여 response 쓰기
	// 			    파일명		,콜백함수
	fs.readFile("../img/001.png", function(error, data){
		res.writeHead(200, {"Content-Type":"image/png"});
		res.write(data);
		res.end();
		console.log("이미지 전송완료");
	});
});

server.listen(13001, ()=>{
	console.log("server start ............       http://localhost:13001");
});
