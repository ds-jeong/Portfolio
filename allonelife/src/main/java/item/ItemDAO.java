package item;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import member.MemberVO;

@Repository
public class ItemDAO implements ItemService {
	@Autowired @Qualifier("allonelife") private SqlSession sql;


	
	@Override	
	public void member_point_item4_update(MemberVO vo) {
	sql.update("item.mapper.point_item4_update", vo);
		
	}@Override
	public void member_point_item5_update(MemberVO vo) {
		sql.update("item.mapper.point_item5_update", vo);
		
	}@Override
	public void member_point_item6_update(MemberVO vo) {
		sql.update("item.mapper.point_item6_update", vo);
		
	}@Override
	public void pointh_item4_insert(PointhVO pvo) {
		sql.insert("item.mapper.item4_insert", pvo);
		
	}@Override
	public void pointh_item5_insert(PointhVO pvo) {
		sql.insert("item.mapper.item5_insert", pvo);
		
	}	
	@Override
	public void pointh_item6_insert(PointhVO pvo) {
		sql.insert("item.mapper.item6_insert", pvo);
		
	}
	
	@Override
	public boolean send_item(int id) {
		return sql.update("item.mapper.send_item", id) == 1 ?  true : false ;		
	}
	
	
	@Override
	public ItemPageVO item_list(ItemPageVO page) {
		page.setTotalList((Integer)sql.selectOne("item.mapper.totalCount", page));
		List<PointhVO> list =sql.selectList("item.mapper.list", page);
		page.setList(list);
		return page;
	}
	@Override
	public void member_point_itemone_update(MemberVO vo) {
		sql.update("item.mapper.point_itemone_update", vo);
	}

	@Override
	public void pointh_itemone_insert(PointhVO pvo) {
		sql.insert("item.mapper.itemone_insert", pvo);
	}

	@Override
	public void member_point_itemtwo_update(MemberVO vo) {
		sql.update("item.mapper.point_itemtwo_update", vo);
	}

	@Override
	public void pointh_itemtwo_insert(PointhVO pvo) {
		sql.insert("item.mapper.itemtwo_insert", pvo);
	}

	@Override
	public void member_point_itemthree_update(MemberVO vo) {
		sql.update("item.mapper.point_itemthree_update", vo);
	}

	@Override
	public void pointh_itemthree_insert(PointhVO pvo) {
		sql.insert("item.mapper.itemthree_insert", pvo);
	}
	@Override
	public List<MemberVO> member_list(MemberVO vo) {
		return sql.selectList("item.mapper.memberlist", vo);
	}
	
	@Override
	public  String select_email(String userid) {
		return sql.selectOne("item.mapper.select_email",userid);
	}
	@Override
	public  String select_name(String userid) {
		return sql.selectOne("item.mapper.select_name",userid);
	}
	@Override
	public String select_userid(int id) {
		return sql.selectOne("item.mapper.select_userid", id);
	}
	@Override
	public Integer select_itemid(int id) {
		return sql.selectOne("item.mapper.select_itemid", id);
	}
	
}
