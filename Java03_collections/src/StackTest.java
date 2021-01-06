import java.util.Stack;

public class StackTest {

	public StackTest() {
		//FILO :먼저 추가된 객체가 나중에 나온다.
		Stack<Integer> stack= new Stack<Integer>();
		
		stack.push(100);//데이터를 넣는과정
		stack.push(200);
		stack.push(300);
		
		while(!stack.empty()) {
			System.out.println(stack.pop());
			System.out.println("남은 객체수 - > " + stack);
		}
		
	}

	public static void main(String[] args) {
		new StackTest();

	}

}
