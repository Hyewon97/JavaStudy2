import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MemberMain extends JFrame implements ActionListener{
	//JFrame - North - 회원폼
	JPanel mainNorthPane = new JPanel(new BorderLayout());
		JPanel formLabelPane = new JPanel(new GridLayout(6,1));
			String lbl[] = {"번호", "이름", "전화번호", "이메일", "주소", "등록일"};
		JPanel formCenterPane =  new JPanel(new GridLayout(6,1));
			JTextField tf[] = {new JTextField(4), new JTextField(10), new JTextField(20), new JTextField(30), new JTextField(50), new JTextField(15)};
	
	//JFrame - Center - 버튼, JTable, 검색
	JPanel mainCenterPane = new JPanel(new BorderLayout());
		//버튼들
		JPanel buttonPane = new JPanel(new GridLayout(1,0));
			String btnLbl[] = {"전체목록","추가","수정","삭제","지우기","종료","엑셀로쓰기","엑셀에서가져오기0"};
		//JTable
		JTable table;
			JScrollPane sp;
			DefaultTableModel model;
			
	//JFrame - South -검색
	JPanel searchPane = new JPanel();
	JTextField searchTf = new JTextField(20);
	JButton searchBtn = new JButton("Search");
	
	public MemberMain() {
		super("회원관리");
		
		add("North", mainNorthPane);
			for(int idx=0; idx<lbl.length; idx++) { //폼의라벨
				JLabel formLabel = new JLabel(lbl[idx]);
				formLabelPane.add(formLabel);
			}
			mainNorthPane.add("West", formLabelPane);
			
			//TextField
			for(int idx=0; idx<tf.length; idx++) {
				JPanel p = new JPanel();
				p.setLayout(new FlowLayout(FlowLayout.LEFT));
				p.add(tf[idx]);
				formCenterPane.add(p);
			}
			
		add("Center", mainCenterPane);
			mainNorthPane.add("Center", formCenterPane);
			
			//버튼
			for(int idx=0; idx<btnLbl.length; idx++) {
				JButton btn = new JButton(btnLbl[idx]);
				buttonPane.add(btn);
				
				//이벤트 등록
				btn.addActionListener(this);
			}
			mainCenterPane.add("North", buttonPane);
			
			//JTable 객체 생성
			model = new DefaultTableModel(lbl, 0);
			table = new JTable(model);
			sp = new JScrollPane(table);
			mainCenterPane.add("Center", sp);
			
		//검색
		add("South", searchPane);
			searchPane.add(searchTf);
			searchPane.add(searchBtn);
		//기본세팅
		setSize(1000,1000);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		
		searchBtn.addActionListener(this);
		table.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent me) {
				
			}
		});
		
		//초기화면에 회원전체 목록 보여야함
		getMemberAll();
	}
	
	public void actionPerformed(ActionEvent ae) {
		String eventBtn = ae.getActionCommand();
		if(eventBtn.equals("Search")) { 
			memberSearch();
		}else if(eventBtn.equals("전체목록")) {
			getMemberAll();
		}
	}
	//회원검색
	public void memberSearch() {
		//검색어에 입력된 데이터
		String searchWord = searchTf.getText();
		if(searchWord.equals("")) { //검색어가 없을떄
			JOptionPane.showMessageDialog(this, "검색어를 입력후 눌러주세요");
		}else {//검색어가 있을때
			MemberDAO dao = new MemberDAO();
			List<MemberVO> searchList = dao.getSearchRecord(searchWord);
			
			if(searchList.size() == 0) {//검색한 결과가 없을때
				JOptionPane.showMessageDialog(this, searchList + "의 검색결과가 없습니다.");
			}else {//검색한 결과가 있을떄
				setNewTableList(searchList);
			}
		}
	}
	public void setNewTableList(List<MemberVO> lst) {
		model.setRowCount(0); //JTable의 레코드 지우기
		for(int i=0; i<lst.size(); i++) {
			MemberVO vo = lst.get(i);
			Object[] data = {vo.getNum(), vo.getUsername(), vo.getTel(), vo.getEmail(), vo.getAddr(), vo.getWritedate()};
			model.addRow(data);
		}
	}
	//회원전체 선택
	public void getMemberAll() {
		//데이터베이스의 모든 회원을 선택해서 JTable에 표시한다
		MemberDAO dao = new MemberDAO();
		List<MemberVO> lst = dao.memberAllSelect();
		
		setNewTableList(lst);
	}
	
	public static void main(String[] args) {
		new MemberMain();
	}

}
