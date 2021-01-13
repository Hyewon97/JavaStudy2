package bookstore;

import java.util.HashMap;

public class BookstoreDataSet {

	public static HashMap<String, BookstoreVO> BookstoreList = new HashMap<String, BookstoreVO>();
	public BookstoreDataSet() {
		
	}
	public static void setBookstoreList() {
		BookstoreList.put("코딩테스트다", new BookstoreVO(1, "코딩테스트다", "나동빈", "1000", "한빛미디어", 5000, 10));
		BookstoreList.put("혼자하는 자바", new BookstoreVO(2, "혼자하는 자바", "신용권", "10000", "한빛미디어", 7000, 5));
		BookstoreList.put("생활코딩 책", new BookstoreVO(3, "생활코딩 책 ", "이고잉", "2222", "위키북스", 8000, 5));
		BookstoreList.put("do it!자바!", new BookstoreVO(4, "do it!자바!", "정동균", "3333", "퍼블리싱", 5900, 5));
		BookstoreList.put("자바의정석기초", new BookstoreVO(5, "자바의정석기초", "남궁성", "2000", "도우출판", 7500, 4));
		//BookstoreList.put("남궁성", new BookstoreVO())
	}

}
