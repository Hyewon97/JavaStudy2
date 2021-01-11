import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KeyEventTest extends JFrame implements KeyListener{

	JPanel pane = new JPanel();
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	JButton btn = new JButton("보내기");
	JTextField tf = new JTextField(20);
	
	Font fnt = new Font("궁서체", Font.BOLD, 20);
	
	public KeyEventTest() {
		super("Key이벤트");
		
		add(sp);
		
		add(BorderLayout.SOUTH, pane);
		pane.add(tf);
		pane.add(btn);
		
		//ta에 폰트객체 설정
		ta.setFont(fnt);
		
		//이벤트 등록
		tf.addKeyListener(this);
		//다른클래스에서 이벤트처리
		btn.addActionListener(new SendButton(ta,tf));
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	//오버라이딩
	public void keyPressed(KeyEvent ke) {//키를 누른상태일때
	}
	
	public void keyReleased(KeyEvent ke) {//키를 누른후 놓으면
			//이벤트가 발생한 키 정보얻어오기
			char evtChar = ke.getKeyChar();
			int evtInt = ke.getKeyCode();
			System.out.println(evtChar+ " -> " + evtInt);
			
			if(evtInt == KeyEvent.VK_ENTER) {
				ta.append(tf.getText() + "\n");
				tf.setText("");
			}else if(evtInt == KeyEvent.VK_ESCAPE) {
				System.exit(0);//종료
			}
	}
	
	public void keyTyped(KeyEvent ke) {//키를 눌렀다가 놓으면
	}
	
	public static void main(String[] args) {
		new KeyEventTest();
	}

}
