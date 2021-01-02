
public interface interfaceTest extends interfaceTest2 {
	//static 멤버변수들
	public static String global ="seoul";
	public static final int Max = 100; //상수화된 변수 : 100이외의 값은 대입할수 없음
	
	// 추상메소드들	의 집합
	public void print();
	public int[] recordAll(int num);
	public String total(int max);
	
}
