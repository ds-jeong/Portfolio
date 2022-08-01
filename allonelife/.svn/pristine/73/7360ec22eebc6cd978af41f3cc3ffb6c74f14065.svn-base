package com.hanul.allonelife;

import java.io.File;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import common.CommonService;
import member.MemberVO;
import notice.Aol_NoticePageVO;
import notice.Aol_NoticeServiceImpl;
import notice.Aol_NoticeVO;


@Controller
public class NoticeController {
	@Autowired private Aol_NoticeServiceImpl service;
	@Autowired private Aol_NoticePageVO page;
	@Autowired private CommonService common;
	
	//占쏙옙占쏙옙占쌜삼옙占쏙옙처占쏙옙 占쏙옙청
	@RequestMapping("/delete.no")
	public String delete(int id, RedirectAttributes redirect) {
		service.notice_delete(id);
			
		redirect.addFlashAttribute("curPage", page.getCurPage());
		redirect.addFlashAttribute("search", page.getSearch());
		redirect.addFlashAttribute("keyword", page.getKeyword());
		return "redirect:list.no";
		}
	
	
		
	//占식띰옙占쏙옙占� int占쏙옙 占쏙옙占쏙옙	
	//占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙처占쏙옙 占쏙옙청
	@RequestMapping("/update.no")
	public String update(int attach, Aol_NoticeVO vo, MultipartFile file, RedirectAttributes redirect, HttpSession ss
			, Model model) {
		
		/* Aol_NoticeVO old = service.notice_detail(vo.getId()); */
		/*
		 * String uuid = ss.getServletContext().getRealPath("resources") +
		 * File.separator + old.getFilepath();
		 * 
		 * //첨占쏙옙占쏙옙占쏙옙 占쌍댐옙 占쏙옙占� if( file.getSize()>0 ) { vo.setFilename(
		 * file.getOriginalFilename() ); vo.setFilepath( common.fileUpload(file, ss,
		 * "notice"));
		 * 
		 * //占쏙옙占쏙옙占쏙옙 첨占싸듸옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싼댐옙. File f = new File(uuid); if( f.exists() ) f.delete();
		 * }else {
		 * 
		 * if( attach==0 ) { //占쏙옙占쏙옙占쏙옙 첨占싸듸옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싼댐옙. File f = new File(uuid); if(
		 * f.exists() ) f.delete(); }else { //占쏙옙占쏙옙占쏙옙 첨占싸듸옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙쨈占�
		 * vo.setFilename(old.getFilename()); vo.setFilepath(old.getFilepath()); }
		 */
		
		service.notice_update(vo);
		model.addAttribute("id", vo.getId());
		model.addAttribute("view", "detail");
		model.addAttribute("page", page);
		return "notice/redirect";
	}

	
	
	//占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙화占쏙옙 占쏙옙청
	@RequestMapping("/modify.no")
	public String modify(int id, Model model) {
		model.addAttribute("vo", service.notice_detail(id));
		return "notice/modify";	
	}
	
	/*
	 * //占쏙옙占쏙옙 占쌕울옙琯占� 占쏙옙청
	 * 
	 * @ResponseBody @RequestMapping("/download.no") public File download(int id,
	 * HttpSession ss, HttpServletResponse response) {
	 * 
	 * Aol_NoticeVO vo = service.notice_detail(id); return
	 * common.fileDownload(vo.getFilename(), vo.getFilepath(), ss, response); }
	 */
	
	
	//占쏙옙占쏙옙 占쌉시글삼옙화占쏙옙 占쏙옙청
	@RequestMapping("/detail.no")
	public String detail(@ModelAttribute("id") int id, Model model) {
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");
		
		
		//
		service.notice_read(id);
		model.addAttribute("page", page);
		model.addAttribute("vo", service.notice_detail(id));
		return "notice/detail";
	}
	
	
	//占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙처占쏙옙 占쏙옙청
	@RequestMapping(value = {"/insert.no"}, method = RequestMethod.POST)
	public String insert(MultipartFile file, Aol_NoticeVO vo, HttpSession ss) {
		
		/*
		 * if ( file.getSize() > 0 ) { vo.setFilename(file.getOriginalFilename());
		 * vo.setFilepath(common.fileUpload(file, ss, "notice")); }
		 */
		
		vo.setWriter(((MemberVO)ss.getAttribute("login_info")).getName());
		service.notice_insert(vo);
		return "redirect:list.no";
	}
	
	
	//占쏙옙占쌜억옙占쏙옙 화占쏙옙 占쏙옙청
		@RequestMapping("/new.no")
		public String notice() {
			return "notice/new";
		}
	
	//占쏙옙占쏙옙占쌜몌옙占� 화占쏙옙 占쏙옙청
	@RequestMapping("/list.no")
	public String list(Model model,
			@RequestParam (defaultValue = "1")int curPage,
			@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "") String keyword) {
		
		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);
	
		model.addAttribute("page", service.notice_list(page));
		return "notice/list";
	}
	
/*	//占쏙옙占쏙옙占쌜몌옙占� 화占쏙옙 占쏙옙청
	@RequestMapping("/list.no")
	public String list(Model model,
			@RequestParam(required=false) String search, 
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="1") int curPage) {
			
			page.setSearch(search==null ? "" : search);
			page.setKeyword(keyword);
			page.setCurPage(curPage);
			model.addAttribute("page", service.notice_list(page) );
			return "notice/list";
	}*/
}
