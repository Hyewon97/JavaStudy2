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
		Login.num = intInput("관리자면 1번 일반회원이면 2번을 입력하세요");
		
		//미리 데이터셋을 가져온다.
		BookstoreDataSet.setBookstoreList();
		MemberDataSet.setMemberList();
		
		while(true) {	
			if(Login.login() && Login.id.equals("123")) { //일반

				System.out.println("==============================강산서점 회원프로그램==============================");
				String menu = conInput("메뉴[1.책목록, 2.책사기, 3.책검색, 4.충전하기, 5.잔액확인하기 6.로그아웃 E 프로그램종료]");
				System.out.println("==========================================================================");
				if(menu.equals("E")) {//로그아웃
					break;
				}else if(menu.equals("1")){//책전체목록
					bookstoreOutput();
				}else if(menu.equals("2")) {//책사기
					try{bookstoreBuy();
						}catch(NullPointerException null32) {
							System.out.println("이름이나 책이름이 잘못되었습니다.");
						}
				}else if(menu.equals("3")) {//책검색
					bookstoreSearch();
				}else if(menu.equals("4")) {//충전하기
					charging();
				}else if(menu.equals("5")) {//잔액확인하기
					charge();
				}else if(menu.equals("6")) {//로그아웃
					start();
				}
				System.out.println("");
				
			}else if(Login.login()&& Login.id.equals("master")) { //관리자 
					System.out.println("==========================================강산서점 관리자프로그램==============================================");
					String menu = conInput("메뉴[1.책보기, 2.책등록 , 3.책수정, 4.책삭제, 5.회원목록 6.회원등록 7.회원수정 8. 회원삭제 9.로그아웃 E.프로그램종료]");
					System.out.println("========================================================================================================");
					if(menu.equals("E")) {//프로그램종료
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
						memberInsert();
					}else if(menu.equals("7")) {//회원수정
						memberEdit();
					}else if(menu.equals("8")) {//회원삭제
						memberDel();
					}else if(menu.equals("9")) {//로그아웃
						start();
					}
					System.out.println("");
				}else{ //로그인 실패시 
					System.out.println("잘못 입력하셨습니다."); break;
				}
			}
	}
	
	


//----------------------------------------------회원기능영역-----------------------------------------
	
	public void bookstoreBuy(){ //책사기
		String memberName = conInput("회원이름");
		String bookstoreName = conInput("살 책이름");
		MemberVO vo = MemberDataSet.MemberList.get(memberName);
		BookstoreVO vo1 = BookstoreDataSet.BookstoreList.get(bookstoreName);
		String name = vo.getMemberName();		//vo.getMemberName에서 가져온 이름
		int youcharge = vo.getCharge();			//현재금액
		int total = vo.getCharge()- vo1.getBooktotal(); //현재금액-책값
		int stock = vo1.getStock() - 1;		//재고수
		
		if(total < 0) {
			System.out.println("잔액이 부족합니다 충전후에 이용하세요.");
		}else if(total > 0){
			System.out.println("구매하신 회원님의 이름은 " + name + "이며 사기전 금액은 " + youcharge + "원 이였고, "+ "책 가격은 "+ vo1.getBooktotal()+ "원 입니다.");
			System.out.println("사고난 후 금액은 " + total + "원 입니다.");
			System.out.println("해당 책의 재고는 " + stock + "개 남았습니다.");
			vo.setCharge(total);
			vo1.setBooktotal(stock);
		}else if(stock == 0) {
			System.out.println("재고가 부족하여 구매가 불가능합니다.");
		}else if(vo == null || vo1 == null){
			System.out.println("이름이나 책 이름이 잘못되었습니다.");
		}
	}
	
	public void bookstoreSearch() { //책검색
        String bookstoreName = conInput("찾고싶은 책 이름를 검색하세요");
		BookstoreVO vo = BookstoreDataSet.BookstoreList.get(bookstoreName);
        switch (bookstoreName) {
			case "코딩테스트다"   : System.out.println("확인 결과 "+vo.getBookstoreName()+"는 저희서점에 있습니다."); break;
			case "혼자하는 자바"  : System.out.println("확인 결과 "+vo.getBookstoreName()+"는 저희서점에 있습니다."); break;
			case "생활코딩 책"   : System.out.println("확인 결과 "+vo.getBookstoreName()+"는 저희서점에 있습니다.");  break;
			case "do it!자바!"  : System.out.println("확인 결과 "+vo.getBookstoreName()+"는 저희서점에 있습니다."); break;
			case "자바의정석기초" : System.out.println("확인 결과 "+vo.getBookstoreName()+"는 저희서점에 있습니다."); break;
			default : System.out.println("해당 이름의 책은 없습니다."); break;
        }	
	}
	public void charging() {  //잔액충전
		String memberName = conInput("충전할 회원이름");
		MemberVO vo = MemberDataSet.MemberList.get(memberName);  
		if(vo==null) {
			//System.out.println("vo.memberName에 뭐가담겨있니? = "+ vo.getMemberName());
			System.out.println("존재하지 않는 이름입니다.");
		}else {//해당 회원의 정보가 있을때
			int charge1 = vo.getCharge();
			System.out.println("현재 " + vo.getCharge() + "원 있습니다.");
			int charge2 = intInput("얼마를 충전하시겠습니까? ");
			vo.setCharge(charge1+charge2);
			System.out.println("충전된 현재 금액은 = " + vo.getCharge() + "원 입니다. ");
		}
	}
	public void charge() { //잔액확인
		String memberName = conInput("잔액을 확인할 회원이름");
		MemberVO vo = MemberDataSet.MemberList.get(memberName);
		if(vo==null) {
			System.out.println("존재하지 않는 이름입니다.");
		}else {
			System.out.println("현재 " + vo.getCharge() + "원 있습니다.");
		}
	}

