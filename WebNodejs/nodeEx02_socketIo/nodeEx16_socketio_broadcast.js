/**
 * http://127.0.0.1:14003/chatt
 */
/*jshint esversion: 6 */

var http = require('http');
var fs = require('fs');
var socketio = require('socket.io');

var server = http.createServer((req, res)=>{
	var path = req.url;
	if(path == "/chattBroad"){
		fs.readFile(__dirname + "\\chatingForm1.html", 'utf-8', (error, data)=>{
			res.writeHead(200,{"Content-Type":"text/html;charset=utf-8"});
			if(error){
				res.end("파일읽기 에러")
			}else{
				res.end(data);
			}
		});
	}else{
		res.writeHead(200,{"Content-Type":"text/html;charset=utf-8"});
		res.end("404 Page Error");
	}
});

server.listen(14003, ()=>{
	console.log("server start ...          http://127.0.0.1:14003/chattBroad");
});

////////////////////////////////////////////////////////////////
var io = socketio.listen(server);

//연결이벤트
io.sockets.on('connection', function(socket){
	console.log("클라이언트가 접속함");
	
	//클라이언트가 보낸 문자를 받을 이벤트
	socket.on('hello', function(data){
		console.log("서버가 받은 문자--> " + data);
		//[2] 모든 접속자에게 서버가 데이터 보내기
		socket.broadcast.emit('echo','broadcast--->'+ data);
	});
});


