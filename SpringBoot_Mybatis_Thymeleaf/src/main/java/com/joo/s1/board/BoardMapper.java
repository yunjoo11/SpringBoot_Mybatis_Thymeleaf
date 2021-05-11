package com.joo.s1.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface BoardMapper {

	//List
	public List<BoardVO> getList()throws Exception;
	//count
	public Long getTotalCount()throws Exception;
	//select
	public BoardVO getSelect(BoardVO boardVO)throws Exception;
	//Insert
	public int setInsert(BoardVO boardVO)throws Exception;
	//Update
	public int setUpdate(BoardVO boardVO)throws Exception;
	//HitUpdate
	public int setHitUpdate(BoardVO boardVO)throws Exception;
	//Delete
	public int setDelete(BoardVO boardVO)throws Exception;
	
	
	
	
}
