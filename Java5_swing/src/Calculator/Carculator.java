package Calculator;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;


public class Carculator extends JFrame implements ActionListener {
JLabel label;           // 연산 결과창
boolean state = false; // 화면에 표시된 number 핸들러
double num1, num2; 
double result;         // 연산 결과
String func = "";     // 기능 연산자
String nInput = "";   // 마지막에 누른 연산자 저장

String btn1[] = { "Backspace", "clear", "End" }; //3개 값배열
String btn2[] = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", ".", "=", "/" };// 버튼 안에 값 배열


public Carculator() {

    super("계산기"); 
    super.setResizable(true); 

    // 결과 창 GUI
    label = new JLabel("0", JLabel.RIGHT);
    label.setFont(new Font("궁서체", Font.BOLD, 50));

    // 버튼 창 GUI
    JPanel btnView1 = new JPanel();
    JPanel btnView2 = new JPanel();
    
    btnView1.setLayout(new GridLayout(1, 0, 0, 0));
    btnView2.setLayout(new GridLayout(4, 4, 2, 2)); // 행과 열로 구성된 레이아웃 설정 (row, cols, 간격, 간격)
    
    JButton button1[] = new JButton[btn1.length];
    JButton button2[] = new JButton[btn2.length]; // 버튼 생성, 배열의 길이만큼 값을 가져옴
    
    for (int i = 0; i < btn1.length; i++) {
        button1[i] = new JButton(btn1[i]);
        button1[i].addActionListener(this); // 익명클래스로 버튼 이벤트 추가 ,이벤트 리스너의 객체이므로 this로 지정
        label.setFont(new Font("궁서체", Font.BOLD, 50));
        btnView1.add(button1[i]);

    }
    
    for (int i = 0; i < btn2.length; i++) {
        button2[i] = new JButton(btn2[i]);
        button2[i].addActionListener(this); // 익명클래스로 버튼 이벤트 추가 ,이벤트 리스너의 객체이므로 this로 지정
        label.setFont(new Font("궁서체", Font.BOLD, 50));
        btnView2.add(button2[i]);

    }

    // 프레임 배치 및 설정
    add(label, BorderLayout.NORTH); // 결과창 
    add(btnView1, BorderLayout.CENTER); // 버튼창 
    add(btnView2, BorderLayout.SOUTH); // 버튼창 

    setBounds(100, 100, 300, 400); 
    setSize(280,350);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
    setVisible(true); 

}

// 마우스 클릭에 의한 동작
/*
    boolean state = false; // 화면에 표시된 number 핸들러
	double num1, num2; 
	double result;         // 연산 결과
	String func = "";      // 기능 연산자
	String nInput = "";    // 마지막에 누른 연산자 저장
 */
@Override
public void actionPerformed(ActionEvent e) {

    String input = e.getActionCommand(); // 이벤트를 발생시킨 객체의 문자열을 가져와서 input에 넣음

    if (input.equals("+")) {
        num1 = num2;  
        func = "+";
        nInput = ""; 

    } else if (input.equals("-")) {
        num1 = num2;
        func = "-";
        nInput = "";

    } else if (input.equals("*")) {
        num1 = num2;
        func = "*";
        nInput = "";

    } else if (input.equals("/")) {
        num1 = num2;
        func = "/";
        nInput = "";

    } else if (input.equals("clear")) {  // Clear
        nInput = "";
        num2 = 0;
        num1 = 0;
        label.setText("0");
                                         
    } else if (input.equals("Backspace")) {     // 오른쪽부터 지워짐
        setBackSpace(getBackSpace().substring(0, getBackSpace().length() - 1));
        if (getBackSpace().length() < 1) {  // 더 이상 지울 숫자가 없으면, 0으로 clear
            nInput = "";
            num2 = 0;
            num1 = 0;
            label.setText("0");
        }

    } else if (input.equals("=")) {
        if (func.equals("+")) {
            result = num1 + num2;
            label.setText(String.valueOf(result)); //결과값을 문자열로 반환하여 결과창에 출력
            state = true; // 결과 값이 나온 후 다음 입력이 들어왔을 때 화면에 표시된 결과 값을 지운다.

        } else if (func.equals("-")) {
            result = num1 - num2;
            label.setText(String.valueOf(result));
            state = true;

        } else if (func.equals("*")) {
            result = num1 * num2;
            label.setText(String.valueOf(result));
            state = true;

        } else if (func.equals("/")) {
            result = num1 / num2;
            label.setText(String.valueOf(result));
            state = true;

        }

    } else {
        if (state) {
            label.setText("0");
            state = false;
            num1 = 0;
            num2 = 0;
            nInput = "";
        }

        nInput += e.getActionCommand();
        label.setText(nInput);
        num2 = Double.parseDouble(nInput); //문자열에서 double형 변

    }

}

	private void setBackSpace(String bs) {
	    label.setText(bs);
	}
	
	private String getBackSpace() {
	    return label.getText();
	}
	
	public static void main(String[] args) {
	    new Carculator();
	}
}

	