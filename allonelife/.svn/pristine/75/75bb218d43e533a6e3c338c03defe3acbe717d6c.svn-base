package com.hanul.allonelife;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import common.CommonService;
import exchange.GoodVO;
import item.PointhVO;
import member.MemberVO;
import tip.TipCommentVO;
import tip.TipPageVO;
import tip.TipServiceImpl;
import tip.TipVO;

@Controller
public class TipController {

	@Autowired
	private TipPageVO page;
	@Autowired
	private TipServiceImpl service;
	@Autowired
	private CommonService common;

	// 글삭제시 포인트 -50
	@RequestMapping("/pointm.ti")
	public String itemt(MemberVO vo, PointhVO pvo, HttpSession ss) {
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.tip_pointm_update(vo);
		pvo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		pvo.setPoint(((MemberVO) ss.getAttribute("login_info")).getPoint());
		service.tip_pointm_insert(pvo);

		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.tip_pointm_update(vo);
		
		return "redirect:list.ti";
	}

	// 글쓰면 포인트 +50
	@RequestMapping("/point.ti")
	public String itemone(MemberVO vo, PointhVO pvo, HttpSession ss) {
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.tip_point_update(vo);

		pvo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		pvo.setPoint(((MemberVO) ss.getAttribute("login_info")).getPoint());
		service.tip_point_insert(pvo);
		
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.tip_point_update(vo);
		   
		return "redirect:list.ti";
	}

	// 팁 좋아요 요청
	@ResponseBody
	@RequestMapping(value = "/good.ti", produces = "text/html; charset=utf-8")
	public String good(TipVO vo, GoodVO vog, HttpSession ss, int id) {
		StringBuffer msg = new StringBuffer("<script type='text/javascript'>");
		vog.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		vog.setBoardid(id);

		if (service.tip_good_select(vog) == true) {
			vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
			vo.setId(id);
			service.tip_good_update(vo);

			vog.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
			vog.setBoardid(id);
			service.tip_good_insert(vog);
			msg.append("alert('좋아요를 누르셨습니다.'); location='detail.ti?id='+" + id);
			msg.append("</script>");
		} else {
			msg.append("alert('이미 좋아요를 누르셨습니다.'); location='detail.ti?id='+" + id);
			msg.append("</script>");
		}
		return msg.toString();
	}

	
	// 팁 댓글 변경저장처리 요청
	@ResponseBody
	@RequestMapping(value = "/tip/comment/update", produces = "application/text; charset=utf-8")
	public String comment_update(@RequestBody TipCommentVO vo) {
		return service.tip_comment_update(vo) ? "성공" : "실패";
	}

	// 팁 댓글 삭제처리 요청
	@ResponseBody
	@RequestMapping("/tip/comment/delete/{id}")
	public void comment_delete(@PathVariable int id, TipVO vo) {
		vo.setId(id);
		service.tip_stepdown_update(vo);
		service.tip_comment_delete(id);
	}

	// 팁 댓글목록 요청
	@RequestMapping("/tip/comment/{pid}")
	public String comment_list(Model model, @PathVariable int pid) {
		model.addAttribute("list", service.tip_comment_list(pid));
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");
		return "tip/comment/list";
	}

	// 팁 댓글저장처리 요청
	@ResponseBody
	@RequestMapping("/tip/comment/insert")
	public boolean comment_insert(TipVO vo, HttpSession ss, int pid, String content) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pid", pid);
		map.put("content", content);
		map.put("userid", ((MemberVO) ss.getAttribute("login_info")).getUserid());
		vo.setId(pid);
		service.tip_root_step_update(vo);
		return service.tip_comment_insert(map);
	}

	// 팁글 수정처리 요청
	@RequestMapping("/update.ti")
	public String update(TipVO vo, int delete, HttpSession ss, MultipartFile file, Model model) {

		TipVO old = service.tip_detail(vo.getId());
		String uuid = ss.getServletContext().getRealPath("resources") + old.getFilepath();

		if (file.getSize() > 0) {
			// 파일을 첨부하는 경우
			vo.setFilename(file.getOriginalFilename());
			vo.setFilepath(common.fileUpload(file, ss, "tip"));
			// 원래 첨부된 파일을 바꿔 첨부하는 경우
			// 원래 첨부된 파일을 삭제한다.
			File f = new File(uuid);
			if (f.exists())
				f.delete();
		} else {
			// 파일첨부하지 않는 경우
			if (delete != 1) {
				// 1.원래 첨부된 파일을 그대로 사용하는 경우
				vo.setFilename(old.getFilename());
				vo.setFilepath(old.getFilepath());

			} else {
				// 2.원래 첨부된 파일을 삭제하는 경우
				// 원래 첨부된 파일을 삭제한다.
				File f = new File(uuid);
				if (f.exists())
					f.delete();
			}
		}
		service.tip_update(vo);
		model.addAttribute("id", vo.getId());
		return "tip/redirect";
	}

	// 팁글 수정화면 요청
	@RequestMapping("/modify.ti")
	public String modify(int id, Model model) {
		model.addAttribute("vo", service.tip_detail(id));
		return "tip/modify";
	}

	// 팁글 삭제처리 요청
	@RequestMapping("/delete.ti")
	public String delete(int id) {
		service.tip_delete(id);
		return "redirect:pointm.ti";
	}

	// 첨부파일 다운로드 요청
	@ResponseBody
	@RequestMapping("/download.ti")
	public File download(int id, HttpSession ss, HttpServletResponse response) {
		TipVO vo = service.tip_detail(id);
		return common.fileDownload(vo.getFilename(), vo.getFilepath(), ss, response);
	}

	// 팁글 상세화면 요청
	@RequestMapping("/detail.ti")
	public String detail(int id, @RequestParam(defaultValue = "false") boolean read, Model model) {
		if (read) {
			service.tip_read(id);
			model.addAttribute("id", id);
			return "tip/redirect";
		} else {
			model.addAttribute("page", page);
			model.addAttribute("vo", service.tip_detail(id));
			model.addAttribute("crlf", "\r\n");
			return "tip/detail";
		}
	}

	// 팁글 저장처리 요청
	@RequestMapping("/insert.ti")
	public String insert(TipVO vo, HttpSession ss, MultipartFile file) {
		// 첨부파일이 있는 경우
		if (file.getSize() > 0) {
			vo.setFilename(file.getOriginalFilename());
			vo.setFilepath(common.fileUpload(file, ss, "tip"));
		}
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.tip_insert(vo);
		return "redirect:point.ti";
	}

	// 팁글 작성 화면 요청
	@RequestMapping("/new.ti")
	public String tip() {
		return "tip/new";
	}

	// 팁글 목록화면 요청
	@RequestMapping("/list.ti")
	public String list(Model model, @RequestParam(defaultValue = "1") int curPage,
			@RequestParam(defaultValue = "") String search, @RequestParam(defaultValue = "") String keyword) {

		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);

		model.addAttribute("page", service.tip_list(page));
		return "tip/list";
	}

}