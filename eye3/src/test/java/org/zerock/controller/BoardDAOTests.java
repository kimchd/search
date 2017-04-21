package org.zerock.controller;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class BoardDAOTests {

	private static Logger logger = Logger.getLogger(BoardDAOTests.class);

	@Inject
	DataSource ds;

	@Inject
	BoardDAO dao;
	
	@Test
	public void getTotalTest(){
		dao.getTotal();
	}

	@Test
	public void createTest() {
		BoardVO vo = new BoardVO();
		vo.setTitle("새제목");
		vo.setContent("새 내용");
		vo.setWriter("새 작성자");
		dao.create(vo);
	}

	@Test
	public void test() {
		logger.info(dao);
		logger.info(dao.getTime());
	}

	@Test
	public void ConnectionTest() {

		logger.info(ds);

		try (Connection con = ds.getConnection()) {
			logger.info(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
