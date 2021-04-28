/**
 * 동영상 스트리밍 처리하기
 */

var http = require('http');
var fs = require('fs');
var mime = require('Mime');

var server = http.createServer((req, res)=>{
	var mapping =req.url;
	
	if(mapping =="/html"){
		fs.readFile(__dirname+'\\node13_video_image.html','utf-8',(error, data)=>{
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
	}else if(mapping.indexOf("/img")==0){//이미지 접속일 경우 /img/001.png
		//마임 알아내기
		var imgMime = mime.getType(mapping.substring(1)); // 	img/png
		
		fs.readFile(".."+mapping, function(error, imgData){
			if(!error){
				res.writeHead(200, {"Content-Type":imgMime});
				res.end(imgData);
			}else{
				res.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
				res.end("html 문서 읽기 실패");
			}
		});
	}else if(mapping.indexOf("/video")==0){//동영상 파일인 경우
		//1. 스트리밍 처리
		
		//1)Stream 객체 생성
		var stream = fs.createReadStream(".."+mapping);
		//2)파일에서 데이터를 읽었을때 호출되는 이벤트
		var cnt=1;
		stream.on('data',function(videoData){
			console.log(cnt++ , '-->', videoData.length);
			res.write(videoData);
		});
		//3)파일에서 마지막으로 데이터를 읽었을때 호출되는 이벤트
		stream.on('end',function(){
			console.log('end Streamming');
			res.end();
		});
		
		//4)파일을 읽는 과정에서 에러 발생하는 호출되는 이벤트
		stream.on('error', function(error){
			console.log("에러터짐 수구바위 에러터짐 수구바위");
			res.end();
			
		});
		
	}else{
		//url이 잘못접속되었을때
		res.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
		res.end("404 error page");
	}
});

server.listen(14001, ()=>{
	console.log("server start     http://127.0.0.1:14001/html")
});