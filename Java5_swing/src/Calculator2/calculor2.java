package Calculator2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculor2 extends JFrame implements ActionListener{
	JTextField tf = new JTextField(20);  //연산 결과창
	String btn1[] = {"Backspace", "clear", "End"}; //3개
	String btn2[] = { "7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"}; //밑에 줄 4400
	
	public calculor2() {
		JFrame frm = new JFrame("계산기");
		frm.add(BorderLayout.NORTH, tf); //결과값 맨위에 박기
		
		//배열로된거 패널에 박기
		JPanel btnn1 = new JPanel();
	    JPanel btnn2 = new JPanel();
	    
		btnn1.setLayout(new GridLayout(1, 0, 0, 0)); //레이아웃 구성 행,열,간격,간격
	    btnn2.setLayout(new GridLayout(4, 4, 2, 2)); 
	    
	    JButton button1[] = new JButton[btn1.length];
	    JButton button2[] = new JButton[btn2.length]; // 버튼생성
	    
	    for (int i = 0; i < btn1.length; i++) {
	        button1[i] = new JButton(btn1[i]);
	        button1[i].addActionListener(this); // 이벤트추가
	        btnn1.add(button1[i]);

	    }
	    
	    for (int i = 0; i < btn2.length; i++) {
	        button2[i] = new JButton(btn2[i]);
	        button2[i].addActionListener(this); // 이벤트 추가
	        btnn2.add(button2[i]);
	    }
		
	    frm.add(BorderLayout.SOUTH, btnn1); //버튼 박기
	    frm.add(BorderLayout.SOUTH, btnn2); //버튼 박기
	    
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new calculor2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
