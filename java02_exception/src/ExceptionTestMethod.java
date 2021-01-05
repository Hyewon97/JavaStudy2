
public class ExceptionTestMethod {

	public ExceptionTestMethod() throws ArithmeticException, NumberFormatException, ArrayIndexOutOfBoundsException{
		method1();
	}
	public void method1() throws ArithmeticException, NumberFormatException, ArrayIndexOutOfBoundsException{
		int a=100, b=12;
		int c = a/b; //exception
		System.out.println("c = "+ c);
		method2();
	}
	public void method2() throws NumberFormatException, ArrayIndexOutOfBoundsException{
		String numStr="12";
		int num = Integer.parseInt(numStr); //exception
		System.out.println("num = "+ num);
		method3();
	}
	public void method3() throws ArrayIndexOutOfBoundsException{
		int num[] = {10,20,30};
		System.out.println(num[num.length]); //exception
		
	}
	public static void main(String args[]){
		try {
			new ExceptionTestMethod();
		}catch(ArithmeticException ae) {
			System.out.println("0으로 나눌수 없습니다 ==> " + ae.getMessage());
		}catch(NumberFormatException nf) {
			System.out.println("문자는 숫자로 변경할수 없습니다. --->" + nf.getMessage() );
		}catch(ArrayIndexOutOfBoundsException ar) {
			System.out.println("배열이 잘못되었습니다.==>" + ar.getMessage());
		}
		System.out.println("프로그램 종료");
	}
}
