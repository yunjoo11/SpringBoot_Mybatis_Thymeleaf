package com.joo.s1.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joo.s1.util.Pager;
@Mapper
public interface BoardMapper {

	//List
	public List<BoardVO> getList(Pager pager)throws Exception;
	//count
	public Long getTotalCount(Pager pager)throws Exception;
	//select
	public BoardVO getSelect(BoardVO boardVO)throws Exception;
	//Insert
	public int setInsert(BoardVO boardVO)throws Exception;
	//FileInsert
	public int setFileInsert(BoardFileVO boardFileVO)throws Exception;
	//Update
	public int setUpdate(BoardVO boardVO)throws Exception;
	//HitUpdate
	public int setHitUpdate(BoardVO boardVO)throws Exception;
	//Delete
	public int setDelete(BoardVO boardVO)throws Exception;
	
	
	
	
}
