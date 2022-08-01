package tip;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exchange.GoodVO;
import item.PointhVO;
import member.MemberVO;
@Service
public class TipServiceImpl implements TipService {
	@Autowired private TipDAO dao;

	@Override
	public void tip_pointm_insert(PointhVO pvo) {
		dao.tip_pointm_insert(pvo);
	}
	@Override
	public void tip_pointm_update(MemberVO vo) {
		dao.tip_pointm_update(vo);
	}
	@Override
	public void tip_point_insert(PointhVO pvo) {
		dao.tip_point_insert(pvo);
	}
	@Override
	public void tip_point_update(MemberVO vo) {
		dao.tip_point_update(vo);
	}
	
	
	@Override
	public void tip_good_update(TipVO vo) {
		dao.tip_good_update(vo);
	}
	
	@Override
	public boolean tip_good_select(GoodVO vog) {
		return dao.tip_good_select(vog);
	}
	
	@Override
	public void tip_good_insert(GoodVO vog) {
		dao.tip_good_insert(vog);
	}
	
	@Override
	public void tip_insert(TipVO vo) {
		dao.tip_insert(vo);
	}

	@Override
	public TipPageVO tip_list(TipPageVO page) {
		return dao.tip_list(page);
	}

	@Override
	public TipVO tip_detail(int id) {
		return dao.tip_detail(id);
	}

	@Override
	public void tip_read(int id) {
		dao.tip_read(id);
	}

	@Override
	public void tip_update(TipVO vo) {
		dao.tip_update(vo);
	}

	@Override
	public void tip_delete(int id) {
		dao.tip_delete(id);
	}

	@Override
	public boolean tip_comment_insert(HashMap<String, Object> map) {
		return dao.tip_comment_insert(map);
	}

	@Override
	public List<TipCommentVO> tip_comment_list(int pid) {
		return dao.tip_comment_list(pid);
	}

	@Override
	public boolean tip_comment_delete(int id) {
		return dao.tip_comment_delete(id);
	}

	@Override
	public boolean tip_comment_update(TipCommentVO vo) {
		return dao.tip_comment_update(vo);
	}
	@Override
	public void tip_root_step_update(TipVO vo) {
		dao.tip_root_step_update(vo);
	}
	@Override
	public void tip_stepdown_update(TipVO vo) {
		dao.tip_stepdown_update(vo);
	}	

}

