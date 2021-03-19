package com.bitcamp.board;

import java.util.ArrayList;
import java.util.List;

import com.bitcamp.library.DBConnection;

public class BoardDAO extends DBConnection{
	//게시판 글등록
	public int insertBoard(BoardVO vo) {
		int result = 0;
		try {
			connection();
			sql = "insert into board(no, subject, content, userid, hit, writedate, ip) "
					+ "values(boardsq.nextval, ?, ?, ?, 0, sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getUserid());
			pstmt.setString(4, vo.getIp());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("게시판 글등록 에러  --> " + e.getMessage());
		}finally {
			closeDB();
		}
		return result;
	}
	
	//총 레코드 수
	public int totalRecord(String searchKey, String searchWord) {
		int totalRecode=0;
		try {
			connection();
			
		     String sql = "select count(no) from board";
	         
	         //검색어가 있을때
	         if(searchWord!=null && !searchWord.equals("")) {
	            //subject like '%검색어%';
	            sql += " where "+searchKey+" like ?";         
	         }
	         pstmt = conn.prepareStatement(sql);
	         if(searchWord!=null && !searchWord.equals("")) {
	            pstmt.setString(1, "%"+searchWord+"%");
	         }
	         
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	        	 totalRecode = rs.getInt(1);
	         }
			
		}catch(Exception e){
			System.out.println("총 레코드 수 구하기 에러발생...-> " + e.getMessage());
		}finally {
			closeDB();
		}
		return totalRecode;
	}
	
	//레코드 선택      					현제페이지		한번 레코드수			총레코드수			총페이지			검색주제				검색명
	public List<BoardVO> selectRecord(int nowNum, int onePageRecode, int totalRecord, int totalPage, String searchKey, String searchWord){
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			connection();
			String sql = "select * from (select * from (select no, subject, userid, hit,"
		               + " to_char(writedate, 'yy-mm-dd hh:mi') from board";
		               // 검색어가 있을 때
		               if (searchWord != null && !searchWord.equals("")) {
		                  sql += " where " +searchKey+ " like ? ";
		               }
		               sql += " order by no desc)"
		               + " where rownum<=? order by no asc) where rownum<=? order by no desc";
			pstmt = conn.prepareStatement(sql);
			//마지막 페이지일때 선택 레코드 수 정하기
			int lastPageRecord = totalRecord%onePageRecode; //0,1,2,3,4
			
			//검색어가 있을때
			if(searchWord!=null && !searchWord.equals("")) {
				pstmt.setString(1, "%"+searchWord+"%");
				pstmt.setInt(2, nowNum*onePageRecode);
				if(nowNum==totalPage && lastPageRecord !=0) {
					pstmt.setInt(3, lastPageRecord);
				}else {
					pstmt.setInt(3, onePageRecode);
				}
			}else { //검색어가없을때
				pstmt.setInt(1, nowNum*onePageRecode);
				if(nowNum==totalPage && lastPageRecord !=0) {
					pstmt.setInt(2, lastPageRecord);
				}else {
					pstmt.setInt(2, onePageRecode);
				}
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setUserid(rs.getString(3));
				vo.setHit(rs.getInt(4));
				vo.setWritedate(rs.getString(5));
				boardList.add(vo);
			}
			
		}catch(Exception e) {
			System.out.println("게시판 레코드 선택에러.. -> " + e.getMessage());
		}finally {
			closeDB();
		}
		return boardList;
	}
	
	//레코드 1개 선택, 조회수 증가
	public BoardVO getOneSelect(int no) {
		BoardVO vo = new BoardVO();
		try {
			//조회수 증가
			hitCount(no);
			//레코드 선택
			connection();
			sql= " select no, subject, content, userid, hit, writedate from board "
					+" where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setUserid(rs.getString(4));
				vo.setHit(rs.getInt(5));
				vo.setWritedate(rs.getString(6));
			}
		} catch (Exception e) {
			System.out.println("레코드 선택 에러-->" + e.getMessage());
		}finally {
			closeDB();
		}
		return vo;
	}
	//조회수 증가
	public void hitCount(int no) {
		try {
			connection();
			sql = "update board set hit = hit + 1 where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("조회수 증가 에러 발생 -->" +e.getMessage());
		}finally {
			closeDB();
		}
	}
}


