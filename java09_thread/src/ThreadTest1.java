
//1. Thread 클레스 상속
public class ThreadTest1 extends Thread{
	
	
	/*
	 	Thread를 이용할수있는 방법
	 	1. class Thread 상속
	 	스레드 구현코드는 run()에 구현하면 된다.
	 	.start() -> 스레드에 시작하면된다.
	 	
	 	JVM이 스레드 스케쥴러에 시작요청을하게된다.
	 	우리가 스레드를 통제하수있는게아니라 스레드스케쥴러에 요청하는것
	 	
	 	2. interface Runnable
	 	2.run()오버라이딩
	 	3. thred상속
	 	4. 
	 */
	String title;
	public ThreadTest1(String title) {
		this.title = title;
	}
	public ThreadTest1() {}
	
	//2.run()메소드 오버라이딩
	public void run() {
		for(int i=1;; i++) {
			System.out.println(title +"=" + i);
			try {Thread.sleep(500);}catch(Exception e) {}
		}
	}

	public static void main(String[] args) {
		ThreadTest1 tt1 =new ThreadTest1("첫번쨰 스레드");
		ThreadTest1 tt2 =new ThreadTest1("둘번쨰 스레드"); 

		//3.스레드 등록
		tt1.start();
		tt2.start();


	}

}
