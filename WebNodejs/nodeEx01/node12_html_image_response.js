/**
 * html문서를 파일읽기를 하여 웹페이지 쓰기
 */

var http = require('http');
var fs = require('fs');
var mime = require('Mime');

var server = http.createServer((req, res)=>{
	console.log("request.url==>" + req.url);
	var pathname = req.url;
	if(pathname=='/hello'){
		//비동기식으로 node_hello.html을 파일읽기하여 response에 쓰기한다.
		fs.readFile(__dirname+"\\node12_hello.html", 'utf-8', (err, data)=>{
			if(err){
				console.log("html읽기 실패");
			}else{
				res.writeHead(200, {"Content-Type":"text/html;charset=utf-8"});
				res.end(data);
			}
		});
		//					/img/001.png
	}else if(pathname=='/node12_hello1'){
		//비동기식으로 node_hello.html을 파일읽기하여 response에 쓰기한다.
		fs.readFile(__dirname+"\\node12_hello1.html", 'utf-8', (err, data)=>{
			if(err){
				console.log("html읽기 실패");
			}else{
				res.writeHead(200, {"Content-Type":"text/html;charset=utf-8"});
				res.end(data);
			}
		});
	}else if(pathname=='/node12_hello2'){
		//비동기식으로 node_hello.html을 파일읽기하여 response에 쓰기한다.
		fs.readFile(__dirname+"\\node12_hello2.html", 'utf-8', (err, data)=>{
			if(err){
				console.log("html읽기 실패");
			}else{
				res.writeHead(200, {"Content-Type":"text/html;charset=utf-8"});
				res.end(data);
			}
		});
	}else if(pathname=='/node12_hello3'){
		//비동기식으로 node_hello.html을 파일읽기하여 response에 쓰기한다.
		fs.readFile(__dirname+"\\node12_hello3.html", 'utf-8', (err, data)=>{
			if(err){
				console.log("html읽기 실패");
			}else{
				res.writeHead(200, {"Content-Type":"text/html;charset=utf-8"});
				res.end(data);
			}
		});
	}else if(pathname.indexOf("/img")==0){ // /img/이미지 파일명으로 접속 했을때
		//Mime --> getType(경로와 파일명), mime --> liikup(경로와 파일명)
		var imgPath = pathname.substring(1);
		var mimeType = mime.getType(imgPath); // img/001.png
		console.log(pathname + "====> " + mimeType);
		fs.readFile("../"+ imgPath,(error, imgData)=>{
			if(error){//fail
				console.log(imgPath+"읽기 실패..");
			}else{//success
				res.writeHead(200,{"Content-Type": mimeType});
				res.end(imgData);
			}
			
		});
		
	}else{
		res.writeHead(200, {"Content-Type":"text/html;charset=utf-8"});
		res.end("404 에러페이지");
	}
});

server.listen(13004, ()=>{
	console.log("server start       http://localhost:13004/hello");
});	