	var nowDate = new Date(); //현재 날짜, 시간
	document.write("nowDate = " + nowDate);
	
	/* 
		요일: getDay()	일요일:0, 월요일:1 ........	토요일:6
	*/
	document.write("<br/>요일 -> "+ nowDate.getDay());
	
	//마지막날
	var date = new Date(nowDate.getFullYear(), nowDate.getMonth()+1, 0);
	document.write("<br/>마지막날 --> "+ date.getDay());
	
	todayYear = today.getFullYear();
	todayMonth = today.getMonth() + 1; // 월은 0부터 시작하기때문에 + 1을 해줘야지 해당 달의 월이 나온다.
	today_yearMonth = todayYear + " - " + todayMonth;
	document.getElementById("yearMonth").innerHTML= today_yearMonth;
	let firstDate = new Date(today.getFullYear(), today.getMonth(),1);
	let lastDate = new Date(today.getFullYear(), today.getMonth()+1,0);
	let day = firstDate.getDay();
	let calendar = document.getElementById("calendar_table");
	let week = Math.ceil(lastDate.getDate()/7) + 1;
	
	
	function threeMonth(){
	 	var day
	}