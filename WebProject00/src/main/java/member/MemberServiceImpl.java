package member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("member.service")
public class MemberServiceImpl implements MemberService {

	@Override
	public boolean member_insert(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.member_insert(vo);
	}

	@Override
	public MemberVO member_select(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO member_login(String userid, String userpwd) {
		// TODO Auto-generated method stub
		return dao.member_login(userid, userpwd);
	}
	@Autowired
	private MemberDAO dao;
	@Override
	public boolean userid_usable(String userid) {
		// TODO Auto-generated method stub
		return dao.userid_usable(userid);
	}

	@Override
	public boolean member_update(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean member_delete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean nickname_usable(String nickname) {
		// TODO Auto-generated method stub
		return dao.nickname_usable(nickname);
	}

	@Override
	public boolean email_usable(String email) {
		// TODO Auto-generated method stub
		return dao.email_usable(email);
	}

	@Override
	public void nick_update(MemberVO vo) {
		// TODO Auto-generated method stub
		dao.nick_update(vo);
	}

	@Override
	public void userpwd_update(MemberVO vo) {
		dao.userpwd_update(vo);

	}

	@Override
	public void user_info_delete(String userid) {
		// TODO Auto-generated method stub
		dao.user_info_delete(userid);
	}

	@Override
	public MyWritePageVO mypage_write_list(MyWritePageVO mypage) {
		// TODO Auto-generated method stub
		return dao.mypage_write_list(mypage);
	}

	@Override
	public List<MemberVO> mypage_member_list(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.mypage_member_list(vo);
	}

}
