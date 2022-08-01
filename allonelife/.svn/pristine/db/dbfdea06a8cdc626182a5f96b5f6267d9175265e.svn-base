package exchange;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import item.PointhVO;
import member.MemberVO;

@Repository
public class ExchangeDAO implements ExchangeService {
	
	@Autowired @Qualifier("allonelife") private SqlSession sql;

	@Override
	public void exchange_pointm_update(MemberVO vo) {
		sql.update("exchange.mapper.point_item_update", vo);
	}
	
	@Override
	public void exchange_pointm_insert(PointhVO pvo) {
		sql.insert("exchange.mapper.item_insert", pvo);
	}
	@Override
	public void exchange_point_update(MemberVO vo) {
		sql.update("exchange.mapper.point_itemone_update", vo);
	}
	
	@Override
	public void exchange_point_insert(PointhVO pvo) {
		sql.insert("exchange.mapper.itemone_insert", pvo);
	}
	
	@Override
	public boolean exchange_good_select(GoodVO vog) {
		return (Integer) sql.selectOne("exchange.mapper.select_good", vog) == 1 ? false : true;
	}
	
	@Override
	public void exchange_insert(ExchangeVO vo) {
		sql.insert("exchange.mapper.insert", vo);
	}

	@Override
	public ExchangePageVO exchange_list(ExchangePageVO page) {
		page.setTotalList(
			(Integer)sql.selectOne(
					"exchange.mapper.totalCount", page) );
		List<ExchangeVO> list 
			= sql.selectList("exchange.mapper.list", page);
		page.setList(list);
		return page;
	}

	@Override
	public ExchangeVO exchange_detail(int id) {
		return sql.selectOne("exchange.mapper.detail", id);
	}

	@Override
	public void exchange_read(int id) {
		sql.update("exchange.mapper.read", id);
	}

	@Override
	public void exchange_update(ExchangeVO vo) {
		sql.update("exchange.mapper.update", vo);
	}

	@Override
	public void exchange_delete(int id) {
		sql.delete("exchange.mapper.delete", id);
	}

	@Override
	public boolean exchange_comment_insert(HashMap<String, Object> map) {
		return sql.insert("exchange.mapper.comment_insert", map) > 0 ? true : false;
	}

	@Override
	public List<ExchangeCommentVO> exchange_comment_list(int pid) {
		return sql.selectList("exchange.mapper.comment_list", pid);
	}

	@Override
	public boolean exchange_comment_delete(int id) {
		return sql.delete("exchange.mapper.comment_delete", id)>0 ? true : false;
	}

	@Override
	public boolean exchange_comment_update(ExchangeCommentVO vo) {
		return sql.update("exchange.mapper.comment_update", vo)>0 ? true : false;
	}

	@Override
	public void exchange_good_insert(GoodVO vog) {
		sql.insert("exchange.mapper.good_insert", vog);
	}

	@Override
	public void exchange_good_update(ExchangeVO vo) {
		sql.update("exchange.mapper.good_update", vo);
		
	}

	@Override
	public void exchange_root_step_update(ExchangeVO vo) {
		sql.update("exchange.mapper.root_step_update", vo);
	}

	@Override
	public void exchange_stepdown_update(ExchangeVO vo) {
		sql.update("exchange.mapper.stepdown_update", vo);
	}
}
