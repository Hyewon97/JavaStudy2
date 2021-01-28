
public class PackmanMulti {
	
	/*
	  쓰레드를 이용할수있는방법
	  1. Thread클래스
	  2. runable 인터페이스상속
	  
	  자는건waits
	 */
	public PackmanMulti() {
		PackmanT dc1 = new PackmanT(1, 1, 500, 200);
		PackmanT dc2 = new PackmanT(501, 1, 500, 200);
		PackmanT dc3 = new PackmanT(1, 201, 500, 200);
		PackmanT dc4 = new PackmanT(501, 201, 500, 200);
		
		Thread t1 = new Thread(dc1);
		Thread t2 = new Thread(dc2);
		Thread t3 = new Thread(dc3);
		Thread t4 = new Thread(dc4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	public static void main(String[] args) {
		new PackmanMulti();
	}

}
