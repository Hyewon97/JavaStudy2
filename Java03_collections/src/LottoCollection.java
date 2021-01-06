import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoCollection {

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	
	public LottoCollection() {
		
	}
	public void start() {
		do {
			int cnt = gameCount(); //게임수
			for(int i=1; i<=cnt; i++) {
				System.out.print(i+"게임=");
				createLotto();
			}
			//true:계속, false:중지
			if(!qua()) {
				break;
			}
		}while(true);
		System.out.println("------------------END----------------");
	}
	
	//게임수 입력
	public int gameCount() {
		
		int intCnt = 0;
		do {
			try {
				System.out.print("게임수 = ");
				intCnt = Integer.parseInt(scan.nextLine());
				//게임의 수가 양수가 아닐경우 게임수를 다시 입력받도록 처리
				if (intCnt<=0) {
					throw new Exception("게임수는 1보다 큰값이여야 합니다.."); //강제 예외처리 
				}
				break;//게임수가 입력되었을때
			}catch(NumberFormatException ne) {
				System.out.println("게임수는 정수만 입력해야합니다.");
			}catch(Exception e) {//위에 정수뺴놓고는 전부다 메세지만 보여줄것
				System.out.println(e.getMessage());
			}
		}while(true);
		return intCnt;
	}
	
	//로또 1게임만드는 메소드
	public void createLotto() {
		Random ran = new Random();
		TreeSet<Integer> ts =new TreeSet<Integer>();
		int lastNum = 0;
		//생성 -> TreeSet -> 7개가 될때까지
		while(true){
			lastNum = ran.nextInt(45)+1; //1~45마지막으로 만들어진 번호
			ts.add(lastNum);
			if(ts.size()>=7)break;
		}
		
		//마지막으로 생성된 번호는 보너스이므로 TreeSet에서 제거한다.
		ts.remove(lastNum);
		System.out.print(ts.toString());
		System.out.println(", bonus=" + lastNum);
	}
	//계속여부 확인하기
	public boolean qua() {
		boolean boo =false;
		
		do {
			System.out.print("계속하시겠습니까?(Y or y:예, N or N:아니요) ");
			String que = scan.nextLine();
			if(que.equalsIgnoreCase("Y")) {
				boo = true;
				break;
			}else if(que.equalsIgnoreCase("N")) {
				boo = false;
				break;
			}else {
				System.out.println("Y or N을 입력하세요");
			}
		}while(true);
		
		return boo;
	}
	public static void main(String[] args) {
		LottoCollection lotto = new LottoCollection();
		lotto.start();
	}

}
