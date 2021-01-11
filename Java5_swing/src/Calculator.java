
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame implements ActionListener{
	
	JPanel pane1 = new JPanel();
		JLabel jl = new JLabel("0", JLabel.RIGHT);

		
	JPanel pane2 = new JPanel();
		JButton BC = new JButton("Backsp..");
		JButton clear = new JButton("Clear");
		JButton end = new JButton("End");
		
	JPanel pane3 = new JPanel();
		JButton seven = new JButton("7");
		JButton eight = new JButton("8");
		JButton nine = new JButton("9");
		JButton plus = new JButton("+");
		
	JPanel pane4 = new JPanel();
		JButton four = new JButton("4");
		JButton five = new JButton("5");
		JButton six = new JButton("6");
		JButton minus = new JButton("-");
		
	JPanel pane5 = new JPanel();
		JButton one = new JButton("1");
		JButton two = new JButton("2");
		JButton three = new JButton("3");
		JButton multi = new JButton("*");
		
	JPanel pane6 = new JPanel();
		JButton zero = new JButton("0");
		JButton point = new JButton(".");
		JButton tt = new JButton("=");
		JButton division = new JButton("/");
		
		
	boolean state = false; // 화면에 표시된 number 핸들러
	double num1, num2; 
	double result;         // 연산 결과
	String func = "";     // 기능 연산자
	String nInput = "";   // 마지막에 누른 연산자 저장
	    
	public Calculator() {
		super("계산기");
		super.setLayout(new GridLayout(6, 4, 1, 1));
		
		pane1.add(jl);
		pane1.setBackground(Color.white);
		super.add(pane1);
		
		pane2.add(BC); pane2.add(clear); pane2.add(end); 
		super.add(pane2);
		
		pane3.add(seven); pane3.add(eight); pane3.add(nine); pane3.add(plus);
		super.add(pane3);
		
		pane4.add(four); pane4.add(five); pane4.add(six); pane4.add(minus);
		super.add(pane4);
		
		pane5.add(one); pane5.add(two); pane5.add(three); pane5.add(multi);
		super.add(pane5);
		
		pane6.add(zero); pane6.add(point); pane6.add(tt); pane6.add(division);
		super.add(pane6);
		
		//-------------------------------------외형성공----------------------------
		//클릭시 이벤트 넣어주기
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		multi.addActionListener(this);
		
		zero.addActionListener(this);
		point.addActionListener(this);
		tt.addActionListener(this);
		division.addActionListener(this);
		
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		minus.addActionListener(this);
		
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		plus.addActionListener(this);
		
		clear.addActionListener(this);
		end.addActionListener(this);
		
		//사이즈와 보여주기 ---설정들
		setSize(240,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	//addActionListener때문에 오버라이딩해줘야함
	public void actionPerformed(ActionEvent ae) {	
		String input = ae.getActionCommand();
		
		/*
			if(one.equals(ae.getSource())) {
				String strNum = jl.getText();
				int Num = Integer.parseInt(strNum);
				strNum = String.valueOf(Num);
				jl.setText(strNum);
			}else if(two.equals(ae.getSource())) {
				String strNum = jl.getText();
				int Num = Integer.parseInt(strNum);
				strNum = String.valueOf(Num);
				jl.setText(strNum);
			}else if(three.equals(ae.getSource())) {
				String strNum = jl.getText();
				int Num = Integer.parseInt(strNum);
				strNum = String.valueOf(Num);
				jl.setText(strNum);
			}else if(four.equals(ae.getSource())) {
				String strNum = jl.getText();
				int Num = Integer.parseInt(strNum);
				strNum = String.valueOf(Num);
				jl.setText(strNum);
			}else if(five.equals(ae.getSource())) {
				String strNum = jl.getText();
				int Num = Integer.parseInt(strNum);
				strNum = String.valueOf(Num);
				jl.setText(strNum);
			}else if(six.equals(ae.getSource())) {
				String strNum = jl.getText();
				int Num = Integer.parseInt(strNum);
				strNum = String.valueOf(Num);
				jl.setText(strNum);
			}else if(seven.equals(ae.getSource())) {
				String strNum = jl.getText();
				int Num = Integer.parseInt(strNum);
				strNum = String.valueOf(Num);
				jl.setText(strNum);
			}else if(eight.equals(ae.getSource())) {
				String strNum = jl.getText();
				int Num = Integer.parseInt(strNum);
				strNum = String.valueOf(Num);
				jl.setText(strNum);
			}else if(nine.equals(ae.getSource())) {
				String strNum = jl.getText();
				int Num = Integer.parseInt(strNum);
				strNum = String.valueOf(Num);
				jl.setText(strNum);
			}else if(zero.equals(ae.getSource())) {
				String strNum = jl.getText();
				int Num = Integer.parseInt(strNum);
				strNum = String.valueOf(Num);
				jl.setText(strNum);
			}else if(clear.equals(ae.getSource())) {
				jl.setText("0");
			}
			
		*/
		
		if (input.equals("+")) {
	        num1 = num2;  
	        func = "+";
	        nInput = ""; // 마지막에 누른 연산자 저장

	    } else if (input.equals("-")) {
	        num1 = num2;
	        func = "-";
	        nInput = "";

	    } else if (input.equals("×")) {
	        num1 = num2;
	        func = "×";
	        nInput = "";

	    } else if (input.equals("÷")) {
	        num1 = num2;
	        func = "÷";
	        nInput = "";

	    } else if (input.equals("%")) {
	        num1 = num2;
	        func = "%";
	        nInput = "";
	        result = num1 / 100;
	        jl.setText(String.valueOf(result)); //결과값을 문자열로 반환하여 결과창에 출력
	    }

	    else if (input.equals("x²")) {
	        num1 = num2;
	        func = "x²";
	        nInput = "";
	        result = num1 * num1;
	        jl.setText(String.valueOf(result));
	        state = true;

	    } else if (input.equals("C")) {  // Clear
	        nInput = "";
	        num2 = 0;
	        num1 = 0;
	        jl.setText("0");

	                                         // substring(start, end) - start부터 end 전까지 문자열 자르기
	    }else if (input.equals("=")) {
	        if (func.equals("+")) {
	            result = num1 + num2;
	            jl.setText(String.valueOf(result)); //결과값을 문자열로 반환하여 결과창에 출력
	            state = true; // 결과 값이 나온 후 다음 입력이 들어왔을 때 화면에 표시된 결과 값을 지운다.

	        } else if (func.equals("-")) {
	            result = num1 - num2;
	            jl.setText(String.valueOf(result));
	            state = true;

	        } else if (func.equals("×")) {
	            result = num1 * num2;
	            jl.setText(String.valueOf(result));
	            state = true;

	        } else if (func.equals("÷")) {
	            result = num1 / num2;
	            jl.setText(String.valueOf(result));
	            state = true;

	        }

	    } else {
	        if (state) {
	            jl.setText("0");
	            state = false;
	            num1 = 0;
	            num2 = 0;
	            nInput = "";
	        }

	        nInput += ae.getActionCommand();
	        jl.setText(nInput);
	        num2 = Double.parseDouble(nInput); //문자열에서 double형 변

	    }

	}
		
	public static void main(String[] args) {
		new Calculator();
	}
}
