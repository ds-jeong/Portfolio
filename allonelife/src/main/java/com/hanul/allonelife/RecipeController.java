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
	
	//�ۻ����� ����Ʈ -50
	@RequestMapping("/pointm.re")
	public String itemt(MemberVO vo, PointhVO pvo, HttpSession ss) {
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.recipe_pointm_update(vo);
		
		pvo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		pvo.setPoint(((MemberVO) ss.getAttribute("login_info")).getPoint()); 
		service.recipe_pointm_insert(pvo);
		
		return "redirect:list.re";
	}
	
	//�۾��� ����Ʈ +50
	@RequestMapping("/point.re")
	public String itemone(MemberVO vo, PointhVO pvo, HttpSession ss) {
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.recipe_point_update(vo);
		  
		pvo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		pvo.setPoint(((MemberVO) ss.getAttribute("login_info")).getPoint()); 
		service.recipe_point_insert(pvo);
		 
		return "redirect:list.re";
	}
	
	//������ ���ƿ� ��û
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
		msg.append("alert('���ƿ並 �����̽��ϴ�.'); location='detail.re?id='+" + id);
		msg.append("</script>");
		}else {
			msg.append("alert('�̹� ���ƿ並 �����̽��ϴ�.'); location='detail.re?id='+" + id );
			msg.append("</script>");
		}
		return msg.toString();
	}
	
	// �����Ǿȳ� ��� ��������ó�� ��û
	@ResponseBody
	@RequestMapping(value = "/recipe/comment/update", produces = "application/text; charset=utf-8")
	public String comment_update(@RequestBody RecipeCommentVO vo) {
		return service.recipe_comment_update(vo) ? "����" : "����";
	}

	// �����Ǿȳ� ��� ����ó�� ��û
	@ResponseBody
	@RequestMapping("/recipe/comment/delete/{id}")
	public void comment_delete(@PathVariable int id, RecipeVO vo) {
		vo.setId(id);
		service.recipe_stepdown_update(vo);
		service.recipe_comment_delete(id);
	}
	
	// �����Ǿȳ� ��۸�� ��û
	@RequestMapping("/recipe/comment/{pid}")
	public String comment_list(Model model, @PathVariable int pid) {
		model.addAttribute("list", service.recipe_comment_list(pid));
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");
		return "recipe/comment/list";
	}

	// �����Ǿȳ� �������ó�� ��û
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

	
	// �����Ǳ� ����ó�� ��û
	@RequestMapping("/update.re")
	public String update(RecipeVO vo, int delete, HttpSession ss, MultipartFile file, Model model) {

		RecipeVO old = service.recipe_detail(vo.getId());
		String uuid = ss.getServletContext().getRealPath("resources") + old.getFilepath();

		if (file.getSize() > 0) {
			// ������ ÷���ϴ� ���
			vo.setFilename(file.getOriginalFilename());
			vo.setFilepath(common.fileUpload(file, ss, "recipe"));
			// ���� ÷�ε� ������ �ٲ� ÷���ϴ� ���
			// ���� ÷�ε� ������ �����Ѵ�.
			File f = new File(uuid);
			if (f.exists())
				f.delete();
		} else {
			// ����÷������ �ʴ� ���
			if (delete != 1) {
				// 1.���� ÷�ε� ������ �״�� ����ϴ� ���
				vo.setFilename(old.getFilename());
				vo.setFilepath(old.getFilepath());

			} else {
				// 2.���� ÷�ε� ������ �����ϴ� ���
				// ���� ÷�ε� ������ �����Ѵ�.
				File f = new File(uuid);
				if (f.exists())
					f.delete();
			}
		}
		service.recipe_update(vo);
		model.addAttribute("id", vo.getId());
		return "recipe/redirect";
	}

	// �����Ǳ� ����ȭ�� ��û
	@RequestMapping("/modify.re")
	public String modify(int id, Model model) {
		model.addAttribute("vo", service.recipe_detail(id));
		return "recipe/modify";
	}

	// �����Ǳ� ����ó�� ��û
	@RequestMapping("/delete.re")
	public String delete(int id) {
		service.recipe_delete(id);
		return "redirect:pointm.re";
	}

	// ÷������ �ٿ�ε� ��û
	@ResponseBody
	@RequestMapping("/download.re")
	public File download(int id, HttpSession ss, HttpServletResponse response) {
		RecipeVO vo = service.recipe_detail(id);
		return common.fileDownload(vo.getFilename(), vo.getFilepath(), ss, response);
	}

	// ������ ��ȭ�� ��û
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

	// �����Ǿȳ� ����ó�� ��û
	@RequestMapping("/insert.re")
	public String insert(RecipeVO vo, HttpSession ss, MultipartFile file) {
		// ÷�������� �ִ� ���
		if (file.getSize() > 0) {
			vo.setFilename(file.getOriginalFilename());
			vo.setFilepath(common.fileUpload(file, ss, "recipe"));
		}
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.recipe_insert(vo);
		return "redirect:point.re";
	}

	// �������ۼ� ȭ�� ��û
	@RequestMapping("/new.re")
	public String recipe() {
		return "recipe/new";
	}

	// �����Ǹ��ȭ�� ��û
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