var nowDate = new Date(); //현재 날짜, 시간
	var todayMonth = nowDate.getMonth() + 1;  //현재 월
	document.getElementById("monthPane").innerHTML = todayMonth + "월";
		
	//첫번째날
	var firstDate = new Date(nowDate.getFullYear(), nowDate.getMonth(),1);
	
	//마지막날
	var lastdate = new Date(nowDate.getFullYear(), nowDate.getMonth()+1, 0);

	//1일
	var day = firstDate.getDay();
	
	//주     	2월기준 5주
	var week = Math.ceil(lastdate.getDate()/7) + 1;
	
	//쓰일 달력변수
	var calendar = document.getElementById("calendar_table");
	
	//이번달 달력구현
	function Calender(){
		var leftDays = 7;
		var setDays = 1;
			for(i = 1; i < week; i++){
				var row = calendar.insertRow();
				while(day != 0){
					row.insertCell().innerHTML = "";
					day -= 1;
					leftDays -= 1;
				} // 1주
				while(leftDays != 0){
					if(setDays > lastdate.getDate()){
						row.insertCell().innerHTML = "";
						leftDays -= 1;
					}else{
						row.insertCell().innerHTML = setDays;
						setDays +=1;
						leftDays -= 1;
					}
				}
				leftDays = 7;
			}
	}
	Calender()