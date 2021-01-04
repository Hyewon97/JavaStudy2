import java.util.Scanner;

public class ExceptionEx2 {
	Scanner sc =  new Scanner(System.in);
	public ExceptionEx2() {
		try {
			System.out.print("첫번쨰 수 => ");
			int num1 = Integer.parseInt(sc.nextLine());

			System.out.print("두번째 수 => ");
			int num2 = Integer.parseInt(sc.nextLine());   // --!!!! NumberFormatException
			
			int result = num1 * num2;
			int result2 = num1 / num2;  //---- 0으로 나누기 ArithmeticException
			
			System.out.println(num1 + "*" + num2 + "= " + result);
			System.out.printf("%d/%d=%d\n", num1, num2, result2);
			
			String names[] = {"세종대왕", "이순신"};   
			for (int i = 0; i <=names.length; i++) {  //배열 index ArrayIndexOUtOfBoundsException
				System.out.println("names["+i+"]= "+ names[i]);
			}
		}catch(ArrayIndexOutOfBoundsException aoe) {
			System.out.println("배열에서 예외 발생");
		}catch(Exception e) { //위에 catch를 제외한 나머지
			System.out.println("0을 제외한 정수를 입력하세요 .. ->" + e.getMessage());
		}
	}


	public static void main (String args[]) {
		new ExceptionEx2();
	}
}