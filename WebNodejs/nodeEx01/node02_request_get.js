// 	1.http모듈을 객체생성
var http = require('http');

//접속한 url을 객체화 하기위해서 생성한다.
var url = require('url');

//접속한 url에서 변수와 데이터를 객체로 만드는 모듈을 생성한다.
var queryString = require('querystring');

//2. http객체를 이용해서 서버생성
var server = http.createServer((request, response)=>{
	//클라이언트에서 =====get방식=========으로 데이터를 서버로 보낸 경우
	//1) 클라이언트가  접속한 url주소를 파싱한다.
	 var parseUrl = url.parse(request.url);
	 
	 //2) 파싱된 url을 이용하여 String만 따로 객체를 생성하여 json으로 넘긴다.
	 var parseQuery = queryString.parse(parseUrl.query, '&', '=');
	 
	 
	 /*
	  json형식은 이렇게 만들어져 있다 만든건 
	  {"num":1234, "username":"홍길동","tel":"010-1234-1234"} 
	   
	  */
	 //서버가 받은 데이터를 클라이언트에게 보내기
	 response.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
	 response.write('<h1>Get방식의 데이터 전송</h1>');
	 response.write('<ol>');
	 response.write('<li>번호 : ' + parseQuery.num+"</li>");
	 response.write('<li>이름 : ' + parseQuery.name + "</li>");
	 response.write('<li>전화번호 : ' + parseQuery.tel + "</li>");
	 response.write("</ol>");
	 response.end('<a href="http://127.0.0.1:10002?num=4321&name=이강산&tel=010-3333-1111">클릭</a>')
});

//3. 접속대기
server.listen(10002, ()=>{
	console.log("server is runnig 	http://127.0.0.1:10002?num=1234&name=홍길동&tel=010-1111-2222")
});