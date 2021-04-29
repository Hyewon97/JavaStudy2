/**
 * http://127.0.0.1:15005/home
 */
/* package.json에 ejs추가 */

var http = require('http')
var fs = require('fs')
var mime = require('Mime');

var express = require('express');

//express 객체 생성
var app = express();
var server = http.createServer(app);

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
//게시판 목록
app.get('/list', (req,res)=>{
   fs.readFile(__dirname+"\\boardList.ejs", (error,data)=>{
      if(!error){
         res.writeHead(200,{"Content-type":"text/html; charset=utf-8"});
         res.end(data);
      }
   });
});
//글쓰기 폼
app.get("/boardWrite", (req, res)=>{
   fs.readFile(__dirname+"\\boardWrite.ejs", "utf-8" , function(error, data) {
      if(error){
         res.writeHead(200,{"Content-Type":"text/html; charset=utf-8"});
         res.end("File Read Error ~!!");
      }else{
         res.writeHead(200,{"Content-Type":"text/html; charset=utf-8"});
         res.end(data);
      }
   })
});

//==================================================
server.listen(15000, ()=>{
   console.log("서버시작 http://127.0.0.1:15000/home");
})