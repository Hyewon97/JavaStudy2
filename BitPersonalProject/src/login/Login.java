package login;

import java.util.HashMap;

import member.MemberDataSet;
import member.MemberVO;

public class Login {
	
	public static String id;
	public static String pwd;
	public static int num;
	
	
	//관리자, 일반회원 두개로 구분할것
	public static boolean login() {
		//데이터주입
		MemberDataSet.setMemberList();
		HashMap<String, MemberVO> vo = MemberDataSet.MemberList;
		if (id == "" || pwd == "") {
			System.out.println("아이디와 비밀번호를 입력후 로그인하세요.");
			return false;
		} else {
			if(id.equals("master") && pwd.equals("1234") && num == 1) {
				return true;
			}else if(id.equals("123") && pwd.equals("123") && num == 2){
				return true;
			}else {
				return false;
			}
		}
	}
}
