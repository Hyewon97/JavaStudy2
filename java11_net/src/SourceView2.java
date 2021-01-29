import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SourceView2 extends JFrame implements ActionListener{
	
	JTabbedPane tp = new JTabbedPane();
	
	JPanel topPane = new JPanel(new BorderLayout());
		JLabel lbl = new JLabel(" URL ");
		JTextField tf = new JTextField();
		JButton sourceView = new JButton("soutceView");
		
	public SourceView2() {
		topPane.add(BorderLayout.WEST, lbl);
		topPane.add(BorderLayout.CENTER, tf);
		topPane.add(BorderLayout.EAST, sourceView);
		
		add(BorderLayout.NORTH, topPane);
		add(tp);
		//------------기능구현
		tf.addActionListener(this);
		sourceView.addActionListener(this);
		
		setVisible(true);
        setSize(1000,800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	//기능
	public void actionPerformed(ActionEvent e) {
		Object Obj = e.getSource();
		if(tf.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "url주소를 입력후에 소스보기가 가능합니다.");
		}else {
			if(Obj == tf || Obj == sourceView) {
				try {
					URL url = new URL(tf.getText());
					URLConnection connection = url.openConnection();
					connection.connect();
					String contentType = connection.getContentType();
					String encoding = contentType.substring(contentType.indexOf("=")+1 );
					
					BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
					
					JTextArea ta = new JTextArea();
					JScrollPane sp = new JScrollPane(ta);
					tp.addTab(tf.getText(), sp);
					
					while(true) {
						String line = br.readLine();
						if(line ==null) break;
						ta.append(line+ "\n");
					}
					
					tf.setText("");
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new SourceView2();

		/*
		 	tcp 소켓에다가담아서 접속이끊길떄까지 계속진행
		 	
		 */
	}
}
