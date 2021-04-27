/**
 	http모듈
 	
 	노드js 전역변수
 	[1] __filename : 현재 실행중인 파일의 파일명과 절대경로
 	[2] __dirname : 현재 실행중인 파일의 절대경로가 저장되어 있는 변수
 	
 */

var http = require('http');

var server = http.createServer(function(request, response){
	
	console.log("Create server........");
	response.writeHead(200, {"Content-Type":"text/html;charset=utf-8"});
	response.write("<h1>HTTP 모듈테스트 </h1>");
	response.write("__filename : " + __filename + "<br/>");
	response.write("__dirname : " + __dirname + "<br/>");
	response.end();
});

//1. 클라이언트가 서버에 접속하면 발생하는 이벤트 : connection 이벤트
server.on('connection',function(code){
	console.log("Connection Event = " + code);
	server.emit('close');
});

//2. 클라이언트가 서버에 요청을 보낼떄 발생하는 이벤트 : request
server.on('request',function(code){
	console.log("Request Event = " + code);
});

// 3. response  서버에서 클라이언트에게 발생하는 이벤트 : response
server.on('response', function(code){
	console.log("respsone Event = " + code);
});

//4. 서버가 종료되면 발생하는 이벤트 : close 
server.on('close', function(code){
	console.log("Close event = " + code);
});


//클라이언트가 접속을 하면 다음진행을 할수 있도록 접속을 대기하는 역할을 한다.
server.listen(12010, function(){
	console.log("server start  ///   http://localhost:12010 ");
});