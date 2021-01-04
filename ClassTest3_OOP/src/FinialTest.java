//클래스에다가 final을 붙이면 상속하지 않는다.
//public final class FinialTest {
public class FinialTest {
	
	final int STATUS = 1;
	public FinialTest() {
		// TODO Auto-generated constructor stub
	}
	//하위클래스에서 total()은 오버라이딩 할수 없는 메소드가됌
	public final void total() {
		int i = 0;
		for(int j=1; j<=100; j+=2) {
			i += j;
		}
		System.out.println("1~100까지의 홀수의 합은 " + i);
	}

}
