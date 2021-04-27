var http = require('http');

var server = http.createServer(function(req, res){
	console.log("request.url = " + req.url);
//	var reqUrl = url.parse(request.url);
//	console.log("requset.url " + reqUrl);
	
	if(req.url=="/name"){
		res.writeHead(200, {"Content-Type": "text/html;charset=utf-8"});
		res.end("이름은 홍길동입니다.")
	}else if(req.url=="/address"){
		res.writeHead(200, {"Content-Type": "text/html;charset=utf-8"});
		res.end("주소는 서울시 마포구 백범로입니다.")
	}else if(req.url=="/tel"){
		res.writeHead(200, {"Content-Type": "text/html;charset=utf-8"});
		res.end("연락처는 모릅니다.")
	}else{
		//404 page
		res.writeHead(200, {"Content-Type": "text/html;charset=utf-8"});
		res.end("404에러입니다.")
	}
});

server.listen(12007, function(){
	console.log("server start .... http://localhost:12007")
});