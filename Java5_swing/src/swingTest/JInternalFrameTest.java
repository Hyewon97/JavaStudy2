package swingTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JInternalFrameTest extends JFrame implements ActionListener, ChangeListener, ListSelectionListener{

	JDesktopPane dp = new JDesktopPane();
	JInternalFrame if1, if2, if3, if4;
	JTextArea ta = new JTextArea();
	
	JToolBar tb= new JToolBar();
		JButton saveBtn = new JButton("저장");
		JButton colorBtn = new JButton("색상표");
		JButton calBtn = new JButton("계산기");
		
	JSlider redSlider = new JSlider(JSlider.HORIZONTAL, 0 ,255 ,150);
	
	JList<String> list = new JList<String>();
		DefaultListModel<String> model = new DefaultListModel<String>();
		String flower[] = {"해바라기", "장미", "코스모스", "무궁화", "안개꽃", "튤립"};
		JScrollPane sp = new JScrollPane(list);
		
	public JInternalFrameTest() {
		/////
		add("North", tb);
		tb.add(saveBtn); tb.add(colorBtn); tb.add(calBtn);
		//////
		add("South", redSlider);
		redSlider.setMajorTickSpacing(50);///주 눈금
		redSlider.setMinorTickSpacing(5);//보조 눈금
		redSlider.setPaintTicks(true);//눈금보여주기
		redSlider.setPaintLabels(true);//라벨표시
		redSlider.setSnapToTicks(true);//가까운 눈금선으로 스틱이이동한다.
		add(dp);
		
		for(String flowerName: flower) {
			model.addElement(flowerName);
		}
		list.setModel(model);
		add("East", sp);
		
		
		//JinternalFrame만들기
//		JInternalFrame if1 = new JInternalFrame(); //BorderLayout
		if1 = new JInternalFrame();
		if1.add(ta);
		if1.setSize(300,800);
		if1.setVisible(true);
		dp.add(if1);
		
		//String title, boolean resizable, boolean closable, boolean maximizable, boolean 
		//String title(창표시제목) resizable(사이즈조절) closable(닫기기능여부) maximizable(최대화가능여부) iconfiable(아이콘으로 설정여부)
//		JInternalFrame if2 = new JInternalFrame("달력",true,true,true,true);
		if2 = new JInternalFrame("달력",true,true,true,true);
		CalendarSwing cs = new CalendarSwing();
		if2.add(cs);
		if2.setBounds(100, 100, 400, 300);
		if2.setVisible(true);
		dp.add(if2);
		
//		JInternalFrame if3 = new JInternalFrame("Clock");
		if3 = new JInternalFrame("Clock");
		DigitalClock dc = new DigitalClock();
		Thread t = new Thread(dc);
		t.start();
		
		if3.add(dc);
		if3.setBounds(1, 500, 500, 200);
		if3.setVisible(true);
		dp.add(if3);
		
//		JInternalFrame if4 = new JInternalFrame("packman");
		if4 = new JInternalFrame("packman");
		PackmanT pack = new PackmanT();
		
		if4.add(pack);
		if4.setBounds(150, 1, 500, 500);
		if4.setVisible(true);
		dp.add(if4);
		
		setSize(1000, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		try {
			//2번쨰 창이 맨위에뜨기
			if2.setSelected(true);
			if4.setSelected(true);
			pack.getPackManSize();
			Thread t2 = new Thread(pack);
			t2.start();
		}catch(Exception e) {}
		
		//이벤트등록
		saveBtn.addActionListener(this);
		colorBtn.addActionListener(this);
		redSlider.addChangeListener(this);
		list.addListSelectionListener(this);
		calBtn.addActionListener(this);
	}
	
	
	//이벤트처리
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == saveBtn) {
			//활성화 되어 있는 JInternalFrame 객체 가져오기
			JInternalFrame eventIf = dp.getSelectedFrame();
			if(eventIf == if1) {
				JTextArea eventTa = (JTextArea)eventIf.getFocusOwner();
				String tsStr = eventTa.getText();
				try {
					FileWriter fw = new FileWriter(new File("C://tool/io/internal.txt"));
					System.out.println("저장버튼은 눌렸니?");
					fw.write(tsStr);
					fw.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}else if(obj == colorBtn) { //색상표
			JColorChooser cc = new JColorChooser();
			//		부모컨테이너
			Color color= cc.showDialog(this, "색상표", Color.green);
			ta.setForeground(color);
		}else if(obj == calBtn) {
			JDialog dialog = new JDialog(this, "계산기", true);
			Calculator2 cal = new Calculator2();
			dialog.add(cal);
			dialog.setSize(400,500);
			dialog.setVisible(true);
		}
		System.out.println("이벤트발생");
	}
	public void stateChanged(ChangeEvent ce) {
		if(ce.getSource() == redSlider) {
								// 레드 그린 블루
			ta.setBackground(new Color(redSlider.getValue(),100,100));
		}
	}
	public void valueChanged(ListSelectionEvent lse) {
		List<String> selectList = list.getSelectedValuesList();
		String txt="";
		for(int i=0; i<selectList.size(); i++) {
			//ta.append(selectList.get(i)+ "\n");
			txt += selectList.get(i)+ "\n";
		}
		ta.setText(txt);
	}
	
	//
	public static void main(String[] args) {
		new JInternalFrameTest();
	}

}
