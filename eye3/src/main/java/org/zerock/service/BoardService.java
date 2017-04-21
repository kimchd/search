package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {

	public void register(BoardVO vo)throws Exception;
	
	public List<BoardVO> findByBno(int bno) throws Exception;
	
	public void modify(BoardVO vo) throws Exception;
	
	public void remove(int bno) throws Exception;
	
	public List<BoardVO> getList(Criteria cri) throws Exception;
	
	public int getTotal() throws Exception;
}
