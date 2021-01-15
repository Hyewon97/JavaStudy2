package bookstore;

import java.util.HashMap;

public class BookstoreDataSet {

	public static HashMap<String, BookstoreVO> BookstoreList = new HashMap<String, BookstoreVO>();
	public BookstoreDataSet() {
		
	}
	public static void setBookstoreList() {
//		BookstoreList.put("책이름    ", new BookstoreVO(1, "책이름     ", "책저자", "출판사", 5000, 10));
		BookstoreList.put("코딩테스트다", new BookstoreVO(1, "코딩테스트다", "나동빈", "한빛미디어", 5000));
		BookstoreList.put("혼자하는 자바", new BookstoreVO(2, "혼자하는 자바", "신용권", "한빛미디어", 7000));
		BookstoreList.put("생활코딩 책", new BookstoreVO(3, "생활코딩 책 ", "이고잉", "위키북스", 8000));
		BookstoreList.put("do it!자바!", new BookstoreVO(4, "do it!자바!", "정동균", "퍼블리싱", 5900));
		BookstoreList.put("자바의정석기초", new BookstoreVO(5, "자바의정석기초", "남궁성", "도우출판", 7500));
		//BookstoreList.put("남궁성", new BookstoreVO())
	}

}
