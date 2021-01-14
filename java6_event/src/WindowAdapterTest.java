import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

//Adapter 상속
// JFame, WindowAdapter
public class WindowAdapterTest extends WindowAdapter {
	
	JFrame frm = new JFrame("WindowAdapter 테스트");
	public WindowAdapterTest() {
		frm.setSize(500,500);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(frm.DO_NOTHING_ON_CLOSE);
		
		frm.addWindowListener(this);
	}
	//재 오버라이딩
	public void windowClosing(WindowEvent we) {
		System.out.println("윈도우 이벤트 발생함.");
		frm.dispose();
		System.exit(0);
	}
	public static void main(String[] args) {
		new WindowAdapterTest();

	}

}
