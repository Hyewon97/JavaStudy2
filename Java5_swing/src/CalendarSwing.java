import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarSwing extends JFrame implements ItemListener, ActionListener{
	Font fnt = new Font("굴림체", Font.BOLD, 20);
	
	//상단
	JPanel selectPane = new JPanel(); //패널생성
		JButton prevBtn = new JButton("◀"); //이전버튼
		JButton nextBtn = new JButton("▶"); //다음버튼
		JComboBox<Integer> yearCombo = new JComboBox<Integer>(); //년도 콤보박스추가
		JComboBox<Integer> monthCombo = new JComboBox<Integer>(); //월 콤보박스 추가
		JLabel yearLBl = new JLabel("년");  //"년"을 표시할 라벨 추가
		JLabel monthLBl = new JLabel("월"); //"월"을 표시할 라벨추가
		
	//가운데
	JPanel centerPane = new JPanel(new BorderLayout()); //가운데 패널을 생성하고 borderLayout으로 잡아준다. 
														//borderLayout : 상하좌우 가운데로 나뉘어서 layout을 잡는것
		JPanel titlePane = new JPanel(new GridLayout(1, 7));// 타이틀을 생성시킬 패널을 생성하고 GridLayout으로 잡아준다.
															// GridLayout: 지정된 수의 행과 열을 생성하는 레이아웃이다 1행 7열이므로 일,월,화,수,목,금,토 가 들어가게된다.
			String[] title = {"일", "월", "화", "수", "목", "금", "토"};
		JPanel dayPane = new JPanel(new GridLayout(0, 7)); // 위와 동일하며 날짜가 나오게 된다.
	
	//달력관련 데이터
	Calendar date;
	int year;
	int month;
	
	public CalendarSwing() {
		super("달력");
		date = Calendar.getInstance();//현재의 날짜 시간 객체 생성
		year = date.get(Calendar.YEAR);
		month = date.get(Calendar.MONTH)+1;
		
		//상단
		selectPane.setBackground(new Color(150, 200, 200));
		selectPane.add(prevBtn); prevBtn.setFont(fnt);
		selectPane.add(yearCombo); yearCombo.setFont(fnt);
		selectPane.add(yearLBl); yearLBl.setFont(fnt);
		selectPane.add(monthCombo); monthCombo.setFont(fnt);
		selectPane.add(monthLBl); monthLBl.setFont(fnt);
		selectPane.add(nextBtn); nextBtn.setFont(fnt);
		
		add(BorderLayout.NORTH, selectPane);
		//현재 년, 월 세팅
		setYear();
		setMonth();
		
		//title호출
		setCalendarTitle();
		centerPane.add(BorderLayout.NORTH, titlePane);
		add(centerPane);
		
		//날짜만들기
		centerPane.add(dayPane);
		setDay();
		
		
		prevBtn.addActionListener(this);
		nextBtn.addActionListener(this);
		
		//년월 이벤트 다시등록
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	//날짜셋팅
	public void setDay() {
		//요일
		date.set(year, month-1, 1);
		int week = date.get(Calendar.DAY_OF_WEEK);
		//마지막날
		int lastDay = date.getActualMaximum(Calendar.DATE);
		
		//공백
		for(int s=1; s<week; s++) {
			JLabel lbl = new JLabel(" ");
			dayPane.add(lbl);
		}
		//날짜추가
		for(int day=1; day<=lastDay; day++) {
			JLabel lbl = new JLabel(String.valueOf(day), JLabel.CENTER);
			lbl.setFont(fnt);
			//출력하는 날짜에 대한 요일
			date.set(Calendar.DATE, day); // 19 ->1
			int w = date.get(Calendar.DAY_OF_WEEK);
			if(w ==1) lbl.setForeground(Color.red);
			if(w ==7) lbl.setForeground(Color.blue);
			dayPane.add(lbl);
		}
	}
	//월화수목금토일 설정
	public void setCalendarTitle() {
		for(int i =0; i <title.length; i++) {
			JLabel lbl = new JLabel(title[i], JLabel.CENTER);
			lbl.setFont(fnt);
			if(i ==0) lbl.setForeground(Color.red);
			if(i ==6) lbl.setForeground(Color.blue);
			titlePane.add(lbl);
		}
	}
	//년도세팅
	public void setYear() {
		for(int i= year-50; i<year+20; i++) {
			yearCombo.addItem(i);
		}
		yearCombo.setSelectedItem(year);
	}
	//월세팅
	public void setMonth() {
		for(int i=1; i<=12; i++) {
			monthCombo.addItem(i);
		}
		monthCombo.setSelectedItem(month);
	}
	
	//콤보박스클릭이벤트
	public void itemStateChanged(ItemEvent e) {
		year = (int)yearCombo.getSelectedItem();
		month = (int)monthCombo.getSelectedItem();
		
		dayPane.setVisible(false);
		dayPane.removeAll(); //원래있는 날짜 지우기
		setDay(); //날짜 처리 함수 호출
		dayPane.setVisible(true);
		
	}
	//버튼이벤트 
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == prevBtn) {
			//이전월을 눌렀을때
			prevMonth();
			setDayReset();
		}else if(obj == nextBtn) {
			//다음월을 눌렀을떄
			nextMonth();
			setDayReset();
		}
	}
	private void setDayReset() {
		System.out.println("year == "+ year + "   month == "+ month);
		//년월 이벤트 등록해제
		yearCombo.removeItemListener(this);
		monthCombo.removeItemListener(this);
		
		yearCombo.setSelectedItem(year); //itemEvent발생시
		monthCombo.setSelectedItem(month);
		
		dayPane.setVisible(false);
		dayPane.removeAll();
		setDay();
		dayPane.setVisible(true);
		
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
		
	}
	public void prevMonth() { //월
		if(month==1) {
			year--;
			month=12;
		}else {
			month--;
		}
	}
	public void nextMonth() {
		if(month==12){
			year++; 
			month=1;
		}else{
			month++;
		}
	}
	
	//시작메소드
	public static void main(String[] args) {
		new CalendarSwing();
	}
}
