package bookstore;

import java.util.HashMap;

public class BookstoreDataSet {

	public static HashMap<String, BookstoreVO> BookstoreList = new HashMap<String, BookstoreVO>();
	public BookstoreDataSet() {
		
	}
	public static void setBookstoreList() {
		BookstoreList.put("Yes24", new BookstoreVO(1, "취업을 위한 코딩테스트다", "나동빈", "1000", "한빛미디어"));
		BookstoreList.put("교보문구", new BookstoreVO(2, "혼자하는 공부 자바	", "신용권", "10000", "한빛미디어"));
		BookstoreList.put("신촌문구", new BookstoreVO(3, "생활코딩!			", "이고잉", "2222", "위키북스"));
		BookstoreList.put("비트문구", new BookstoreVO(4, "do it! 첫코딩 자바!", "정동균", "3333", "이지스퍼블리싱"));
		BookstoreList.put("연대문구", new BookstoreVO(5, "자바의정석 기초편	", "남궁성", "4444521", "도우출판"));
	}

}
