package bookstore;

public class BookstoreVO {
	
	private int bookstoreNo; //책번호
	private String bookstoreName; //책이름
	private String bookstoreWriter; //책저자
	private String bookstorePublish; //출판사
	private int booktotal;	//책가격
	private int stock; 		//재고 
	
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

	public String getBookstorePublish() {
		return bookstorePublish;
	}
	public void setBookstorePublish(String bookstorePublish) {
		this.bookstorePublish = bookstorePublish;
	}
	public int getBooktotal() {
		return booktotal;
	}
	public void setBooktotal(int booktotal) {
		this.booktotal = booktotal;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public BookstoreVO() {
		
	}
	
	public BookstoreVO(int bookstoreNo, String bookstoreName, String bookstoreWriter, String bookstorePublish, int booktotal, int stock) {
		this.bookstoreNo=bookstoreNo;
		this.bookstoreName= bookstoreName;
		this.bookstoreWriter = bookstoreWriter;
		this.bookstorePublish = bookstorePublish;
		this.booktotal = booktotal;
		this.stock = stock;
	}

}
