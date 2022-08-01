package com.hanul.allonelife;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mainfamous.MainFamousServiceImpl;


@Controller
public class HomeController {
	
	@Autowired
	private MainFamousServiceImpl service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//오류에 대한 처리
		@RequestMapping("/err")
		public String error_page(Model model,
				HttpServletRequest request)  {
			Throwable exception 
				= (Throwable)request.getAttribute("javax.servlet.error.exception");
			StringBuilder msg = new StringBuilder();
			while( exception !=null ) {
				msg.append( "<p>" 
							+ exception.getMessage() +"</p>");
				exception = exception.getCause();
			}
			model.addAttribute("msg", msg.toString());
					
			int code = (Integer)request.getAttribute("javax.servlet.error.status_code");
			return "error/" + code;
		}
		
		
		@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
		public String home(Locale locale, Model model) {
			logger.info("Welcome home! The client locale is {}.", locale);
			
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			
			String formattedDate = dateFormat.format(date);
			
			model.addAttribute("serverTime", formattedDate );
			
			model.addAttribute("noticelist", service.notice_new_list() );
			model.addAttribute("recipelist", service.recipe_famous_list() );
			model.addAttribute("exchangelist", service.exchange_famous_list() );
			model.addAttribute("tiplist", service.tip_famous_list() );
			model.addAttribute("boardlist", service.board_famous_list() );
			
			return "home";
		}
		
	}