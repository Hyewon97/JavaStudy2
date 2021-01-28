import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClock extends JFrame implements Runnable{
	
	 	JLabel timeView = new JLabel("00:00:00", JLabel.CENTER);
	 	Font fnt = new Font("굴림체", Font.BOLD, 100);
	 
	public DigitalClock() {}
	public DigitalClock(int x, int y, int w, int h) {
		super("Clock");
		
		add(timeView);
		timeView.setFont(fnt);
		
		setBounds(x,y,w,h);  //setSize(w,h), setBound(x,y,w,h), pack(): 컨텐츠 내용만큼 크기 정해짐
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

	public void run() {
		while(true) {
			Calendar now = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			String txt = format.format(now.getTime());
			timeView.setText(txt);
			try {Thread.sleep(1000);}catch(Exception e){}
		}
		
	}

	public void DigitalClock() {
		SimpleDateFormat timee = new SimpleDateFormat("hh:mm:ss");
		Calendar time = Calendar.getInstance();
		JLabel lbl= new JLabel(timee.format(time.getTime()));
		
		add(lbl);
	}

	public static void main(String[] args) {
		new DigitalClock();

	}

}
