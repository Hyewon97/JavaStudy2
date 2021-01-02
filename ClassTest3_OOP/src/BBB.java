
public class BBB extends AAA{
	
	String name = "홍 길 동";
	String tel = "010-5555-6666";
	public BBB() {
		
	}
	public void namePrint() {
		System.out.println("이름 = "+ name);
	}
	//Override
	public void output() {
		System.out.println(name + " =>" + tel);
	}

}
