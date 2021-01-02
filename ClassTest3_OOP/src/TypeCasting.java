
public class TypeCasting {

	public TypeCasting() {
		BBB b1 =new BBB();
		b1.print();
		b1.namePrint();
		
		//하위클래스로 객체를 생성하여 상위클래스 변수에 대입가능하다.
		AAA a1 = new BBB();
		a1.print();
		//a1.namePrint(); //AAA클래스에는 BBB클래스가 숨겨져있다.
		
		BBB b2 = (BBB)a1;
		b2.namePrint();
		
		// 상위 클래스의 객체를 하위 클래스의 래퍼런스 변수에 대입할tn djqtek.
		AAA a2 = new AAA();
		//BBB b3 =(BBB)a2;
		//b3.namePrint();//이건 에러가뜸!!
		
		BBB b3 = new BBB();
		b3.output();
		
		//하위 클래스에서 오버라이딩 된 메소드는 상위 클래스로 타입캐스팅하더라도 메소드가 존재한다.
		AAA a3 = b3;
		a3.output();
		
		Object obj = new BBB();
		BBB b4 = (BBB)obj;
	
	}

	public static void main(String[] args) {
		new TypeCasting();
	}

}
