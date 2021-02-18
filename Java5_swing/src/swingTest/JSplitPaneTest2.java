package swingTest;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

//패널나누기
public class JSplitPaneTest2 extends JFrame{
	JSplitPane sp1, sp2;
	
	PackmanT pack = new PackmanT();
	Calculator2 cal = new Calculator2();
	CalendarSwing cs = new CalendarSwing();
	
	public JSplitPaneTest2() {
		//Horizontal 좌우로 나누기
		sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, cal, cs);
				
		//Vertical 상하나누기
		sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pack, sp2);

		add(sp1);
		
		
		//sp2 위쪽 component 높이 조절하기
		sp1.setDividerLocation(400);
		
		
		//경계선 두께 줄이기
		sp2.setDividerSize(1);
//		sp1.setDividerSize(20);
		
		//왼쪽으로밀치기 오른쪽으로밀치기
		sp2.setOneTouchExpandable(true);
		
		pack.getPackManSize();
		Thread t1 = new Thread(pack);
		t1.start();
	}

	public static void main(String[] args) {
		new JSplitPaneTest2();
	}

}
