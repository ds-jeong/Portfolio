package freeboard;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exchange.GoodVO;


@Service
public class FreeBoardServiceImpl implements FreeBoardService {
	@Autowired private FreeBoardDAO dao;


	@Override
	public void board_insert(FreeBoardVO vo) {
		dao.board_insert(vo);
	}

	@Override
	public FreeBoardPageVO board_list(FreeBoardPageVO page) {
		return dao.board_list(page);
	}

	@Override
	public FreeBoardVO board_detail(int id) {
		return dao.board_detail(id);
	}

	@Override
	public void board_read(int id) {
		dao.board_read(id);
	}

	@Override
	public void board_update(FreeBoardVO vo) {
		dao.board_update(vo);
	}

	@Override
	public void board_delete(int id) {
		dao.board_delete(id);
	}
	@Override
	public boolean freeboard_comment_delete(int id) {
		return dao.freeboard_comment_delete(id);
	}
	@Override
	public boolean freeboard_comment_insert(HashMap<String, Object> map) {
		return dao.freeboard_comment_insert(map);
	}
	@Override
	public List<FreeBoardCommentVO> freeboard_comment_list(int pid) {
		return dao.freeboard_comment_list(pid);
	}
	@Override
	public boolean freeboard_comment_update(FreeBoardCommentVO vo) {
		return dao.freeboard_comment_update(vo);
	}

	@Override
	public void board_good_insert(GoodVO vog) {
		dao.board_good_insert(vog);
	}

	@Override
	public void board_good_update(FreeBoardVO vo) {
		dao.board_good_update(vo);
	}

	@Override
	public boolean board_good_select(GoodVO vog) {
		return dao.board_good_select(vog);
	}

	@Override
	public void board_root_step_update(FreeBoardVO vo) {
		dao.board_root_step_update(vo);
	}

	@Override
	public void board_stepdown_update(FreeBoardVO vo) {
		dao.board_stepdown_update(vo);
	}
	
	
}
