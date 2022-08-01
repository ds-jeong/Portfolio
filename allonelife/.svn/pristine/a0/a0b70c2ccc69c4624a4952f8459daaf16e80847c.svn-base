package tip;

import java.util.HashMap;
import java.util.List;

import exchange.GoodVO;
import item.PointhVO;
import member.MemberVO;


public interface TipService {
	//CRUD
	void tip_insert(TipVO vo);
	TipPageVO tip_list(TipPageVO page);
	TipVO tip_detail(int id);
	void tip_read(int id);
	void tip_update(TipVO vo);
	void tip_delete(int id);
	
	boolean tip_comment_insert(HashMap<String, Object> map);
	
	List<TipCommentVO> tip_comment_list(int pid);
	boolean tip_comment_delete(int id);
	boolean tip_comment_update(TipCommentVO vo);
	
	void tip_good_insert(GoodVO vog);
	void tip_good_update(TipVO vo);
	boolean tip_good_select(GoodVO vog);
	
	void tip_root_step_update(TipVO vo);
	void tip_stepdown_update(TipVO vo);
	
	void tip_point_update(MemberVO vo);
	void tip_point_insert(PointhVO pvo);
	void tip_pointm_update(MemberVO vo);
	void tip_pointm_insert(PointhVO pvo);
	
}
