import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SendButton implements ActionListener{
	JTextArea ta;
	JTextField tf;
	
	//Key 이벤트에서 버튼으로 보내기(버튼)을 위한 클레스
	public SendButton() {
		
	}
	
	public SendButton(JTextArea ta, JTextField tf) {
		this.ta = ta;
		this.tf = tf;
	}
	public void actionPerformed(ActionEvent ae) {
		ta.append(" ->>> "+tf.getText() + "\n");
		tf.setText("");
	}
}
