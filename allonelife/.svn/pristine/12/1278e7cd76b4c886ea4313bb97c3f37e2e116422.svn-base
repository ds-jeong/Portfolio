package exchange;

import java.util.HashMap;
import java.util.List;

import item.PointhVO;
import member.MemberVO;

public interface ExchangeService {
	//CRUD
		void exchange_insert(ExchangeVO vo);
		ExchangePageVO exchange_list(ExchangePageVO page);
		ExchangeVO exchange_detail(int id);
		void exchange_read(int id);
		void exchange_update(ExchangeVO vo);
		void exchange_delete(int id);
		
		boolean exchange_comment_insert(HashMap<String, Object> map);
		
		List<ExchangeCommentVO> exchange_comment_list(int pid);
		boolean exchange_comment_delete(int id);
		boolean exchange_comment_update(ExchangeCommentVO vo);
		
		void exchange_good_insert(GoodVO vog);
		void exchange_good_update(ExchangeVO vo);
		boolean exchange_good_select(GoodVO vog);
		
		void exchange_root_step_update(ExchangeVO vo);
		void exchange_stepdown_update(ExchangeVO vo);
		
		void exchange_point_update(MemberVO vo);
		void exchange_point_insert(PointhVO pvo);
		void exchange_pointm_update(MemberVO vo);
		void exchange_pointm_insert(PointhVO pvo);
		
}
