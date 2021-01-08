import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import emp.EmpDataSet;
import emp.EmpVO;
import emp.Login;

public class EmpMain {
	Scanner scan = new Scanner(System.in);
	
	public EmpMain() {
		
	}
	
	public void start() {
		//아이디와 비밀번호를 입력받아 로그인 구현하기
		Login.id = conInput("아이디");
		Login.pwd = conInput("비밀번호");
		if (Login.LoginCheck()) { //로그인시
			EmpDataSet.setEmpList();
			
			do {
				String menu = conInput("메뉴[1. 사원전체목록, 2.사원등록, 3.사원수정, 4.사원삭제, 5.종료]");
				if(menu.equals("5")) {//종료
					break;
				}else if(menu.equals("1")){//사원전체목록
					//if문뒤에 전체목록을 뽑아주었기 때문에 코드생략
				}else if(menu.equals("2")) {//사원등록
					empInsert();
				}else if(menu.equals("3")) {//사원수정
					empEdit();
				}else if(menu.equals("4")) {//사원삭제
					empDel();
				}
				empOutput();
			}while(true);
			
		}else { //로그인 실패시 
			System.out.println("로그인이 실패하였습니다.");
		}
	}
	
	//사원전체목록 출력
	public void empOutput() {
		Set<String> keyList = EmpDataSet.empList.keySet();
		Iterator<String> ii = keyList.iterator();
		while(ii.hasNext()) {
			EmpVO vo = EmpDataSet.empList.get(ii.next());
			System.out.printf("%d\t%s\t%s\t%s\t%s\n", vo.getEmpNo(), vo.getEmpName(), vo.getTel(), vo.getDepart(), vo.getPosition());
		}
	}
	
	//사원등록
	public void empInsert() {
		int no = Integer.parseInt(conInput("사원번호")); //사원번호입력할때 이름넣으면 오류뜸
		String name = conInput("사원명");
		String tel = conInput("연락처");
		String depart = conInput("부서명");
		String position = conInput("직급");
		
		EmpDataSet.empList.put(name, new EmpVO(no, name, tel, depart ,position));
	}
	
	//사원수정
	public void empEdit() {
		//사원명
		String empName = conInput("수정할 사원명");
		
		//연락처, 부서명, 직급
		// 해당사원의 정보가 없을때
		EmpVO vo = EmpDataSet.empList.get(empName);
		if(vo==null) {
			System.out.println("존재하지 않는 사원명입니다.");
		}else {//해당 사원의 정보가 있을때
			//연락처 부서명 직급
			String subMenu = conInput("수정할 필드 선택[1.연락처, 2.부서명, 3.직급]");
			if(subMenu.equals("1")) {
				String tel = conInput("수정할 연락처");
				vo.setTel(tel);
			}else if(subMenu.equals("2")) {
				String depart = conInput("수정할 부서명");
				vo.setDepart(depart);
			}else if(subMenu.equals("3")) {
				String position = conInput("수정할 직급명");
				vo.setPosition(position);
			}
		}
	}
	
	//사원삭제
	public void empDel() {
		String empName = conInput("삭제할 사원명");
		EmpDataSet.empList.remove(empName);
	}
	//콘솔에서 문자입력받아 리턴하는 메소드
	public String conInput(String msg) {
		System.out.print(msg + "=");
		return scan.nextLine();
	}

	public static void main(String[] args) {
		new EmpMain().start();
		System.out.println("시스템이 종료되었습니다.");
	}

}
