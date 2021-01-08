import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FrameTest2 extends Frame{

	public FrameTest2() {
		super("상속받은 프레임");//창제목세팅 setTitle("창제목");
		
		//레이아웃 변경 BorderLayout -> FlowLayout으로 변경
		setLayout(new FlowLayout());
		
		Button btn = new Button("레이아웃변경됨");
		add(btn);
		
		setSize(500, 500); //사이즈
		setVisible(true);//보이게할것인가
	}

	public static void main(String[] args) {
		new FrameTest2();
	}

}
