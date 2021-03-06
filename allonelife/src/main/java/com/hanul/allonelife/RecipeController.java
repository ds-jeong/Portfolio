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
import recipe.RecipeCommentVO;
import recipe.RecipePageVO;
import recipe.RecipeServiceImpl;
import recipe.RecipeVO;

@Controller
public class RecipeController {

	@Autowired
	private RecipePageVO page;
	@Autowired
	private RecipeServiceImpl service;
	@Autowired
	private CommonService common;
	
	//글삭제시 포인트 -50
	@RequestMapping("/pointm.re")
	public String itemt(MemberVO vo, PointhVO pvo, HttpSession ss) {
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.recipe_pointm_update(vo);
		
		pvo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		pvo.setPoint(((MemberVO) ss.getAttribute("login_info")).getPoint()); 
		service.recipe_pointm_insert(pvo);
		
		return "redirect:list.re";
	}
	
	//글쓰면 포인트 +50
	@RequestMapping("/point.re")
	public String itemone(MemberVO vo, PointhVO pvo, HttpSession ss) {
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.recipe_point_update(vo);
		  
		pvo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		pvo.setPoint(((MemberVO) ss.getAttribute("login_info")).getPoint()); 
		service.recipe_point_insert(pvo);
		 
		return "redirect:list.re";
	}
	
	//레시피 좋아요 요청
	@ResponseBody
	@RequestMapping(value = "/good.re", produces = "text/html; charset=utf-8")
	public String good(RecipeVO vo, GoodVO vog, HttpSession ss, int id) {
		StringBuffer msg = new StringBuffer("<script type='text/javascript'>");
		
		vog.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		vog.setBoardid(id);
		
		if (service.recipe_good_select(vog))
		{
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		vo.setId(id);
		service.recipe_good_update(vo);
		
		vog.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		vog.setBoardid(id);
		service.recipe_good_insert(vog);
		msg.append("alert('좋아요를 누르셨습니다.'); location='detail.re?id='+" + id);
		msg.append("</script>");
		}else {
			msg.append("alert('이미 좋아요를 누르셨습니다.'); location='detail.re?id='+" + id );
			msg.append("</script>");
		}
		return msg.toString();
	}
	
	// 레시피안내 댓글 변경저장처리 요청
	@ResponseBody
	@RequestMapping(value = "/recipe/comment/update", produces = "application/text; charset=utf-8")
	public String comment_update(@RequestBody RecipeCommentVO vo) {
		return service.recipe_comment_update(vo) ? "성공" : "실패";
	}

	// 레시피안내 댓글 삭제처리 요청
	@ResponseBody
	@RequestMapping("/recipe/comment/delete/{id}")
	public void comment_delete(@PathVariable int id, RecipeVO vo) {
		vo.setId(id);
		service.recipe_stepdown_update(vo);
		service.recipe_comment_delete(id);
	}
	
	// 레시피안내 댓글목록 요청
	@RequestMapping("/recipe/comment/{pid}")
	public String comment_list(Model model, @PathVariable int pid) {
		model.addAttribute("list", service.recipe_comment_list(pid));
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");
		return "recipe/comment/list";
	}

	// 레시피안내 댓글저장처리 요청
	@ResponseBody
	@RequestMapping("/recipe/comment/insert")
	public boolean comment_insert(RecipeVO vo, HttpSession ss, int pid, String content) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pid", pid);
		map.put("content", content);
		map.put("userid", ((MemberVO) ss.getAttribute("login_info")).getUserid());
		vo.setId(pid);
		service.recipe_root_step_update(vo);
		return service.recipe_comment_insert(map);
	}

	
	// 레시피글 수정처리 요청
	@RequestMapping("/update.re")
	public String update(RecipeVO vo, int delete, HttpSession ss, MultipartFile file, Model model) {

		RecipeVO old = service.recipe_detail(vo.getId());
		String uuid = ss.getServletContext().getRealPath("resources") + old.getFilepath();

		if (file.getSize() > 0) {
			// 파일을 첨부하는 경우
			vo.setFilename(file.getOriginalFilename());
			vo.setFilepath(common.fileUpload(file, ss, "recipe"));
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
		service.recipe_update(vo);
		model.addAttribute("id", vo.getId());
		return "recipe/redirect";
	}

	// 레시피글 수정화면 요청
	@RequestMapping("/modify.re")
	public String modify(int id, Model model) {
		model.addAttribute("vo", service.recipe_detail(id));
		return "recipe/modify";
	}

	// 레시피글 삭제처리 요청
	@RequestMapping("/delete.re")
	public String delete(int id) {
		service.recipe_delete(id);
		return "redirect:pointm.re";
	}

	// 첨부파일 다운로드 요청
	@ResponseBody
	@RequestMapping("/download.re")
	public File download(int id, HttpSession ss, HttpServletResponse response) {
		RecipeVO vo = service.recipe_detail(id);
		return common.fileDownload(vo.getFilename(), vo.getFilepath(), ss, response);
	}

	// 레시피 상세화면 요청
	@RequestMapping("/detail.re")
	public String detail(int id, @RequestParam(defaultValue = "false") boolean read, Model model) {
		if (read) {
			service.recipe_read(id);
			model.addAttribute("id", id);
			return "recipe/redirect";
		} else {
			model.addAttribute("page", page);
			model.addAttribute("vo", service.recipe_detail(id));
			model.addAttribute("crlf", "\r\n");
			return "recipe/detail";
		}
	}

	// 레시피안내 저장처리 요청
	@RequestMapping("/insert.re")
	public String insert(RecipeVO vo, HttpSession ss, MultipartFile file) {
		// 첨부파일이 있는 경우
		if (file.getSize() > 0) {
			vo.setFilename(file.getOriginalFilename());
			vo.setFilepath(common.fileUpload(file, ss, "recipe"));
		}
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.recipe_insert(vo);
		return "redirect:point.re";
	}

	// 레시피작성 화면 요청
	@RequestMapping("/new.re")
	public String recipe() {
		return "recipe/new";
	}

	// 레시피목록화면 요청
	@RequestMapping("/list.re")
	public String list(Model model, @RequestParam(defaultValue = "1") int curPage,
			@RequestParam(defaultValue = "") String search, @RequestParam(defaultValue = "") String keyword) {

		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);

		model.addAttribute("page", service.recipe_list(page));
		return "recipe/list";
	}

}
