package com.joo.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.joo.s1.board.BoardService;
import com.joo.s1.board.BoardVO;
import com.joo.s1.util.FileManager;
import com.joo.s1.util.Pager;

@Service
public class NoticeService implements BoardService{
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private FileManager fileManager;

	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		Long totalCount=noticeMapper.getTotalCount(pager);
		pager.makeNum(totalCount);
		return noticeMapper.getList(pager);
	}

	@Override
	public BoardVO getSelect(BoardVO boardVO) throws Exception {
		noticeMapper.setHitUpdate(boardVO);
		return noticeMapper.getSelect(boardVO);
	}

	@Override
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {
		String filePath="upload/notice/";
		
		fileManager.save(null, filePath);
		
		
		
		return 0; //noticeMapper.setInsert(boardVO);
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		
		return noticeMapper.setUpdate(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		
		return noticeMapper.setDelete(boardVO);
	}
	
	
}
