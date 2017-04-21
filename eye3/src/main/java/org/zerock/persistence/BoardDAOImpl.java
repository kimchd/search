package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private static final String namespace = "org.zerock.persistence.BoardDAO";
	
	@Inject
	SqlSession session;
	
	@Override
	public String getTime() {
		return session.selectOne(namespace+".getTime");
	}

	@Override
	public void create(BoardVO vo) {
		session.insert(namespace+".create", vo);
	}

	@Override
	public List<BoardVO> read(int bno) {
		return session.selectList(namespace+".read",bno);
	}

	@Override
	public void update(BoardVO vo) {
		session.update(namespace+".update",vo);
	}

	@Override
	public void delete(int bno) {
		session.delete(namespace+".delete",bno);
	}

	@Override
	public List<BoardVO> list(Criteria cri) {
		return session.selectList(namespace+".list",cri);
	}

	@Override
	public int getTotal() {
		return session.selectOne(namespace + ".getTotal");
	}


}
