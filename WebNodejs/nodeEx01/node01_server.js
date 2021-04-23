/*
	=========준비사항 ==========
	1. nodejs.org에서 다운로드 후 설치 https://nodejs.org/dist/v14.16.1/node-v14.16.1-x64.msi
	2. 이클립스에서 help > eclipse-marketplace 선택후 node검색후 Enide.psf를 인스톨한다.
	
	
*/

//(1번에서 설치된파일에 들어가면 있음) 없는 모듈일 경우 추가설치를 해야한다.
//node.js는  http 모듈이 있다. -->http모듈을 객체로 만든후 서버를 생성한다.
//							  require()함수는 모듈을 객체로 만드는 함수이다.
var http = require('http');

//2. 서버 생성하기
var server = http.createServer(function(request, response){
	//1. 클라이언트 서버에 접속하면 실행할 실행문을 기술하는 곳이다.
	
	//2. 서버에서 클라이언트에 데이터 또는 정보를 보내는 것은 response 객체를 이용한다.
	//1) header셋팅
	response.writeHead(200, {'Content-Type':'text/html;charset=utf-8'});
	//2) 클라이언트에게 보낼 페이지 내용
	response.write('<h1>노드 js 서버에서 보낸 데이터');
	response.write('<ul><li>첫번째 데이터</li>');
	response.write('<li>두번쨰 데이터</li></ul>');
	
	//3) 마지막 전송 데이터 표시
	response.end('<h2>마지막으로 보낸 문자</h2>');
	
});

//3. 접속대기 - 클라이언트가 서버에 접속하기를 기다린다.
			//현재 서버의 접속포트를 적는다 -> 2^16:65500개
server.listen(10001, function(){
	console.log("server is runnig 	http://127.0.0.1:10001		");
	console.log("server is runnig	http://localhost:10001		");
});
