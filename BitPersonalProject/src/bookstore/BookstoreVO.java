package bookstore;

public class BookstoreVO {
	
	private int bookstoreNo;
	private String bookstoreName;
	private String bookstoreWriter;
	private String bookstoreSell;
	private String bookstorePublish;
	
	private int Number;
	
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public int getBookstoreNo() {
		return bookstoreNo;
	}
	public void setBookstoreNo(int bookstoreNo) {
		this.bookstoreNo = bookstoreNo;
	}
	public String getBookstoreName() {
		return bookstoreName;
	}
	public void setBookstoreName(String bookstoreName) {
		this.bookstoreName = bookstoreName;
	}
	public String getBookstoreWriter() {
		return bookstoreWriter;
	}
	public void setBookstoreWriter(String bookstoreWriter) {
		this.bookstoreWriter = bookstoreWriter;
	}
	public String getBookstoreSell() {
		return bookstoreSell;
	}
	public void setBookstoreSell(String bookstoreSell) {
		this.bookstoreSell = bookstoreSell;
	}
	public String getBookstorePublish() {
		return bookstorePublish;
	}
	public void setBookstorePublish(String bookstorePublish) {
		this.bookstorePublish = bookstorePublish;
	}
	public BookstoreVO() {
		
	}
	
	public BookstoreVO(int bookstoreNo, String bookstoreName, String bookstoreWriter, String bookstoreSell, String bookstorePublish) {
		this.bookstoreNo=bookstoreNo;
		this.bookstoreName= bookstoreName;
		this.bookstoreWriter = bookstoreWriter;
		this.bookstoreSell = bookstoreSell;
		this.bookstorePublish = bookstorePublish;
	}

}
