import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuTest extends JFrame implements ActionListener{
	//--------------------------외형구현-------------------------------------------
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	
	JMenuBar mb = new JMenuBar();
		JMenu fileManu = new JMenu("파일");
			JMenuItem newMenuItem = new JMenuItem("새문서");
			JMenuItem openMenuItem = new JMenuItem("열기");
			JMenuItem saveMenuItem = new JMenuItem("저장");
			JMenuItem endMenuItem = new JMenuItem("종료");
		JMenu editManu = new JMenu("편집");
			JMenuItem cutMenuItem = new JMenuItem("오려두기");
			JMenuItem copyMenuItem = new JMenuItem("복사하기");
			JMenuItem pasteMenuItem = new JMenuItem("붙여넣기");
		JMenu runManu = new JMenu("실행");
			JMenuItem chromeMenuItem = new JMenuItem("크롬");
			JMenu editor = new JMenu("편집기");
				JMenuItem memoMenuItem = new JMenuItem("메모장");
				JMenuItem editplusMenuItem = new JMenuItem("에디터플러스");
			JMenuItem compileMenuItem = new JMenuItem("컴파일");
			
			///////////툴바////////////////
			JToolBar tb = new JToolBar();
			//새문서
			ImageIcon newIcon = new ImageIcon("icon/new01.gif"); JButton newBtn = new JButton(newIcon);
			//저장
			ImageIcon saveIcon = new ImageIcon("icon/save01.gif"); JButton saveBtn = new JButton(saveIcon);
			//열기
			ImageIcon openIcon = new ImageIcon("icon/open01.gif"); JButton openBtn = new JButton(openIcon);
			//진하게
			ImageIcon boldIcon = new ImageIcon("icon/bold01.gif"); JButton boldBtn = new JButton(boldIcon);
			//이탤릭
			ImageIcon italicIcon = new ImageIcon("icon/italic01.gif"); JButton italicBtn = new JButton(italicIcon);
			//글자크기
			JComboBox<Integer> fontSize = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> fontSizeModel = new DefaultComboBoxModel<Integer>();
			//글꼴
			JComboBox<String> fontName = new JComboBox<String>();
			
			
			//////////////////////////////
			String textBuffer; //오려두기떄문에 추가한것
			
			//Font 간련기능
			int bold = 0, italic = 0;
			Font fnt = new Font("굴림체", 0, 14);
			
			//현재 작업중인 파일객체
			File nowFile;
			
			
	public MenuTest() {
		super("메모장");
		add(sp);
		//파일
		fileManu.add(newMenuItem);
		fileManu.add(openMenuItem);
		fileManu.add(saveMenuItem);
		fileManu.addSeparator(); //경계선
		fileManu.add(endMenuItem);
		mb.add(fileManu);
		
		//편집
		editManu.add(cutMenuItem);
		editManu.add(copyMenuItem);
		editManu.add(pasteMenuItem);
		mb.add(editManu);
		
		//실행
		runManu.add(chromeMenuItem);
		runManu.add(editor);
			editor.add(memoMenuItem);
			editor.add(editplusMenuItem);
		runManu.add(compileMenuItem);
		mb.add(runManu);
		
		setJMenuBar(mb);
		//////툴바//////////////////
		tb.add(newBtn);
		tb.add(openBtn);
		tb.add(saveBtn);
		tb.addSeparator();
		tb.add(boldBtn);
		tb.add(italicBtn);
		
		for (int i = 8; i < 70; i+=3) {
			fontSizeModel.addElement(i);
		}
		fontSize.setModel(fontSizeModel);
		fontSize.setSelectedItem(14); //초기 글자크기
		tb.add(fontSize);		
		add(BorderLayout.NORTH, tb);
		//윈도우 운영체제의 글꼴 얻어오기
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fntList = ge.getAvailableFontFamilyNames();
		fontName = new JComboBox<String>(fntList);
		fontName.setSelectedItem("굴림체");
		tb.add(fontName);
		
		ta.setFont(fnt);
		//
		setSize(1000,1000);
		setVisible(true);
		//setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
//-------------------------------------------------외형끝-------------------------------------------------
	//------------------------기능구현-----------------
		//단축키 설정
		setShortcut();
		
		//메뉴를 이벤트 등록
		newMenuItem.addActionListener(this);
		openMenuItem.addActionListener(this);
		saveMenuItem.addActionListener(this);
		endMenuItem.addActionListener(this);
		
		cutMenuItem.addActionListener(this);
		copyMenuItem.addActionListener(this);
		pasteMenuItem.addActionListener(this);
		
		
		chromeMenuItem.addActionListener(this);
		memoMenuItem.addActionListener(this);
		editplusMenuItem.addActionListener(this);
		compileMenuItem.addActionListener(this);
		
		//툴바
		newBtn.addActionListener(this);
		openBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		boldBtn.addActionListener(this);
		italicBtn.addActionListener(this);
		fontSize.addActionListener(this);
		fontName.addActionListener(this);
	}
	//							JMenu, JBitton, JComboBox
	public void actionPerformed(ActionEvent ae) {  //기능구현
		Object eventObj = ae.getSource();
		//이벤트가 발생한 객체가 어떤 클래스로 생성된 것인지 확인
		if(eventObj instanceof JMenuItem){  //왼쪽이 객체 오른쪽에 클래스명 // 왼쪽에 있는객체가 오른쪽에있는 클래스로인해서 생성됀거니?????
			String eventMenu = ae.getActionCommand();
			if(eventMenu.equals("열기")) {
				 fileOpen();
			}else if(eventMenu.equals("새문서")) {
				newfile();
			}else if(eventMenu.equals("저장")) {
				filesave();
			}else if(eventMenu.equals("종료")) {
				System.exit(0);
			}else if(eventMenu.equals("오려두기")) {
				setCut();
			}else if(eventMenu.equals("붙여넣기")) {
				setPaste();
			}else if(eventMenu.equals("복사하기")) {
				setCopy();
			}else if(eventMenu.equals("메모장")) {
				startRuntime("notepad.exe");
			}else if(eventMenu.equals("크롬")) {
				startRuntime("C://Program Files (x86)/Google/Chrome/Application/chrome.exe https://www.naver.com");
			}else if(eventMenu.equals("에디터플러스")){
				startRuntime("C://Program Files/EditPlus/editplus.exe");}
		}else if(eventObj instanceof JButton) {
			if(eventObj == boldBtn) {
				if(bold ==0) {
					bold = 1;
				}else {
					bold = 0;
				}
				fnt = new Font((String)fontName.getSelectedItem(), bold+italic, (Integer)fontSize.getSelectedItem());
				ta.setFont(fnt);
			}else if(eventObj == italicBtn) {
				if(italic ==0 ) italic =2;
				else italic =0;
				fnt = new Font((String)fontName.getSelectedItem(), bold+italic, (Integer)fontSize.getSelectedItem());
				ta.setFont(fnt);
			}else if(eventObj == openBtn) {
				fileOpen();
			}else if(eventObj == newBtn) {
				newfile();
			}else if(eventObj == saveBtn) {
				filesave();
			}
		}else if(eventObj instanceof JComboBox) {
			if(eventObj == fontSize || eventObj == fontName) {
				fnt = new Font((String)fontName.getSelectedItem(), bold+italic, (Integer)fontSize.getSelectedItem());
				ta.setFont(fnt);
			}
		}
	}
	
	public void newfile() { //새문서
		nowFile = null; //작업문서객체 초기화
		ta.setText(""); //콘텐츠 내용날리기
		setTitle("메모장");
		
		
	}
	public void filesave() { //파일저장
		if(nowFile == null) { //새로 문서를 작성후 저장한다.
			JFileChooser fc = new JFileChooser();
			int state = fc.showSaveDialog(this); //saveBtn = 0, cancelBtn = 1
			if(state == 0) { //저장버튼을 누르면
				//선택한 드라이므명, 결로, 파일명
				File f = fc.getSelectedFile();
				//글내용
				String str = ta.getText();
				//중복된이름
				if(f.exists()) {
					JOptionPane.showMessageDialog(this, "이미 존재하는 파일명입니다. \n 저장하기가 취소되었습니다.");
				}else {
					try {
						//FileWriter 객체
						FileWriter fw = new FileWriter(f);
						fw.write(str, 0, str.length());
						fw.flush();
						fw.close();
						
						nowFile = f;
						setTitle(f.getPath());
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		}else { //이미 있는 문서를 열어서 수정후 저장한다.
			String writeTxt = ta.getText();
			try {
				FileWriter fw = new FileWriter(nowFile);
				fw.write(writeTxt, 0 , writeTxt.length());
				fw.flush();
				fw.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void fileOpen() { //파일열기
		File f = new File("C://SAMPLE");
		JFileChooser fc = new JFileChooser();//파일탐색기
		//여러파일을 선택할수 있도록 설정
		fc.setMultiSelectionEnabled(true);// true:다중선택 false: 단일선택
		
		//필터설정
		FileFilter ff1 = new FileNameExtensionFilter("이미지", "jpg","png","bmp");
		fc.addChoosableFileFilter(ff1);
		
		FileFilter ff2 = new FileNameExtensionFilter("java", "java", "JAVA", "Java");
		fc.addChoosableFileFilter(ff2);
		// 0:열기, 1: 취소
		int state = fc.showOpenDialog(this); //파일탐색기열림
		if(state ==0) {
			try {
					ta.setText("");//원래있는 컨텐츠 지우기
					//File selFile = fc.getSelectedFile();
					File selFile[] = fc.getSelectedFiles();
					for (File s : selFile) {
						//현재 파일명을 JFrame에 제목으로 설정
						String path = s.getPath();
						setTitle(path);
						nowFile = s;
						
						FileReader fr = new FileReader(s);
						BufferedReader br = new BufferedReader(fr);
						
						while(true) {
							String inData = br.readLine();
							if(inData ==null) {
								break;
							}
							ta.append(inData+ "\n");
						}//while
						//ta.append("------------------------------------------------\n");
					}//
			}catch(Exception e) {
				System.out.println("파일열기 오류");
				e.printStackTrace();
			}
		}
	}
	
	public void setCut() { //오려두기
		textBuffer = ta.getSelectedText();
		ta.replaceSelection("");
	}
	public void setPaste() { //붙여넣기
		if(textBuffer != null && textBuffer.equals("")) {
			ta.replaceSelection(textBuffer);
		}
	}
	public void setCopy() { //복사하기
		textBuffer = ta.getSelectedText();
	}
	public void startRuntime(String process) {//외부 실행형 파일구현	
		Runtime run = Runtime.getRuntime();
		try {
			run.exec(process);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	public void setShortcut() { //단축키 설정
		//종료 : ctrl + e
		//1. E 단축키를 무엇으로 할것인지 설정
		endMenuItem.setMnemonic(KeyEvent.VK_E);
		
		//2. ctrl 단축키를 무엇으로 할것인지 설정					단축키			mask키
		endMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		
		//새문서 Ctrl + n
		newMenuItem.setMnemonic(KeyEvent.VK_N);
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		//열기 alt + o
		openMenuItem.setMnemonic(KeyEvent.VK_O);
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
		//저장 Ctrl + s
		saveMenuItem.setMnemonic(KeyEvent.VK_S);
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
	}
	public static void main(String args[]) {
		new MenuTest();
	}

}
