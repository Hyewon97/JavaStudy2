import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
 자바에서 excel로 쓰고읽기
 1. jakarta.apache.org에서 POI를 다운로드 받는다.
 
 2. poi-5.0.0.jar, commons-math3-3.6.1.jar를 라이브러리를 buildpath 추가(프로젝트에서 마우스오른쪽 build path 선택)
 
 */
public class WriteExcel {

	public WriteExcel() {
		// 엑셀로 쓰기
		
		//1. workbook객체 생성
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		//2. sheet 객체 생성
		HSSFSheet sheet1 = workbook.createSheet("회원목록");
		HSSFSheet sheet2 = workbook.createSheet();
		
		//3. row객체 생성
		HSSFRow row1 = sheet1.createRow(0);
		
		//4. cell객체 생성
		HSSFCell cell1 = row1.createCell(0);
		
		//5. Value 셋팅
		cell1.setCellValue("번호");
		
		row1.createCell(1).setCellValue("이름");
		row1.createCell(2).setCellValue("연락처");
		row1.createCell(3).setCellValue("이메일");
		
		
		//////////////////////////////////////////////////////////
		String data[][] = {
				{"1","홍길동","010-1111-2222", "aaaaa@navte.com"},
				{"2","김길동","010-1234-3212", "bbb@navte.com"},
				{"3","이길동","010-1333-2323", "cccc@navte.com"},
				{"4","영길동","010-4444-3333", "ddddd@navte.com"},
				{"5","수길동","010-5555-6666", "eeee@navte.com"},
				{"6","월길동","010-7777-8888", "gggg@navte.com"},
				{"7","화길동","010-9999-0000", "ffff@navte.com"},
				{"8","목길동","010-1213-2344", "aaaeq@navte.com"},
		};
		for(int r=0; r<data.length; r++) {
			HSSFRow cRow = sheet1.createRow(r+1);
			for(int c=0; c<data[r].length; c++) {
				if(c==0) {
					//번호를 숫자로 변경하여 저장
					cRow.createCell(c).setCellValue(Integer.parseInt(data[r][c]));
				}else {
					cRow.createCell(c).setCellValue(data[r][c]);
				}
			}
		}
		//파일에쓰기
		File f = new File("C://tool/io/member.cell"); //xls, cell먹는데 xlsx는 안먹음
		
		try {
			//파일로 쓰기
			FileOutputStream fos = new FileOutputStream(f);
			workbook.write(fos);
			workbook.close();
		}catch(IOException ie) {
			ie.printStackTrace();
		}
		System.out.println("엑셀로 쓰기 완료...");
	}

	public static void main(String[] args) {
		new WriteExcel();
	}
}






















