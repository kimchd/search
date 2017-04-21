package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;

	@Override
	public void register(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoardVO> findByBno(int bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> getList(Criteria cri) throws Exception {
		return dao.list(cri);
	}

	@Override
	public int getTotal() throws Exception {
		return dao.getTotal();
	}

}
