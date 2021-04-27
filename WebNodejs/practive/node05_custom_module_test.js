var http= require('http');
var myModule= require("./node05_custom_module_create");
var querystring = require('querystring');

var server = http.createServer(function(request, response){
	
	//1. post방식의 데이터가 서버로 전송되면 date이벤트가 발생함
	var postData=""
	request.on('data',function(data){
		postData += data;
	});
	
	//2. data 이벤트가 끝나면 자동으로 end이벤트가 발생한다.
	request.on('end', function(){
		//post로 전송된 postData의 값을 json을 변환하여 사용한다.
		var parseQuery = querystring.parse(postData);
		response.writeHead(200, {"Content-Type": "text/html;charset=utf-8"});
		response.write("입력받은수의 짝수합 : " + myModule.even(parseQuery.num) + "<br/>");
		response.write("입력받은수의 홀수합: " + myModule.odd(parseQuery.num)+"<br/>");
		response.end("입력받은수의 합: " + myModule.sum(parseQuery.num)+"<br/>");
	});
});

server.listen(10004, function(){
	console.log('server start ...... http://localhost:10004');
});