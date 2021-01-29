import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SourceView extends JFrame implements ActionListener{
	
	JPanel pane = new JPanel(new BorderLayout());
		JPanel Northpane = new JPanel(new GridLayout(0,3));
			JLabel lb = new JLabel("URL");
			JTextField urlFd = new JTextField();
			JButton btn = new JButton("sourceView");
			
		JPanel centerPane = new JPanel();
			TextArea urlAa= new TextArea();
		
	public SourceView() {
		Northpane.add(lb);
		Northpane.add(urlFd);
		Northpane.add(btn);
		
		pane.add("North",Northpane);
		
		centerPane.add(urlAa);
		pane.add("South",urlAa);
		add(pane);
		
		
		//------------기능구현
		btn.addActionListener(this);
		
		setVisible(true);
        setSize(700,700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	//기능
	public void actionPerformed(ActionEvent e) {
		Object eventObj = e.getSource();
		if(eventObj instanceof JButton) {
			JButton eventBtn = (JButton) eventObj;
			System.out.println("이쉣키버튼누름");
			if(eventBtn.equals(btn)) {
				//1. urlFd를 가져온다.
				String urla = urlFd.getText();
				try {
					URL url = new URL(urla);
					
					InputStream is = url.openStream();
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr);
							
					while(true) {
						String inData = br.readLine();
						if(inData ==null)break;
						urlAa.setText(inData);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				//2.텍스트에이리어에 써준다.
			}
		}
		
	}
	
	public static void main(String[] args) {
		new SourceView();

	}
}
