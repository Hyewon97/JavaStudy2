import java.util.Calendar;
import java.util.Scanner;

public class CalendatEx {

	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in); //스캐너
		Calendar cal = Calendar.getInstance(); //현재 시스템의 날짜, 시간 관련 정보를 객체를 생성한다.
		int year,month; //년도와 월
		
		
		System.out.print("년도 = ");
		year = sc.nextInt();
		System.out.print("월 = ");
		month = sc.nextInt();
		
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		
		System.out.println("           "+year+"년 "+ month+"월" + "        ");
		System.out.println("월	화	수	목	금	토	일");
		
		cal.set(month, 1);
		int day = cal.getActualMaximum(Calendar.DATE);//입력받은 달의 마지막일수를 구하는 함수
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		
		for (int i = 1; i <= day; i++) { //for문을 돌리기위해서는 해당 마지막 일수를 구해야함
			if (i == 1) {
				for (int j = 1; j < dayofweek; j++) {	
					System.out.print("	");
				}
			}
			System.out.print(i);
			for (int j = 0; j < args.length; j++) {
				if(i < day) {
					System.out.print("	");
				}
				System.out.println(i);
				if(day % 7 == 0) {
					System.out.println();
				}
				day++;
			}
		}
		*/
		
		Scanner sc = new Scanner(System.in); //스캐너
		//년도
		System.out.print("년도 = ");
		int year = sc.nextInt();
		
		//월
		System.out.print("월  = ");
		int month =  sc.nextInt();
		
		Calendar date = Calendar.getInstance();//오늘날짜 + 시간
		//날짜를 1일로 바꾸기
		date.set(year, month-1, 1);
		
		//1일에 대한 요일 구하기
		int week = date.get(Calendar.DAY_OF_WEEK);
		
		// 31 -> 1,3,5,7,8,10,12
		// 30 -> 4,6,9,11
		// 28,29 -> 2
		/*
		int lastDay = 31;
		switch(month) {
			case 4 :
			case 6 :
			case 9 :
			case 11 :
				lastDay = 30;
				break;
			case 2 : //출력한 달이 2월일 경우
				if(year%4==0 &&year%100 !=0 || year%400 == 0) {//윤년일때
					lastDay = 29;
				}else {//윤년이 아닐때
					lastDay = 28;
				}
		}*/
		int lastDay = date.getActualMaximum(Calendar.DAY_OF_MONTH);
		//====================================================
		//제목출력
		System.out.printf("\t\t\t%d년 %d월\n", year, month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		//공백출력
		for(int space=1; space<week; space++) {//1,2,3,4
			System.out.print("\t");
		}
		
		//날짜 출력
		for (int day = 1; day <= lastDay; day++) {
			System.out.print((day + "\t"));
			if((day+week-1) % 7 ==0) {  //줄바꿈
				System.out.println();
			}
		}
			
	}

}

