//----------------------------------관리자영역----------------------------------------------------------
//---------------------------------관리자 책 + 일반회원 책 출력만-----------------------------------------
	//책 전체목록 출력
	public void bookstoreOutput() {
		Set<String> keyList = BookstoreDataSet.BookstoreList.keySet();
		Iterator<String> ii = keyList.iterator();
		while(ii.hasNext()) {
			BookstoreVO vo = BookstoreDataSet.BookstoreList.get(ii.next());
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t\n", vo.getBookstoreNo(), vo.getBookstoreName(), vo.getBookstoreWriter(), vo.getBookstorePublish(), vo.getBooktotal(), vo.getStock());
		}
	}
	
	//책등록
	public void bookstoreInsert() {
		try {
			int bookstoreNo = Integer.parseInt(conInput("책번호"));
			String bookstoreName = conInput("책이름");
			String bookstoreWriter = conInput("책저자");
			String bookstorePublish = conInput("출판사");
			int booktotal = intInput("책가격");
			int stock = intInput("재고량");
		
			BookstoreDataSet.BookstoreList.put(bookstoreName, new BookstoreVO(bookstoreNo, bookstoreName, bookstoreWriter, bookstorePublish, booktotal, stock));
		}catch(NumberFormatException ne) {
			System.out.println("잘못입력하셨습니다. 다시 시도해주세요");
		}
	}
	
	//책 수정
	public void bookstoreEdit() {
		//책 명
		String bookstoreName = conInput("책이름");
		
		// 해당 책의 정보가 없을때
		BookstoreVO vo = BookstoreDataSet.BookstoreList.get(bookstoreName);
		if(vo==null) {
			System.out.println("존재하지 않는 책입니다.");
		}else {//해당 책의 정보가 있을때
			//책 이름, 저자, 판매수, 출판사
			String subMenu = conInput("수정할 필드 선택[1.책저자, 2.출판사]");
			if(subMenu.equals("1")) {
				String writer = conInput("수정할 책저자");
				vo.setBookstoreWriter(writer);
			}else if(subMenu.equals("2")) {
				String publish = conInput("수정할 출판사");
				vo.setBookstorePublish(publish);
			}
		}
	}
	
	//책삭제
	public void bookstoreDel() {
		String bookstoreName = conInput("삭제할 책이름");
		BookstoreVO vo = BookstoreDataSet.BookstoreList.get(bookstoreName);
		if(vo==null) {
			System.out.println("책이름을 잘못 입력하셨습니다.");
		}else {
			BookstoreDataSet.BookstoreList.remove(bookstoreName);
			System.out.println("삭제되었습니다.");
		}
		System.out.println("========================================================================================================");
		bookstoreOutput();
	}
	
	//-------------------------------------관리자 책끝-------------------------------------------
	//---------------------------------관리자 회원시작------------------------------------------
	//회원 전체목록 출력
	public void memberOutput() {
		Set<String> keyList = MemberDataSet.MemberList.keySet();
		Iterator<String> ii = keyList.iterator();
		while(ii.hasNext()) {
			MemberVO vo = MemberDataSet.MemberList.get(ii.next());
			System.out.printf("%d\t %s\t %s\t %s\t %s\t \n", vo.getMemberNo(), vo.getMemberName(), vo.getMemberPN(), vo.getMemberId(), vo.getCharge());
		}
	}
	// 등록
	public void memberInsert() {
		try {
			int no = Integer.parseInt(conInput("회원번호"));
			String name = conInput("회원이름");
			String writer = conInput("회원전화번호");
			String sell = conInput("회원아이디");
			int charge = 0;
			
			MemberDataSet.MemberList.put(name, new MemberVO(no, name, writer, sell, charge));
		}catch(NumberFormatException ne) {
			System.out.println("잘못입력하셨습니다. 다시 시도해주세요");
		}
	}
		
	//회원 수정
	public void memberEdit() {
		//회원명
		String memberName = conInput("회원명");
		MemberVO vo = MemberDataSet.MemberList.get(memberName);
		if(vo==null) {// 해당 회원의 정보가 없을때
			System.out.println("존재하지않는 회원입니다.");
		}else {//해당 회원의 정보가 있을때
			//회원 번호, 이름, 전화번호, 아이디
			String subMenu = conInput("수정할 필드 선택[1.회원전화번호, 2.회원아이디, 3.충전금액]");
			if(subMenu.equals("1")) {
				String Pn = conInput("수정할 회원전화번호");
				vo.setMemberPN(Pn);
			}else if(subMenu.equals("2")) {
				String Id = conInput("수정할 회원아이디");
				vo.setMemberId(Id);
			}else if(subMenu.equals("3")) {
				int charge = intInput("수정할 충전금액");
				vo.setCharge(charge);
			}
		}
	}

	//회원삭제
	public void memberDel() {
		String memberNameName = conInput("삭제할 회원이름");
		MemberDataSet.MemberList.remove(memberNameName);
		memberOutput();
	}
	//----------------------------관리자 회원끝--------------------------------------
	
	//콘솔에서 문자입력받아 리턴하는 메소드
	public String conInput(String msg) {
		System.out.print(msg + "=");
		return scan.next();
	}
	
	//콘솔에서 인트형 입력받아 리턴하는 메소드
	public int intInput(String msg) {
		System.out.print(msg + "=");
		return scan.nextInt();
	}
	
	//시작하는메소드
	public static void main(String[] args) {
		new BookstoreMain().start();
		System.out.println("시스템이 종료되었습니다.");
	}

}
