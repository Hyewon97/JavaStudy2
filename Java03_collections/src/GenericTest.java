import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GenericTest<T> {
	
	private T username;
	
	public GenericTest() {}
	public GenericTest(T username) {
		this.username = username;
	}
	
	public T getUsername() {
		return username;
	}
	
	public void setUsername(T username) {
		this.username = username;
	}
	public void dataOutput() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fmt = format.format(((Calendar)username).getTime());
		System.out.println("fmt -> " + fmt);
	}
}



/*
  E : elements
  K : key
  V : value 
 */
