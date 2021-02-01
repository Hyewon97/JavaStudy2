import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Char extends JFrame implements ActionListener{
	
	
	JPanel spPane = new JPanel(new GridLayout(0,2));
		JPanel sp1Pane = new JPanel(new BorderLayout());
			JPanel topPane = new JPanel(new BorderLayout());
				JTextField tfcon = new JTextField("                                                                            ");
				JButton connectBtn = new JButton("접속");
				
			JScrollPane sp = new JScrollPane();
				JTextArea msgta = new JTextArea();
				
			JPanel bottomPane = new JPanel(new BorderLayout());
				JTextField tfsend = new JTextField("                                                                            ");
				JButton sendBtn = new JButton("보내기");
			
		JPanel sp2Pane = new JPanel(new BorderLayout());	
			JPanel listPane = new JPanel(new BorderLayout());
				JLabel connlist = new JLabel("접속자 리스트");
				
				JScrollPane sp2 = new JScrollPane();
					JTextArea conta = new JTextArea();
				JLabel con = new JLabel("현재원 0명");
	
	public Char() {
		tfcon.setBackground(Color.cyan);
		topPane.add(BorderLayout.WEST,  tfcon);
		topPane.add(BorderLayout.EAST,  connectBtn);
		
		msgta.setBackground(Color.blue);
		sp.add(msgta);
		
		tfsend.setBackground(Color.cyan);
		bottomPane.add(BorderLayout.WEST,  tfsend);
		bottomPane.add(BorderLayout.EAST,  sendBtn);
		
		sp1Pane.add(BorderLayout.NORTH, topPane);
		sp1Pane.add(BorderLayout.CENTER, msgta);
		sp1Pane.add(BorderLayout.SOUTH, bottomPane);
		
		sp2.add(conta);
		
		listPane.add(BorderLayout.NORTH, connlist);
		//listPane.add(BorderLayout.CENTER, sp2);
		listPane.add(BorderLayout.CENTER, conta);
		listPane.add(BorderLayout.SOUTH, con);
		
		sp2Pane.add(listPane);
		
		spPane.add(sp1Pane);
		spPane.add(sp2Pane);
		
		add(BorderLayout.CENTER, spPane);
		
		setVisible(true);
        setSize(600,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	//기능구현 오버라이딩
	public void actionPerformed(ActionEvent ae) {
		
		
	}
	
	public static void main(String[] args) {
		new Char();
	}
}
