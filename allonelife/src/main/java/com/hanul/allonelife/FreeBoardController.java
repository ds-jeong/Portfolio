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
import freeboard.FreeBoardCommentVO;
import freeboard.FreeBoardPageVO;
import freeboard.FreeBoardServiceImpl;
import freeboard.FreeBoardVO;
import member.MemberVO;
import recipe.RecipeVO;

@Controller
public class FreeBoardController {
	@Autowired
	private FreeBoardPageVO page;
	@Autowired
	private FreeBoardServiceImpl service;
	@Autowired
	private CommonService common;

	// 자유게시판 좋아요
	@ResponseBody
	@RequestMapping(value = "/good.fb", produces = "text/html; charset=utf-8")
	public String good(FreeBoardVO vo, GoodVO vog, HttpSession ss, int id) {
		StringBuffer msg = new StringBuffer("<script type='text/javascript'>");
		vog.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		vog.setBoardid(id);

		if (service.board_good_select(vog) == true) {
			vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
			vo.setId(id);
			service.board_good_update(vo);

			vog.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
			vog.setBoardid(id);
			service.board_good_insert(vog);
			msg.append("alert('좋아요를 누르셨습니다.'); location='detail.fb?id='+" + id);
			msg.append("</script>");
		} else {
			msg.append("alert('이미 좋아요를 누르셨습니다.'); location='detail.fb?id='+" + id);
			msg.append("</script>");
		}
		return msg.toString();
	}

	// 자유게시판 댓글변경저장처리 요청
	@ResponseBody
	@RequestMapping(value = "/freeboard/comment/update", produces = "application/text; charset=utf-8")
	public String comment_update(@RequestBody FreeBoardCommentVO vo) {// json요청시 Requestbody사용
		return service.freeboard_comment_update(vo) ? "성공" : "실패";
	}

	// 자유게시판 댓글삭제처리 요청
	@ResponseBody
	@RequestMapping("/freeboard/comment/delete/{id}")
	public void comment_delete(@PathVariable int id, FreeBoardVO vo) {
		vo.setId(id);
		service.board_stepdown_update(vo);
		service.freeboard_comment_delete(id);
	}

	// 자유게시판 댓글목록 요청
	@RequestMapping("/freeboard/comment/{pid}")
	public String comment_list(@PathVariable int pid, Model model) {
		model.addAttribute("list", service.freeboard_comment_list(pid));
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");
		return "freeboard/comment/list";
	}

	// 자유게시판 댓글저장처리 요청
	@ResponseBody
	@RequestMapping("/freeboard/comment/insert")
	public boolean comment_insert(FreeBoardVO vo, int pid, String content, HttpSession ss) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pid", pid);
		map.put("content", content);
		map.put("userid", ((MemberVO) ss.getAttribute("login_info")).getUserid());
		vo.setId(pid);
		service.board_root_step_update(vo);
		return service.freeboard_comment_insert(map);
	}

	// 자유게시판 수정처리 요청
	@RequestMapping("/update.fb")
	public String update(int delete, FreeBoardVO vo, MultipartFile file, HttpSession ss, Model model) {
		FreeBoardVO old = service.board_detail(vo.getId());
		String uuid = ss.getServletContext().getRealPath("resources") + old.getFilepath();
		if (file.getSize() > 0) {
			// 파일을 첨부하는 경우
			vo.setFilename(file.getOriginalFilename());
			vo.setFilepath(common.fileUpload(file, ss, "freeboard"));
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
		service.board_update(vo);
		model.addAttribute("id", vo.getId());
		return "freeboard/redirect";
	}

	// 자유게시판 수정화면 요청
	@RequestMapping("/modify.fb")
	public String modify(int id, Model model) {
		model.addAttribute("vo", service.board_detail(id));
		return "freeboard/modify";
	}

	// 자유게시판 삭제처리요청
	@RequestMapping("/delete.fb")
	public String delete(int id) {
		service.board_delete(id);
		return "redirect:aa.fb";
	}

	// 첨부파일 다운로드 요청
	@ResponseBody
	@RequestMapping("/download.fb")
	public File download(int id, HttpSession ss, HttpServletResponse response) {
		FreeBoardVO vo = service.board_detail(id);
		return common.fileDownload(vo.getFilename(), vo.getFilepath(), ss, response);

	}

	// 자유게시판 상세화면요청
	@RequestMapping("/detail.fb")
	public String detail(int id, Model model) {
		service.board_read(id);
		model.addAttribute("page", page);
		model.addAttribute("vo", service.board_detail(id));
		model.addAttribute("crlf", "\r\n");
		return "freeboard/detail";
	}

	// 신규자유게시판 저장 처리요청
	@RequestMapping("/insert.fb")
	public String insert(FreeBoardVO vo, MultipartFile file, HttpSession ss) {
		// 첨부파일이 있는 경우
		if (file.getSize() > 0) {
			vo.setFilename(file.getOriginalFilename());
			vo.setFilepath(common.fileUpload(file, ss, "board"));
		}
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.board_insert(vo);
		return "redirect:aa.fb";
	}

	@RequestMapping("/new.fb")
	public String insert() {
		return "freeboard/new";
	}

	@RequestMapping("/aa.fb")
	public String list(Model model, @RequestParam(defaultValue = "1") int curPage,
			@RequestParam(defaultValue = "") String search, @RequestParam(defaultValue = "") String keyword) {

		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);

		model.addAttribute("page", service.board_list(page));

		return "freeboard/list";
	}

}
