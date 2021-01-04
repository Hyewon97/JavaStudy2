import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class ExceptionEx {

	public ExceptionEx() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				System.out.print("첫번쨰 수 => ");
				int num1 = Integer.parseInt(sc.nextLine());
				//int num1 = sc.nextInt();
				System.out.print("두번째 수 => ");
				int num2 = Integer.parseInt(sc.nextLine());   //
				//int num2 = sc.nextInt();                   // inputMismatchException
				
				int result = num1 * num2;
				int result2 = num1 / num2;  //---- 0으로 나누기 ArithmeticException
				
				System.out.println(num1 + "*" + num2 + "= " + result);
				System.out.printf("%d/%d=%d\n", num1, num2, result2);
				
				String names[] = {"세종대왕", "이순신"};   
				for (int i = 0; i <=names.length; i++) {  //배열 index ArrayIndexOUtOfBoundsException
					System.out.println("names["+i+"]= "+ names[i]);
				}					
			}catch(NumberFormatException nfe) {
				System.out.println("숫자만 입력하세요 ");
			}catch(InputMismatchException ime) {
				System.out.println("숫자만 입력해주세요");
				break;
			}catch(ArithmeticException ae) {
				System.out.println("두번째 값은 0외의 값으로 입력해주세요");
				break;
			}catch(ArrayIndexOutOfBoundsException ai) {
				System.out.println("배열의 index를 잘못사용하였습니다." + ai.getMessage());
				break;
			}
		}
	}


	public static void main (String args[]) {
		new ExceptionEx();
	}
}