package com.hanul.allonelife;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import common.CommonService;
import item.ItemPageVO;
import item.ItemServiceImpl;
import item.PointhVO;
import member.MemberVO;

@Controller
public class ItemController {
	
	@Autowired
	private ItemServiceImpl service;
	@Autowired
	private CommonService common;
	@Autowired private ItemPageVO page;
	
	//아이템 1 클릭시
	@RequestMapping("/insert.itemone")
	public String itemone(MemberVO vo, PointhVO pvo, HttpSession ss) {
		pvo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		pvo.setPoint(((MemberVO) ss.getAttribute("login_info")).getPoint()); 
		service.pointh_itemone_insert(pvo);
		 
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.member_point_itemone_update(vo);
		
		return "redirect:list.it";
	}
	
	//아이템 2 클릭시
	@RequestMapping("/insert.itemtwo")
	public String itemtwo(MemberVO vo, PointhVO pvo, HttpSession ss) {	  
		pvo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		pvo.setPoint(((MemberVO) ss.getAttribute("login_info")).getPoint()); 
		service.pointh_itemtwo_insert(pvo);
			 
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.member_point_itemtwo_update(vo);
		
		return "redirect:list.it";
	}
	
	//아이템 3 클릭시
	@RequestMapping("/insert.itemthree")
	public String itemthree(MemberVO vo, PointhVO pvo, HttpSession ss) {
		pvo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		pvo.setPoint(((MemberVO) ss.getAttribute("login_info")).getPoint()); 
		service.pointh_itemthree_insert(pvo);
			 
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.member_point_itemthree_update(vo);
		
		return "redirect:list.it";
	}	
	@RequestMapping("/insert.item4")
	public String item4(MemberVO vo, PointhVO pvo, HttpSession ss) {
		pvo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		pvo.setPoint(((MemberVO) ss.getAttribute("login_info")).getPoint()); 
		service.pointh_item4_insert(pvo);
		
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.member_point_item4_update(vo);
		
		return "redirect:list.it";
	}	
	@RequestMapping("/insert.item5")
	public String item5(MemberVO vo, PointhVO pvo, HttpSession ss) {
		pvo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		pvo.setPoint(((MemberVO) ss.getAttribute("login_info")).getPoint()); 
		service.pointh_item5_insert(pvo);
		
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.member_point_item5_update(vo);
		
		return "redirect:list.it";
	}	
	@RequestMapping("/insert.item6")
	public String item6(MemberVO vo, PointhVO pvo, HttpSession ss) {
		pvo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		pvo.setPoint(((MemberVO) ss.getAttribute("login_info")).getPoint()); 
		service.pointh_item6_insert(pvo);
		
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.member_point_item6_update(vo);
		
		return "redirect:list.it";
	}	
		
	
	// 상품페이지 화면 요청
	@RequestMapping("/list.it")
	public String recipe(Model model, MemberVO vo, HttpSession ss) {

		if(ss.getAttribute("login_info") !=null) {

		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		model.addAttribute("list", service.member_list(vo));

		}

		return "item/list";
	}
	
	@RequestMapping("/item_list")
	public String list(HttpSession session,
			Model model,
			@RequestParam (defaultValue = "1")int curPage,
			@RequestParam(defaultValue = "") String keyword) {
		
		page.setCurPage(curPage);
		page.setKeyword(keyword);
	
		model.addAttribute("page", service.item_list(page));
			
		return "item/user_list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/send_item", produces = "text/html; charset=utf-8")
	public String send_item(Model model, int id, MemberVO vo, PointhVO pvo, HttpSession ss, HttpServletRequest request) {
		StringBuffer msg = new StringBuffer("<script type='text/javascript'>");
		/** 넘어온 리스트를 저장한다 */
		String name, email;
		int itemid;
		email = service.select_email(service.select_userid(pvo.getId()));
		name = service.select_name(service.select_userid(pvo.getId()));
		itemid = service.select_itemid(pvo.getId());

		if (service.send_item(id)) {
			common.itemsend(name, email, request, itemid); 
			msg.append("alert('이메일 발송에 성공했습니다.'); location='item_list'");
		} else {
			msg.append("alert('이메일 발송에 실패했습니다'); history.go(-1)");
		}
		msg.append("</script>");

		return msg.toString();
	}
}
