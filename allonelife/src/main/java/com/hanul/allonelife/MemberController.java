package com.hanul.allonelife;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import common.CommonService;
import item.PointhVO;
import member.MemberService;
import member.MemberVO;
import member.MyWritePageVO;
import member.PointhPageVO;


@Controller
public class MemberController {
	
	@Autowired
	private PointhPageVO page;
	
	@Autowired
	private MyWritePageVO mypage;
	
//	@Autowired @Qualifier("member.service")
	@Resource(name = "member.service")
	private MemberService service;
	@Autowired private CommonService common;
	
	
	//마이페이지
	@RequestMapping("/mypage")
	public String mypage(HttpSession session) {
		return "member/mypage";
	}
	//로그아웃처리 요청
	@ResponseBody @RequestMapping("/logout")
	public void logout(HttpSession session) {
		session.removeAttribute("login_info");
	}
	
	//로그인처리 요청
	@ResponseBody @RequestMapping ("/login") 
	public boolean login(String userid, String userpwd, HttpSession session) {
		MemberVO vo = service.member_login(userid, userpwd);
		session.setAttribute("login_info", vo);
		return vo == null ? false : true;
	}
	
	// 회원가입처리 요청
	@ResponseBody
	@RequestMapping(value = "/join", produces = "text/html; charset=utf-8")
	public String join(MemberVO vo, PointhVO pvo, HttpSession ss, HttpServletRequest request) {
		StringBuffer msg = new StringBuffer("<script type='text/javascript'>");

		if (service.member_insert(vo)) {
			common.emailSend(vo.getName(), vo.getEmail(), request);
			msg.append("alert('얼라이프 회원가입 축하합니다. 500얼이 지급되었습니다.'); location='home'");
			pvo.setUserid(vo.getUserid());
			service.member_join_point_insert(pvo);
		} else {
//			msg.append("alert('회원가입 실패'); location='member'");
			msg.append("alert('회원가입 실패에 실패했습니다.'); history.go(-1)");
		}
		msg.append("</script>");

		return msg.toString();
	}

	// userid 중복확인
	@ResponseBody
	@RequestMapping("/id_usable")
	public String id_usable(String userid) {
		return String.valueOf(service.userid_usable(userid));
	}
	

	@ResponseBody
	@RequestMapping("/mail_usable")
	public String mail_usable(String email) {
		return String.valueOf(service.email_usable(email));
	}
	@ResponseBody
	@RequestMapping("/nick_usable")
	public String nickname_usable(String nickname) {
		System.out.println(String.valueOf(service.nickname_usable(nickname)));
		return String.valueOf(service.nickname_usable(nickname));
	}


	// 회원가입화면 요청
	@RequestMapping("/member")	
	public String member() {
		return "member/join";
	}
	
	@RequestMapping("/mypage_info")
	public String mypage_info(Model model, MemberVO vo, HttpSession ss) {
		
		if(ss.getAttribute("login_info") !=null) {

			vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
			model.addAttribute("list", service.mypage_member_list(vo));

		}
		
		return "member/mypage_info";
	}
	@RequestMapping("/mypage_delete")
	public String mypage_delete() {
		return "member/mypage_delete";
	}
	
	
	@RequestMapping("/mypage_point")
	public String mypage_point(MemberVO vo, HttpSession ss, Model model, @RequestParam(defaultValue = "1") int curPage) {
		page.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		page.setCurPage(curPage);
		
		model.addAttribute("page", service.mypage_point_list(page));
		return "member/mypage_point";
	}
	
	@RequestMapping("/mypage_write")
	public String mypage_write(MemberVO vo, HttpSession ss, Model model, @RequestParam(defaultValue = "1") int curPage) {
		mypage.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		mypage.setCurPage(curPage);
		
		model.addAttribute("mypage", service.mypage_write_list(mypage));
		return "member/mypage_write";
	}
	
	@RequestMapping("/update_nickname")
	public String mypage_info_update_nickname() {
		return "member/popup/mypage_info_update_nickname";
	}
	
	@RequestMapping("/nick_update")
	public String nick_update(MemberVO vo) {
		service.nick_update(vo);
		return "redirect:mypage_info";
	}
	@RequestMapping("/update_userpwd")
	public String mypage_info_update_userpwd() {
		return "member/popup/mypage_info_update_userpwd";
	}
	
	@RequestMapping("/userpwd_update")
	public String userpwd_update(MemberVO vo) {
		//화면에서 입력한 정보를 DB에 변경저장
		service.userpwd_update(vo);
		return "redirect:login";
	}
	@RequestMapping("/user_info_delete")
	public String delete(String userid, HttpSession session) {
		service.user_info_delete(userid);
		session.removeAttribute("login_info");
		return"home";
	}
	
}
