package org.jds.web;



import java.io.File;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import common.CommonService;
import data.DataService;
import data.DataServiceImpl;
import kangwondo.KangwondoPageVO;
import kangwondo.KangwondoVO;
import kangwondo.kangwondoServicelmpl;
import member.MemberVO;





@Controller
public class KangwondoController {
	@Autowired
	private KangwondoPageVO page;
	@Autowired
	private kangwondoServicelmpl service;
	@Autowired
	private CommonService common;
	

	// ������ȯ�� ����ó�� ��û
		@RequestMapping("/update.kangwondo")
		public String update(KangwondoVO vo, int delete, HttpSession ss, MultipartFile file, Model model) {

			KangwondoVO old = service.kangwondo_detail(vo.getNo());
			String uuid = ss.getServletContext().getRealPath("resources") + old.getFilepath();

			if (file.getSize() > 0) {
				// ������ ÷���ϴ� ���
				vo.setFilename(file.getOriginalFilename());
				vo.setFilepath(common.fileUpload(file, ss, "kangwondo"));
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
			service.kangwondo_update(vo);
			model.addAttribute("no", vo.getNo());
			return "kangwondo/redirect";
		}
		@RequestMapping("/modify.kangwondo")
		public String modify(int no, Model model) {
			model.addAttribute("vo", service.kangwondo_detail(no));
			return "kangwondo/modify";
		}
		// ������ȯ�� ����ó�� ��û
		@RequestMapping("/delete.kangwondo")
		public String delete(int no) {
			service.kangwondo_delete(no);
			return "redirect:list.kangwondo";
		}

	@ResponseBody
	@RequestMapping("/download.kangwondo")
	public File download(int no, HttpSession ss, HttpServletResponse response) {
		KangwondoVO vo = service.kangwondo_detail(no);
		return common.fileDownload(vo.getFilename(), vo.getFilepath(), ss, response);
	}

	
	// ������ȯ ��ȭ�� ��û
		@RequestMapping("/detail.kangwondo")
		public String detail(int no, @RequestParam(defaultValue = "false") boolean read, Model model) {
			if (read) {
				service.kangwondo_read(no);
				model.addAttribute("no", no);
				return "kangwondo/redirect";
			} else {
				model.addAttribute("page", page);
				model.addAttribute("vo", service.kangwondo_detail(no));
				model.addAttribute("crlf", "\r\n");
				return "kangwondo/detail";
			}
		}
	@RequestMapping("/list.kangwondo")
	public String list(Model model, @RequestParam(defaultValue = "1") int curPage,
			@RequestParam(defaultValue = "") String search, @RequestParam(defaultValue = "") String keyword) {

		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);

		model.addAttribute("page", service.kangwondo_list(page));
		return "kangwondo/list";
	}
	
	@RequestMapping("/insert.kangwondo")
	public String insert(MultipartFile file, HttpSession ss, KangwondoVO vo) {
		if (file.getSize() > 0) {
			vo.setFilename(file.getOriginalFilename());// �����̸� ����
			vo.setFilepath(common.fileUpload(file, ss, "kangwondo"));
		}
		vo.setUserid(((MemberVO) ss.getAttribute("login_info")).getUserid());
		service.kangwondo_insert(vo);
		return "redirect:list.kangwondo";
	}
	
	@RequestMapping("/new.kangwondo")
	public String kangwondo() {
		return "kangwondo/new";
	}
	
	//���������� ȭ���û 
	@RequestMapping("/list.cu")
	public String list() {
		return "kangwondo/api_list";
	}
	//���������� ȭ���û 
		@RequestMapping("/list")
		public String list1() {
			return "data/test";
		}
}
