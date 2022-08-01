package member;

import java.util.List;



public interface MemberService {
	//CRUD
	boolean member_insert(MemberVO vo);//ȸ������
	MemberVO member_select(String userid); //�� ���� ����
	MemberVO member_login(String userid, String userpwd);//�α���
	boolean userid_usable(String userid);//���̵� �ߺ�Ȯ��
	boolean member_update(MemberVO vo);//�� ���� ����
	boolean member_delete();//ȸ��Ż��
	boolean nickname_usable(String nickname);
	boolean email_usable(String email);
	void nick_update(MemberVO vo);
	void userpwd_update(MemberVO vo);
	void user_info_delete(String userid);
	
	MyWritePageVO mypage_write_list(MyWritePageVO mypage);
	
	
	
	List<MemberVO> mypage_member_list(MemberVO vo);
	}
