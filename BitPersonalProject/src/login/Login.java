package login;

public class Login {
	
	public static String id;
	public static String pwd;
	
	//관리자, 일반회원 두개로 구분할것
	public static boolean login() {
		//System.out.println("내부로 잘들어왔는지 확인 : login3===== " + Login.id + "  password3===== " + Login.pwd);
		if (id == "" || pwd == "") {
			System.out.println("아이디와 비밀번호를 입력후 로그인하세요.");
			return false;
		} else {
			if(id.equals("master") && pwd.equals("1234")) {
				//System.out.println("login4===== " + Login.id + "  password4===== " + Login.pwd);
				return true;
			}else if(id.equals("123") && pwd.equals("123")){
				//System.out.println("login5===== " + Login.id + "  password5===== " + Login.pwd );
				return true;
			}else {
				//System.out.println("login6===== " + Login.id + "  password6===== " + Login.pwd);
				return false;
			}
		}
	}
}
