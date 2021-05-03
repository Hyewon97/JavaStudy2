/**
 * http://127.0.0.1:15005/home
 */
/* package.json에 ejs추가 */

var http = require('http');
var fs = require('fs');
var mime = require('Mime');

var express = require('express');
var requestip = require('request-ip');
var ejs = require('ejs');

//================JDBC================================
var oracledb = require('oracledb');

oracledb.autoCommit = true;//자동커밋이 되도록 설정한다.
//db연결정보 설정

var conn; //db연결정보를 보관할 전역변수
oracledb.getConnection({
	user : 'c##scott',
	password : 'tiger',
	connectString : 'localhost:1521/xe'},
	function(error, con){//연결이 완료되거나 에러가 발생하면 호출되는 콜백함수
			if(error){//연결실패시
				console.log("DB연결실패하였습니다.")
			}else{//연결 성공시
				conn = con;
			}
		}
	);
//========================================

//express 객체 생성
var app = express();
var server = http.createServer(app);

//============post 방식 전송시 데이터 pasrser 설정=====================================
var bodyParser = require('body-parser');
app.use(express.static(__dirname)); //express에 기본 디렉토리 설정
app.use(bodyParser.urlencoded({extended:true}));//한글인코딩 세팅

//서버에 접속시 get방식으로 접속하면 get(), post방식은 post() 메소드를 호출한다.
app.get('/home',(req,res)=>{
   fs.readFile(__dirname+"\\home.html","utf-8",(error,data)=>{
      if(error){
         res.writeHead(200,{"Content-Type":"text/html; charset=utf-8"});
         res.end("File Read Error ~!!");
      }else{
         res.writeHead(200,{"Content-Type":"text/html; charset=utf-8"});
         res.end(data);
      }
   });
});

//이미지 처리
app.get('/img/*', function(req, res){
	var path = req.url; // img/001.png
	var imgMime = mime.getType(path.substring(1));
	
	fs.readFile("../"+path, function(error, data){
		if(!error){
			res.writeHead(200, {"Content-Type":imgMime});
			res.end(data);
		}
	});
});

//게시판 목록
app.get('/list', (req,res)=>{
	//데이터베이스 조회
	var sql="select no, subject, userid, hit, to_char(writedate, 'MM-DD HH:MI') writedate from board order by no desc";
	
	//쿼리문 실행
	conn.execute(sql, function(error, result){
		if(error){
			//레코드 선택에러
			res.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
			res.end("<script>location.href='/home';</script>");
		}else{
			//레코드 선택시
			console.log(result);
			fs.readFile('boardList.ejs', 'utf-8', function(error, data){
				if(error){
					res.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
					res.end("<script>location.href='/home';</script>");
				}else{
					//총 레코드 수
					var totalRecord = result.rows.length;
					console.log(totalRecord);
					
					res.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
					//ejs페이지에서 사용할 데이터는 ejs페이지에 render하여 보낸다.
					//					ejs소스코드
					res.end(ejs.render(data, {
						results : result,
						totalrecord : totalRecord,
						parsing:{
							firstPage : 6,
							lastPage : 10,
							totalPage : 9,
							currentPage: 7
						}
						
					}));
				}
				
			});
		}
	});
	
   /*fs.readFile(__dirname+"\\boardList.ejs", (error,data)=>{
      if(!error){
         res.writeHead(200,{"Content-type":"text/html; charset=utf-8"});
         res.end(data);
      }
   });*/
});
//글쓰기 폼
app.get("/boardWrite", (req, res)=>{
   fs.readFile(__dirname+"\\boardWrite.html", "utf-8" , function(error, data) {
      if(error){
         res.writeHead(200,{"Content-Type":"text/html; charset=utf-8"});
         res.end("File Read Error ~!!");
      }else{
         res.writeHead(200,{"Content-Type":"text/html; charset=utf-8"});
         res.end(data);
      }
   })
});

//글쓰기 완료
app.post('/writeOk', function(req, res){
	//클라이언트 폼의 데이터를 서버로 request
	var userid = req.param('userid');
	var subject = req.param('subject');
	var content = req.param('content');
	
	//접속자의 ip를 구한다.
	var ip = requestip.getClientIp(req); // ::ffff:127.0.0.1로 구해짐
	console.log('writeOk data=> userid=%s, subject=%s, content=%s, ip=%s', userid, subject, content, ip);
	
	var sql = "insert into board(no, userid, subject, content, ip, hit, writedate) "+
		" values(boardsq.nextval, '"+userid+"','"+subject+"','"+content+"','"+ip+"', 0, sysdate)";
	console.log("writeOk sql => ", sql);
	
	//데이터 베이스에 글등록
	//				쿼리문, 콜백함수
	conn.execute(sql,function(error, result){
		if(error){//등록실패
			res.writeHead(200, {"Content-Type":"text/html; charset=urf-8"});
			res.write("<script>");
			res.write("alert('글등록이 실패하였습니다.')");
			res.write("location.href='/boardWrite'");
			res.end("</script>");
		}else{//등록성공
			res.writeHead(200,{"Content-Type":"text/html; charset=utf-8"});
			res.write("<script>alert('글이 등록되었습니다.'); location.href='/list'");
			res.end("</script>");
		}
	});
	
});

//글내용 보기
app.get('/boardView', function(req, res){
	//1. 글번호 request
	var no = req.param('no');
	//2. 조회수 증가
	var sql = "update board set hit = hit+1 where no="+ no;
	conn.execute(sql, function(error, result){
		if(error){
			console.log("조회수 증가 에러....");
		}else{
			console.log("조회수 증가됨");
		}
	});
	//3. 레코드 선택하여 ejs에다 랜더링해서 보내기
	//CLOB 데이터 형처럼 대용량 데이터인 경우 변수(DBMS_LOB.SUBSTR()함수를 이용하여 레코드를 선택해야한다.
	var sql2="select no, userid, subject, DBMS_LOB.SUBSTR(content, DBMS_LOB.GETLENGTH(content)), hit, writedate " + 
	 		 " from board where no="+no;
	
});
//==================================================
server.listen(15001, ()=>{
   console.log("서버시작 http://127.0.0.1:15001/home");
})