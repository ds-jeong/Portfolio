package freeboard;

import java.util.HashMap;
import java.util.List;

import exchange.GoodVO;

public interface FreeBoardService {
	//CRUD
	
	void board_insert(FreeBoardVO vo);
	FreeBoardPageVO board_list(FreeBoardPageVO page);
	FreeBoardVO board_detail(int id);
	void board_read(int id);
	void board_update(FreeBoardVO vo);
	void board_delete(int id);
	
	boolean freeboard_comment_insert(HashMap<String, Object> map);
	
	List<FreeBoardCommentVO> freeboard_comment_list(int pid);
	boolean freeboard_comment_delete(int id);
	boolean freeboard_comment_update(FreeBoardCommentVO vo);
	
	void board_good_insert(GoodVO vog);
	void board_good_update(FreeBoardVO vo);
	boolean board_good_select(GoodVO vog);

	void board_root_step_update(FreeBoardVO vo);
	void board_stepdown_update(FreeBoardVO vo);
	
}
