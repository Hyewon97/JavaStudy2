import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class JButtonTest extends JFrame{
	ImageIcon ii1 = new ImageIcon("img/movie01.png");
	ImageIcon ii2 = new ImageIcon("img/movie02.png");
	ImageIcon ii3 = new ImageIcon("img/movie03.png");
	ImageIcon ii4 = new ImageIcon("img/movie04.png");
	ImageIcon ii5 = new ImageIcon("img/movie05.png");
	
	public JButtonTest() {
		super("JButton Test");
		
		setLayout(new GridLayout(0,3,10,10));//레이아웃변경
		
		JButton btn1 = new JButton(ii1);
		add(btn1);
		
		JButton btn2 = new JButton("확인", ii2);
		add(btn2);
		
		//마우스를 올리면 아이콘이 ii3로 변경
		btn2.setRolloverIcon(ii3);
		
		//마우스 누른상태일때 아이콘 설정
		btn2.setPressedIcon(ii4);
		
		//버튼의 비활성화 btn1
		btn1.setEnabled(false);
		
		//RadioButton 만들기
		JPanel pane = new JPanel( new GridLayout(3,1));
		
		JRadioButton rb1 = new JRadioButton("ONE");
		JRadioButton rb2 = new JRadioButton("TWO");
		JRadioButton rb3 = new JRadioButton("THREE", true);
		
		//ButtonGroup : radiobutton 그룹화
		//객체를 만들어 등록
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1); bg.add(rb2); bg.add(rb3);
		
		pane.add(rb1); pane.add(rb2); pane.add(rb3);
		add(pane);
		
		//ToggleButton 누른상태로 고정되는 버튼
		JToggleButton tb1 = new JToggleButton("토글버튼"); 
		JToggleButton tb2 = new JToggleButton(ii5, true); //true를 누르면 처음부터 선택된 상태로나옴
		//tb2.setVisible(false); //안보이게 해줌
		tb2.setRolloverSelectedIcon(ii4);
		add(tb1); add(tb2);
		
		//setBackground() : 컴퍼넌트 or 컨터이너 배경색을 설정한다.
		btn2.setBackground(Color.PINK);
		
		//
		Color clr1 = new Color(150, 200, 50);
		rb1.setBackground(clr1);
		
		//setForeground() : 글자색 설정
		tb1.setForeground(Color.blue);
		
		//JLabel : 라벨 컴퍼넌트
		JLabel lbl1 = new JLabel(ii3);
		JLabel lbl2 = new JLabel("라벨", JLabel.CENTER);
		
		add(lbl1); add(lbl2);
		
		//라벨에 배경색 입히기
		lbl2.setBackground(Color.pink); //라벨은 투명색이라 핑크가 안먹는것을 확인할 수 있다.
		
		//투명처리
		lbl2.setOpaque(true); //ture:투명해제, false:투명
		btn2.setToolTipText("버튼 연습중");
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String a[]) {
		new JButtonTest();
	}

}
