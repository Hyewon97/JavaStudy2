package emp;

import java.util.HashMap;

public class EmpDataSet {

	public static HashMap<String, EmpVO> empList = new HashMap<String, EmpVO>();
	public EmpDataSet() {
		
	}
	public static void setEmpList() {
		empList.put("홍길동", new EmpVO(1, "홍길동", "02-1234-5678", "총무부", "과장"));
		empList.put("강감찬", new EmpVO(2, "강감찬", "02-2332-4444", "기획부", "대표"));
		empList.put("유승룡", new EmpVO(3, "유승룡", "02-3333-1111", "행정부", "사원"));
		empList.put("이순신", new EmpVO(4, "이순신", "02-5555-4444", "사법부", "부장"));
		empList.put("장영실", new EmpVO(5, "장영실", "02-8764-3221", "인사부", "인턴"));
	}

}
