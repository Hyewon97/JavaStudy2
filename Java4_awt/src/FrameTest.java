import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class FrameTest {
	
	//객체를 이용한 컨테이너 생성
	Frame frm = new Frame();
	Dimension dim = new Dimension(400,300);
	Point pnt = new Point(200,200);
	Rectangle rect = new Rectangle(pnt, dim);
	
	public FrameTest() {
		frm.setTitle("연습용 Fame");
		
		//창의 크기성정
		//frm.setSize(500,500);
		//frm.setBounds(100,100,500,500);
		//frm.setSize(dim);
		frm.setBounds(rect);
		
		Button btn1 = new Button("버튼1");
		frm.add(btn1);
		
		Button btn2 = new Button("버튼2");
		frm.add("North", btn2);
		frm.add(BorderLayout.EAST, new Button("버튼 3"));
		frm.add(BorderLayout.SOUTH, new Button("버튼 4"));
		frm.add(BorderLayout.WEST, new Button("버튼 5"));
		
		//frm.pack();
		//창을 show
		frm.setVisible(true);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("img/img.png");
		frm.setIconImage(img);
		
		
	}

	public static void main(String[] args) {
		new FrameTest();
	}

}
