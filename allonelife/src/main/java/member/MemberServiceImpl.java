package member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import item.PointhVO;

//@Service @Qualifier("member.service")
@Service("member.service")
public class MemberServiceImpl implements MemberService {

	
	@Override
	public void user_info_delete(String userid) {
		dao.user_info_delete(userid);
	}
	
	@Override
	public void userpwd_update(MemberVO vo) {
		dao.userpwd_update(vo);
		
	}
	
	@Override
	public void nick_update(MemberVO vo) {
		dao.nick_update(vo);
	}

	@Override
	public boolean email_usable(String email) {
		return dao.email_usable(email);
	}

	@Override
	public boolean nickname_usable(String nickname) {
		return dao.nickname_usable(nickname);
	}

	@Override
	public boolean member_insert(MemberVO vo) {
		return dao.member_insert(vo);
	}

	@Override
	public MemberVO member_select(String userid) {
		return null;
	}

	@Override
	public MemberVO member_login(String userid, String userpwd) {
		return dao.member_login(userid, userpwd);
	}

	@Autowired
	private MemberDAO dao;

	@Override
	public boolean userid_usable(String userid) {
		return dao.userid_usable(userid);
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
		return dao.mypage_point_list(page);
	}

	@Override
	public MyWritePageVO mypage_write_list(MyWritePageVO mypage) {
		return dao.mypage_write_list(mypage);
	}

	@Override
	public void member_join_point_insert(PointhVO pvo) {
		dao.member_join_point_insert(pvo);
	}

	@Override
	public List<MemberVO> mypage_member_list(MemberVO vo) {
		return dao.mypage_member_list(vo);
	}

}
