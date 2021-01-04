
public class FinalMain extends FinialTest {
	
	public FinalMain() {
		
	}
	public void start() {
		//STATUS = 3;
		System.out.println("STATUS = " + STATUS);
		//total(); //오버라이딩됀부분이나옴
		total(); //하위클래스를 쓰려면
		totalEven(100);
	}
	
	//오버라이딩
	public void totalEven(final int k) {
		//k=200; //final변수 이므로 값을 변경할 수 없다.
		System.out.println("1~ 100까지 짝수의 합은 2550");
	}

	public static void main(String[] args) {
		new FinalMain().start();

	}

}
