package freeboard;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import exchange.GoodVO;


@Repository
public class FreeBoardDAO implements FreeBoardService {



	@Override
	public void board_insert(FreeBoardVO vo) {
		sql.insert("freeboard.mapper.insert", vo);
	}
	@Autowired @Qualifier("allonelife") private SqlSession sql;
	@Override
	public FreeBoardPageVO board_list(FreeBoardPageVO page) {
		
		page.setTotalList((Integer)sql.selectOne("freeboard.mapper.totalCount", page));
		List<FreeBoardVO> list =sql.selectList("freeboard.mapper.list", page);
		page.setList(list);
		return page;
	}

	@Override
	public FreeBoardVO board_detail(int id) {
		return sql.selectOne("freeboard.mapper.detail",id);
	}

	@Override
	public void board_read(int id) {
		sql.update("freeboard.mapper.read",id);

	}

	@Override
	public void board_update(FreeBoardVO vo) {
		sql.update("freeboard.mapper.update", vo);
	}

	@Override
	public void board_delete(int id) {
		sql.delete("freeboard.mapper.delete",id);
	}
	
	@Override
	public boolean freeboard_comment_delete(int id) {
		return sql.delete("freeboard.mapper.comment_delete", id) > 0 ? true : false;
	}
	@Override
	public boolean freeboard_comment_insert(HashMap<String, Object> map) {
		return sql.insert("freeboard.mapper.comment_insert", map) > 0 ? true : false;
	}
	@Override
	public List<FreeBoardCommentVO> freeboard_comment_list(int pid) {
		return sql.selectList("freeboard.mapper.comment_list", pid);
	}
	@Override
	public boolean freeboard_comment_update(FreeBoardCommentVO vo) {
		return sql.update("freeboard.mapper.comment_update", vo)> 0 ? true : false;
	}

	@Override
	public void board_good_insert(GoodVO vog) {
		sql.insert("freeboard.mapper.good_insert", vog);
	}

	@Override
	public void board_good_update(FreeBoardVO vo) {
		sql.update("freeboard.mapper.good_update", vo);
	}

	@Override
	public boolean board_good_select(GoodVO vog) {
		return (Integer) sql.selectOne("freeboard.mapper.select_good", vog) == 1 ? false : true;
	}

	@Override
	public void board_root_step_update(FreeBoardVO vo) {
		sql.update("freeboard.mapper.root_step_update", vo);
	}

	@Override
	public void board_stepdown_update(FreeBoardVO vo) {
		sql.update("freeboard.mapper.stepdown_update", vo);
	}
}
