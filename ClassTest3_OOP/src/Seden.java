
//클래스를 상속받을시 extends를 이용한다.
//클래스는 1개만 상속받을 수 있다.
//Car의 하위클래스인 Seden임
public class Seden extends Car{
	//하위클래스에서 변수를 상위클래스에서 사용할수 있다.
	int speedMax = 150;
	String carColor = "Orange";
	
	public Seden() {
		System.out.println("잘 실행돼니?");
	}
	public Seden(String carName, String carColor) {
		//상위 클래스의 생성자를 호출하는 방법
		//상위클래스의 생성자 호출은 첫번째 행으로 표시된다.
		super("그랜져", 50, "Gray");
		
		//super.carName = carName;
		this.carName = carName;
		super.carColor = carColor;
		System.out.println("seden(string, String) 생성자"
				+ "");
	}
	public void start() {
		System.out.println("색상 : " + carColor);
		System.out.println("색상(parent) : " + super.carColor);//super 상위 클래스의 요소가 찍힘
		System.out.println("이름: " + carName);
	}
	//오버라이딩이라고한다.
	public void speedUp() {
		speed += 15;
		if (speed > 150) {
				speed=150;
		}
	}
	
	public static void main(String[] args) {
		Seden s = new Seden();
		s.speedUp();
		//s.start();
		//Seden ss = new Seden("레오", "Blue");
		//ss.start();
	}

}
