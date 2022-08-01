package com.hanul.allonelife;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import common.CommonService;
import customer_manager.CustomerManagerPageVO;
import customer_manager.CustomerManagerServiceImpl;


@Controller
public class CustomerManagerController {
	@Autowired private CustomerManagerPageVO page;
	@Autowired private CustomerManagerServiceImpl service;
	@Autowired private CommonService common;
	
	
	
	
	//고객삭제처리 요청
		@RequestMapping("/delete.cm")
		public String delete(String id) {
			
			//선택한 고객정보를 DB에서 삭제한 후
			service.customer_manager_delete(id);
			//목록화면으로 연결
			return "redirect:customer_manager";
		}
		//고객상세화면 요청
		@RequestMapping("/detail.cm")
		public String datail(Model model,String id) {
			//해당 고객정보를 조회해와 화면에 출력할 수 있도록
			//model에 담는다
			model.addAttribute("vo",service.customer_manager_detail(id));
			return "customer_manager/detail";		
		}

	//고객관리목록
		@RequestMapping("/customer_manager")
		public String list(Model model,
				@RequestParam (defaultValue = "1")int curPage,
				@RequestParam(defaultValue = "") String search,
				@RequestParam(defaultValue = "") String keyword) {
			
			page.setCurPage(curPage);
			page.setSearch(search);
			page.setKeyword(keyword);
		
			model.addAttribute("page", service.customer_manager_list(page));
				
			return "customer_manager/list";
		}
	
	
}
