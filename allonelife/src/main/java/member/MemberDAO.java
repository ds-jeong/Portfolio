package member;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import item.PointhVO;

@Repository
public class MemberDAO implements MemberService {
	
	@Override
	public void user_info_delete(String userid) {
		sql.delete("member.mapper.user_info_delete", userid);
	}
	
	@Override
	public void userpwd_update(MemberVO vo) {
		sql.update("member.mapper.userpwd_update", vo);		
		
	}
	
	@Override
	public void nick_update(MemberVO vo) {
		sql.update("member.mapper.nick_update", vo);		
	}
	
	@Override
	public boolean email_usable(String email) {
		return (Integer) sql.selectOne("member.mapper.check_email", email) == 1 ? false : true;
	}

	@Override
	public boolean nickname_usable(String nickname) {
		return (Integer) sql.selectOne("member.mapper.nickname", nickname) == 1 ? false : true;
	}

	@Override
	public boolean member_insert(MemberVO vo) {
		return sql.insert("member.mapper.join", vo) > 0 ? true : false;
	}

	@Override
	public MemberVO member_select(String userid) {
		return null;
	}

	@Override
	public MemberVO member_login(String userid, String userpwd) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("userpwd", userpwd);
		return sql.selectOne("member.mapper.login", map);
	}

	@Autowired
	@Qualifier("allonelife")
	private SqlSession sql;

	@Override
	public boolean userid_usable(String userid) {
		return (Integer) sql.selectOne("member.mapper.usable", userid) == 1 ? false : true;
	}

	@Override
	public boolean member_update(MemberVO vo) {
		return false;
	}

	@Override
	public boolean member_delete() {
		return false;
	}

	@Override
	public PointhPageVO mypage_point_list(PointhPageVO page) {
		page.setTotalList(
			(Integer)sql.selectOne(
					"member.mapper.totalCount", page) );
		List<PointhVO> list 
			= sql.selectList("member.mapper.list", page);
		page.setList(list);
		
		return page;
	}

	@Override
	public MyWritePageVO mypage_write_list(MyWritePageVO mypage) {
		mypage.setTotalList(
			(Integer)sql.selectOne(
					"member.mapper.totalMyCount", mypage) );
		List<MyWriteVO> list 
			= sql.selectList("member.mapper.myList", mypage);
		mypage.setList(list);
		
		return mypage;
	}

	@Override
	public void member_join_point_insert(PointhVO pvo) {
		sql.insert("member.mapper.join_point_insert", pvo);
	}

	@Override
	public List<MemberVO> mypage_member_list(MemberVO vo) {
		return sql.selectList("member.mapper.mypagememberlist", vo);
	}

}
