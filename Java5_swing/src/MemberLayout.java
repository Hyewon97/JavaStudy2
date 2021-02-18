import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemberLayout extends JFrame{
	
	JPanel pane = new JPanel();
		JPanel pane0 = new JPanel(new GridLayout(9, 0));
			JPanel pane1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel lbNum = new JLabel("번호"); 
				JTextField taNum = new JTextField("            ");
			
			JPanel pane2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel lbName = new JLabel("이름"); 
				JTextField taName = new JTextField("                     ");
			
			JPanel pane3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel lbPhone = new JLabel("전화번호");
				JTextField taPhone = new JTextField("                                ");
				
			JPanel pane4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel lbEmail = new JLabel("이메일");
				JTextField taEmail = new JTextField("                                           ");
				
			JPanel pane5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel lbAddress = new JLabel("주소");
				JTextField taAddress = new JTextField("                                                  ");
				
			JPanel pane6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel lbHireDate = new JLabel("등록일");
				JTextField taHireDate = new JTextField("                                                    ");
			
			JPanel pane7 = new JPanel(new GridLayout(0,7));
				JButton btAdd = new JButton("추가");
				JButton btUpdate = new JButton("수정");
				JButton btDelete = new JButton("삭제");
				JButton btCancle = new JButton("지우기");
				JButton btExit = new JButton("종료");
				JButton btExcel = new JButton("엑셀로저장");
				JButton btExcelOpen = new JButton("엑셀불러오기");
			JPanel pane8 = new JPanel(new GridLayout(0,7));
				JLabel lbNum2 = new JLabel("번호"); 
				JLabel lbName2 = new JLabel("이름");
				JLabel lbPhone2 = new JLabel("전화번호");
				JLabel lbEmail2 = new JLabel("이메일");
				JLabel lbAddress2 = new JLabel("주소");
				JLabel lbHireDate2 = new JLabel("등록일");
		
		JPanel pane9 = new JPanel();
			JTextField searchBox = new JTextField("              ");
			JButton search = new JButton("Search");
		
	public MemberLayout() {
		super("회원관리");
		
		pane.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
			
			lbNum.setPreferredSize(new Dimension(50,50));
			lbName.setPreferredSize(new Dimension(50,50));
			lbPhone.setPreferredSize(new Dimension(50,50));
			lbEmail.setPreferredSize(new Dimension(50,50));
			lbAddress.setPreferredSize(new Dimension(50,50));
			lbHireDate.setPreferredSize(new Dimension(50,50));
			
			pane1.add(lbNum); pane2.add(lbName);
			pane3.add(lbPhone); pane4.add(lbEmail);
			pane5.add(lbAddress); pane6.add(lbHireDate);
			
			pane1.add(taNum); pane2.add(taName);
			pane3.add(taPhone); pane4.add(taEmail);
			pane5.add(taAddress); pane6.add(taHireDate);
			
			
			pane7.add(btAdd); pane7.add(btUpdate);
			pane7.add(btDelete); pane7.add(btCancle);
			pane7.add(btExit); pane7.add(btExcel);
			pane7.add(btExcelOpen);
			
			pane8.add(lbName2); pane8.add(lbNum2);
			pane8.add(lbPhone2); pane8.add(lbEmail2);
			pane8.add(lbHireDate2); pane8.add(lbAddress2);
			
			pane9.add(searchBox); pane9.add(search);
		
		
		pane0.add(pane1);		pane0.add(pane2);
		pane0.add(pane3);		pane0.add(pane4);
		pane0.add(pane5);		pane0.add(pane6);
		pane0.add(pane7);		pane0.add(pane8);
		pane0.add(pane9);
		pane0.setPreferredSize(new Dimension(990,400));
		pane.add(pane0);
		add(pane);
		
		//기본세팅
		setSize(1000,1000);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MemberLayout();

	}

}
