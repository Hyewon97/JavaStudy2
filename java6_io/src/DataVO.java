import java.io.Serializable;

public class DataVO implements Serializable{
	private int Num;
	private String Name;
	private String Tel;
	private String Email;
	
	



	public int getNum() {
		return Num;
	}





	public void setNum(int num) {
		Num = num;
	}





	public String getName() {
		return Name;
	}





	public void setName(String name) {
		Name = name;
	}





	public String getTel() {
		return Tel;
	}





	public void setTel(String tel) {
		Tel = tel;
	}





	public String getEmail() {
		return Email;
	}





	public void setEmail(String email) {
		Email = email;
	}





	public DataVO() {
		// TODO Auto-generated constructor stub
	}

}
