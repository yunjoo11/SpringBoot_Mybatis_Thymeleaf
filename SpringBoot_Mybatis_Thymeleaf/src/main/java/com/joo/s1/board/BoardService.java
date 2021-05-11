package com.joo.s1.board;

import java.util.List;

public interface BoardService {

		//List
		public List<BoardVO> getList()throws Exception;
		
		//select
		public BoardVO getSelect(BoardVO boardVO)throws Exception;
		
		//Insert
		public int setInsert(BoardVO boardVO)throws Exception;
		
		//Update
		public int setUpdate(BoardVO boardVO)throws Exception;
		
		//Delete
		public int setDelete(BoardVO boardVO)throws Exception;
		
	
}
