/**
 * http://127.0.0.1:14002/chatForm
 */

var http = require('http');
var fs = require('fs');

var server = http.createServer((req, res)=>{
	
	var mapping = req.url;
	
	if(mapping =="/chatForm"){
		fs.readFile(__dirname+'\\chatingForm1.html','utf-8',(error, data)=>{
			if(error){
				//읽기실패
				res.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
				res.end("html 문서 읽기 실패");
			}else{
				//읽기성공
				res.writeHead(200,{"Content-Type":"text/html; charset=utf-8"});
				res.end(data);
			}
		});
	}else{
		//url이 잘못접속되었을때
		res.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
		res.end("404 error page");
	}
});

server.listen(14005, ()=>{
	console.log("server start     http://127.0.0.1:14005/chatForm")
});


//===================socket.io===========================
var socketio = require('socket.io')

//1) 소켓서버를 생성 및 실행
var io = socketio.listen(server);

//2) 클라이언트가 서버에 접속하면 접속을 받을 이벤트를 생성한다.
//               이벤트종류 -->아무거나 막써도댐
io.sockets.on('connection', function(socket){
	console.log("Client가 접속하였습니다!!!!!!!!!1");
	
	//클라이언트와 통신할 이벤트 생성
	socket.on('hello',function(data){
		console.log("Sever가 받은 메세지 : ", data);
		
		//[1] 클라이언트에게 서버가 문제보내기 이벤트 발생
		socket.emit('echo', data+'(Welcome....)');
	});
});
