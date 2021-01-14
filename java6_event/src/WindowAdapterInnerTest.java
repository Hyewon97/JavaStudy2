import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WindowAdapterInnerTest extends JFrame{
	JLabel lb = new JLabel("WindowAdapter 테스트중");
	public WindowAdapterInnerTest() {
		add(lb);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		AdapterInner ai = new AdapterInner();
		addWindowListener(ai);
	}
	//내부클래스에서 Window 이벤트 처리하기
	class AdapterInner extends WindowAdapter{
		//다시 오버라이딩
		public void WindowClosing(WindowEvent we) {
			lb.setText("윈도우 이벤트 처리됨");
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new WindowAdapterInnerTest();
	}

}
