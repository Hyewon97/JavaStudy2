//추상클래스 : 추상메소드 포함하고 있다.
// 			class 이전에 abstract이라고 표기하여야한다.
//			추상클래스는 객체생성을 할수 없고 추상클레스 추상메소드를 오버라이딩하여야한다.
public abstract class AbstractTesst {

	int num =1234;
	String name = "홍길동";
	
	public AbstractTesst() {
		
	}

	public void total() {
		int sum = 0;
		for(int i =1; i <= 100; i +=2) {
			sum += i;
		}
		this.num = sum;
		
	}
	
	//추상메소드 : 반드시 반환형 이전에 abstaract 키워드 표기하여야 한다.
	public abstract void output();
	public abstract void sum(int max);
}
