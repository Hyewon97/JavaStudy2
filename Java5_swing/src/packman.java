import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class packman extends JFrame implements KeyListener{

	MyCanvas mc = new MyCanvas();
	Image img;
	int x=350, y=400;
	int sel=2;
	
	public packman() {
		
		setBackground(Color.white);
		setSize(800,800); //창크기
		setVisible(true); //보이게허용
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //창꺼질때 꺼지게하기
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addKeyListener(this);
		update(getGraphics());
		add("Center", mc);
		while(true) {
			mc.getX();
			mc.getY();
			mc.repaint();
			//일시정지
			try{Thread.sleep(100);}catch(Exception e){}
		}
	}
	
	public class MyCanvas extends Canvas{
		int w,h;
		public MyCanvas() {
			img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
		}
		public void paint(Graphics g) {
			//g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer);
			      //dx1,dy1 : 출력화면 시작점, dx2 dy2:출력화면 마지막점
			//                         sx1, sy1:원본파일의 시작점, sx2, sy2 : 원본파일의 마지막점
			g.drawImage(img, x,y,x+50,y+50, sel*50,0,sel*50+50,50, this);

		}

	}
	
	public static void main(String[] args) {
		new packman();
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		while(true) {
			if(e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_A) {
				x -= 10;
				if(sel==0){
					sel=1;
				}else if(sel==1){
					sel=0;
				}else{
					sel=0;
				}
				break;
			} else if(e.getKeyCode()==KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_D){
				x += 10;
				if(sel==3){
					sel=2;
				}else if(sel==2){
					sel=3;
				}else{
					sel=3;
				}
				break;
			} else if(e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_W){
				y -= 10;
				if(sel==4){
					sel=5;
				}else if(sel==5){
					sel=4;
				}else{
					sel=5;
				}
				break;
			} else if(e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_S){
				y += 10;
				if(sel==7){
					sel=6;
				}else if(sel==6){
					sel=7;
				}else{
					sel=7;
				}
				break;
			}
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
}
