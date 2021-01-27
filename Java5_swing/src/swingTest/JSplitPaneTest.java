package swingTest;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

//패널나누기
public class JSplitPaneTest extends JFrame{
	JSplitPane sp1, sp2;
	
	DigitalClock dc = new DigitalClock();
	CalendarSwing cs = new CalendarSwing();
	JTextArea ta = new JTextArea();
	
	public JSplitPaneTest() {
		//Vertical 상하나누기
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, dc, cs);
		
		//Horizontal 좌우로 나누기
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp2, ta);

		add(sp1);
		
		//sp2 위쪽 component 높이 조절하기
		sp2.setDividerLocation(300);
		sp1.setDividerLocation(600);
		
		//경계선 두께 줄이기
		sp2.setDividerSize(1);
		sp1.setDividerSize(20);
		
		//왼쪽으로밀치기 오른쪽으로밀치기
		sp1.setOneTouchExpandable(true);
		
		
		setSize(1200, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Thread t1 = new Thread(dc);
		t1.start();
	}

	public static void main(String[] args) {
		new JSplitPaneTest();
	}

}
