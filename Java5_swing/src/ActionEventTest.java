import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//										 인터페이스 상속
public class ActionEventTest implements ActionListener{		
		JFrame frm = new JFrame("ActionEvent");
		JButton btn = new JButton("클릭");
		JButton btn2 = new JButton("3단");
		JTextArea ta = new JTextArea("버튼을 클릭하세요.");
		JScrollPane sp = new JScrollPane(ta);
		
		
		public ActionEventTest() {
			frm.add(BorderLayout.NORTH, btn);
			frm.add(BorderLayout.SOUTH, btn2);
			frm.add(ta);
			
			frm.setSize(500,500); //창크기
			frm.setVisible(true); //보이게허용
			frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE); //창꺼질때 꺼지게하기
			
			//이벤트 등록
			btn.addActionListener(this);
			btn2.addActionListener(this);
		}
	//추상메소드 오버라이딩
	public void actionPerformed(ActionEvent ae) {
		//setText() : 새로운 문자로 셋칭
		//append() : 마지막에 문자 추가
		//inset() : 원하는 위치(index)에 문자추가
		//ta.append("click\n");
		
		//1. 이벤트가 발생한 버튼 알아내기 ->getActionCommand()
		/*
		String evt = ae.getActionCommand();
		if(evt.equals("클릭")) {
			ta.append(evt + "\n");
		}else if(evt.equals("3단")) {
			gugudan(3);
		}
		*/
		//2. 이벤트가 발생한 객체를 가지고 알아내기
		/*
		Object obj = ae.getSource();
		if(obj == btn) {//클릭버튼 선택시
			ta.append("btn버튼 클릭\n");
		}else if(obj == btn2) {
			gugudan(2);
		}
		*/
		
	}
	
	public void gugudan(int dan) {
		for (int i=2; i <=9; i++) {
			ta.append(dan + " * "+ i + " = " + (dan*i)+ "\n" );
		}
		
	}
	public static void main(String[] args) {
		new ActionEventTest();
	}

}
