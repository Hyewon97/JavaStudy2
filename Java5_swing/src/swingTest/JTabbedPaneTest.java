package swingTest;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class JTabbedPaneTest extends JFrame{
	JTabbedPane tp = new JTabbedPane();
	
	ImageIcon ii1 = new ImageIcon("img/img.png");
	ImageIcon ii2 = new ImageIcon("icon/save01.gif");
	ImageIcon ii3 = new ImageIcon("icon/open01.gif");
	ImageIcon ii4 = new ImageIcon("icon/new01.gif");
	ImageIcon ii5 = new ImageIcon("icon/saveas01.gif");
	JLabel lbl = new JLabel(ii1);
	public JTabbedPaneTest() {
		add(tp);
		
		//탭패널에 컴퍼넌트 추가
		tp.addTab("하우스",lbl);
		//계산기 추가
		Calculator2 cal = new Calculator2();
		tp.addTab("계산기", ii2, cal, "Calculator");
		
		//달력추가
		CalendarSwing calSwing = new CalendarSwing();
		tp.addTab("달력", ii3, calSwing, "CalendarSwing");
		
		//시계추가
		DigitalClock clock = new DigitalClock();
		tp.addTab("시계", ii3, clock, "시계에용");
		
		//팩맨추가
		PackmanT pack = new PackmanT();
		tp.addTab("팩맨", ii4, pack, "팩맨이에용");
		
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//시계 스레드 시작
		Thread clockThread = new Thread(clock);
		clockThread.start();
		
		//팩맨 스레드 시작
		//캠버스 크기 다시셋팅
		pack.getPackManSize();
		Thread packman = new Thread(pack);
		packman.start();
		
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			
		}
		//중간에 tabMenu 추가하기/////////////////////////
		//tp.insertTab("버튼추가해보기", ii2, new JButton("버튼"), "테스트중", 2);
		
		//활성화 비활성화 하기
		//true: 활성화. false :비활성화(1번쨰 탭을 제외한 나머지탭은 모두 비활성화)
		//tp.setEnabled(false);
		
		
		//부분활성화 부분비활성화하기
		//tp.setEnabledAt(2, false);
		
		//탭메뉴삭제
		//tp.removeTabAt(3);
		
		//탭메뉴 위치이동
		//tp.setTabPlacement(JTabbedPane.LEFT);
	}

	public static void main(String[] args) {
		new JTabbedPaneTest();

	}

}
