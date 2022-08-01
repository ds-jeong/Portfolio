package tip;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import exchange.GoodVO;
import item.PointhVO;
import member.MemberVO;

@Repository
public class TipDAO implements TipService {
	
	@Autowired @Qualifier("allonelife") private SqlSession sql;

	@Override
	public void tip_pointm_update(MemberVO vo) {
		sql.update("tip.mapper.point_item_update", vo);		
	}
	
	@Override
	public void tip_pointm_insert(PointhVO pvo) {
		sql.insert("tip.mapper.item_insert", pvo);
	}
	@Override
	public void tip_point_update(MemberVO vo) {
		sql.update("tip.mapper.point_itemone_update", vo);		
	}
	
	@Override
	public void tip_point_insert(PointhVO pvo) {
		sql.insert("tip.mapper.itemone_insert", pvo);
	}
	
	@Override
	public void tip_good_update(TipVO vo) {
		sql.update("tip.mapper.good_update", vo);
	}
	@Override
	public boolean tip_good_select(GoodVO vog) {
		return (Integer) sql.selectOne("tip.mapper.select_good", vog) == 1 ? false : true;
	}
	@Override
	public void tip_good_insert(GoodVO vog) {
		sql.insert("tip.mapper.good_insert", vog);
	}
	
	@Override
	public void tip_insert(TipVO vo) {
		sql.insert("tip.mapper.insert", vo);
	}

	@Override
	public TipPageVO tip_list(TipPageVO page) {
		page.setTotalList(
			(Integer)sql.selectOne(
					"tip.mapper.totalCount", page) );
		List<TipVO> list 
			= sql.selectList("tip.mapper.list", page);
		page.setList(list);
		return page;
	}

	@Override
	public TipVO tip_detail(int id) {
		return sql.selectOne("tip.mapper.detail", id);
	}

	@Override
	public void tip_read(int id) {
		sql.update("tip.mapper.read", id);
	}

	@Override
	public void tip_update(TipVO vo) {
		sql.update("tip.mapper.update", vo);
	}

	@Override
	public void tip_delete(int id) {
		sql.delete("tip.mapper.delete", id);
	}
	
	@Override
	public boolean tip_comment_insert(HashMap<String, Object> map) {
		return sql.insert("tip.mapper.comment_insert", map) > 0 ? true : false;
	}

	@Override
	public List<TipCommentVO> tip_comment_list(int pid) {
		return sql.selectList("tip.mapper.comment_list", pid);
	}

	@Override
	public boolean tip_comment_delete(int id) {
		return sql.delete("tip.mapper.comment_delete", id)>0 ? true : false;
	}

	@Override
	public boolean tip_comment_update(TipCommentVO vo) {
		return sql.update("tip.mapper.comment_update", vo)>0 ? true : false;
	}

	@Override
	public void tip_root_step_update(TipVO vo) {
		sql.update("tip.mapper.root_step_update", vo);
	}

	@Override
	public void tip_stepdown_update(TipVO vo) {
		sql.update("tip.mapper.stepdown_update", vo);
	}

}

	