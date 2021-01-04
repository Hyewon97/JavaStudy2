import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest1 {

	public ExceptionTest1() {
		try {
			//예외처리하기
			//예외 발생 가능한 코드와 예외 발생가능성이 없는 코드도 명시가 가능하다.
			Scanner sc = new Scanner(System.in);
			System.out.print("정수를 입력하세요 = ");
			int n = sc.nextInt();
			System.out.println("n = "+ n);
		}catch(InputMismatchException ime) { //int 부분에 문자열을넣으면 에러나는 부분을 예외처리로 잡음
			//try 영역의 코드가 예외가 발생하면 실행될 영역
			//ime.printStackTrace();
			System.out.println(ime.getMessage());
			System.out.println("숫자를 잘못입력하였습니다. ");
		}
		System.out.println("프로그램 종료되었습니다.");
	}

	public static void main(String[] args) {
		new ExceptionTest1();

	}

}
