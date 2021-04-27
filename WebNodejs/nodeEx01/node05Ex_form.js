var http = require('http');

var server = http.createServer(function(request,response){
	response.writeHead(200, {"Content-type": "text/html; charset=utf-8"});
	response.write("<h1>임의의수입력을 받아서 데이터넘겨주기</h1>");
	response.write("<form method='post' action='http://localhost:10004'>");
	response.write("입력할 숫자 : <input type='number' name='num'/><br/>");
	response.write("<input type='submit' value='1부터 입력한수의 합은?'/><br/>");
	response.end("</form>");
});

server.listen(10003, function(){
	console.log("server start!!!!!!!!!!!!!     http://localhost:10003")	
});