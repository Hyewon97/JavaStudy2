import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import bookstore.BookstoreDataSet;
import bookstore.BookstoreVO;
import login.Login;
import member.MemberDataSet;
import member.MemberVO;

public class BookstoreMain {
	Scanner scan = new Scanner(System.in);
	
	public BookstoreMain() {
		
	}
	
	public void start() {
		//아이디와 비밀번호를 입력받아 로그인 구현하기
		Login.id = conInput("아이디");
		Login.pwd = conInput("비밀번호");
		Login.num = conInput("관리자면 1번 일반회원이면 2번을 입력하세요");
		if(Login.login()) { //일반회원로그인시
			BookstoreDataSet.setBookstoreList();
			do { 
				String menu = conInput("메뉴[1.책보기, 2.책등록 , 3.책수정, 4.책삭제 6.로그아웃]");
				if(menu.equals("5")) {//로그아웃
					break;
				}else if(menu.equals("1")){//책전체목록
					bookstoreOutput();
				}else if(menu.equals("2")) {//책등록
					bookstoreInsert();
				}else if(menu.equals("3")) {//책수정
					bookstoreEdit();
				}else if(menu.equals("4")) {//책삭제
					bookstoreDel();
				}
			}while(true);
		}else if(Login.login()) { //관리자 로그인시
			BookstoreDataSet.setBookstoreList();
			MemberDataSet.setMemberList();
			do { 
				String menu = conInput("메뉴[1.책보기, 2.책등록 , 3.책수정, 4.책삭제, 5.회원목록 6.회원등록 7.회원수정 8. 회원삭제 9.로그아웃]");
				if(menu.equals("9")) {//로그아웃
					break;
				}else if(menu.equals("1")){//책전체목록
					bookstoreOutput();
				}else if(menu.equals("2")) {//책등록
					bookstoreInsert();
				}else if(menu.equals("3")) {//책수정
					bookstoreEdit();
				}else if(menu.equals("4")) {//책삭제
					bookstoreDel();
				}else if(menu.equals("5")) {//회원목록
					memberOutput();
				}else if(menu.equals("6")) {//회원등록
					bookstoreInsert();
				}else if(menu.equals("7")) {//회원수정
					bookstoreEdit();
				}else if(menu.equals("8")) {//회원삭제
					bookstoreDel();
				}
			}while(true);
		}else{ //로그인 실패시 
			System.out.println("잘못 입력하셨습니다.");
		}
	}

	//책 전체목록 출력
	public void bookstoreOutput() {
		Set<String> keyList = BookstoreDataSet.BookstoreList.keySet();
		Iterator<String> ii = keyList.iterator();
		while(ii.hasNext()) {
			BookstoreVO vo = BookstoreDataSet.BookstoreList.get(ii.next());
			System.out.printf("%d\t%s\t%s\t%s\t%s\n", vo.getBookstoreNo(), vo.getBookstoreName(), vo.getBookstoreWriter(), vo.getBookstoreSell(), vo.getBookstorePublish());
		}
	}
	
	//회원 등록
	public void bookstoreInsert() {
		int no = Integer.parseInt(conInput("회원번호"));
		String name = conInput("회원이름");
		String writer = conInput("회원전화번호");
		String sell = conInput("회원아이디");
		
		MemberDataSet.MemberList.put(name, new MemberVO(no, name, writer, sell));
	}
	
	//책 수정
	public void bookstoreEdit() {
		//책 명
		String bookstoreName = conInput("수정할 사원명");
		
		// 해당 책의 정보가 없을때
		BookstoreVO vo = BookstoreDataSet.BookstoreList.get(bookstoreName);
		if(vo==null) {
			System.out.println("존재하지 않는 책입니다.");
		}else {//해당 책의 정보가 있을때
			//책 이름, 저자, 판매수, 출판사
			String subMenu = conInput("수정할 필드 선택[1.책이름, 2.책저자, 3.판매수, 4.출판사]");
			if(subMenu.equals("1")) {
				String name = conInput("수정할 책이름");
				vo.setBookstoreWriter(name);
			}else if(subMenu.equals("2")) {
				String writer = conInput("수정할 책저자");
				vo.setBookstoreSell(writer);
			}else if(subMenu.equals("3")) {
				String sell = conInput("수정할 판매수");
				vo.setBookstoreSell(sell);
			}else if(subMenu.equals("4")) {
				String publish = conInput("수정할 출판사");
				vo.setBookstorePublish(publish);
			}
		}
	}
	
	//책삭제
	public void bookstoreDel() {
		String bookstoreName = conInput("삭제할 책이름");
		BookstoreDataSet.BookstoreList.remove(bookstoreName);
	}
	
	//회원 전체목록 출력
	public void memberOutput() {
		Set<String> keyList = MemberDataSet.MemberList.keySet();
		Iterator<String> ii = keyList.iterator();
		while(ii.hasNext()) {
			MemberVO vo = MemberDataSet.MemberList.get(ii.next());
			System.out.printf("%d\t%s\t%s\t%s\t\n", vo.getMemberNo(), vo.getMemberName(), vo.getMemberPN(), vo.getMemberId());
		}
	}
	//회원 수정
	public void memberEdit() {
		//회원명
		String memberName = conInput("수정할 회원명");
		
		// 해당 회원의 정보가 없을때
		MemberVO vo = MemberDataSet.MemberList.get(memberName);
		if(vo==null) {
			System.out.println("존재하지않는 회원입니다.");
		}else {//해당 회원의 정보가 있을때
			//회원 번호, 이름, 전화번호, 아이디
			String subMenu = conInput("수정할 필드 선택[1.회원이름, 2.회원전화번호, 3.회원아이디]");
			if(subMenu.equals("1")) {
				String name = conInput("수정할 회원이름");
				vo.setMemberName(name);
			}else if(subMenu.equals("2")) {
				String Pn = conInput("수정할 회원전화번호");
				vo.setMemberPN(Pn);
			}else if(subMenu.equals("3")) {
				String Id = conInput("수정할 회원아이디");
				vo.setMemberId(Id);
			}
		}
	}
	
	//회원삭제
	public void memberDel() {
		String memberNameName = conInput("삭제할 회원이름");
		MemberDataSet.MemberList.remove(memberNameName);
	}
	
	//콘솔에서 문자입력받아 리턴하는 메소드
	public String conInput(String msg) {
		System.out.print(msg + "=");
		return scan.nextLine();
	}
	
	//시작하는메소드
	public static void main(String[] args) {
		new BookstoreMain().start();
		System.out.println("시스템이 종료되었습니다.");
	}

}
