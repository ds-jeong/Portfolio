package exchange;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import item.PointhVO;
import member.MemberVO;

@Service
public class ExchangeServiceImpl implements ExchangeService {
	@Autowired private ExchangeDAO dao;
		
	@Override
	public void exchange_pointm_update(MemberVO vo) {
		dao.exchange_pointm_update(vo);
	}
	
	@Override
	public void exchange_pointm_insert(PointhVO pvo) {
		dao.exchange_pointm_insert(pvo);
	}
	@Override
	public void exchange_point_update(MemberVO vo) {
		dao.exchange_point_update(vo);
	}
	
	@Override
	public void exchange_point_insert(PointhVO pvo) {
		dao.exchange_point_insert(pvo);
	}
	
	@Override
	public boolean exchange_good_select(GoodVO vog) {
		return dao.exchange_good_select(vog);
	}
	
	@Override
	public void exchange_insert(ExchangeVO vo) {
		dao.exchange_insert(vo);
	}

	@Override
	public ExchangePageVO exchange_list(ExchangePageVO page) {
		return dao.exchange_list(page);
	}

	@Override
	public ExchangeVO exchange_detail(int id) {
		return dao.exchange_detail(id);
	}

	@Override
	public void exchange_read(int id) {
		dao.exchange_read(id);
	}

	@Override
	public void exchange_update(ExchangeVO vo) {
		dao.exchange_update(vo);
	}

	@Override
	public void exchange_delete(int id) {
		dao.exchange_delete(id);
	}

	@Override
	public boolean exchange_comment_insert(HashMap<String, Object> map) {
		return dao.exchange_comment_insert(map);
	}

	@Override
	public List<ExchangeCommentVO> exchange_comment_list(int pid) {
		return dao.exchange_comment_list(pid);
	}

	@Override
	public boolean exchange_comment_delete(int id) {
		return dao.exchange_comment_delete(id);
	}

	@Override
	public boolean exchange_comment_update(ExchangeCommentVO vo) {
		return dao.exchange_comment_update(vo);
	}

	@Override
	public void exchange_good_insert(GoodVO vog) {
		dao.exchange_good_insert(vog);
	}

	@Override
	public void exchange_good_update(ExchangeVO vo) {
		dao.exchange_good_update(vo);
	}

	@Override
	public void exchange_root_step_update(ExchangeVO vo) {
		dao.exchange_root_step_update(vo);
	}

	@Override
	public void exchange_stepdown_update(ExchangeVO vo) {
		dao.exchange_stepdown_update(vo);
	}	

}
