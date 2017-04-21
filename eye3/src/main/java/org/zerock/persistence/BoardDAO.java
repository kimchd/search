package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardDAO {

	public String getTime();
	
	public void create(BoardVO vo);
	
	public List<BoardVO> read(int bno);
	
	public void update(BoardVO vo);
	
	public void delete(int bno);
	
	public List<BoardVO> list(Criteria cri);
	
	public int getTotal();
	
}
