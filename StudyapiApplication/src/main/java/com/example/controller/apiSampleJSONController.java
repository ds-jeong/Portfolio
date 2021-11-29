package com.example.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class apiSampleJSONController {
	
    @RequestMapping(value="/sample/getAddrApi.do")
    public void getAddrApi(HttpServletRequest req, HttpServletResponse response) throws Exception {
    	//api 사이트 : juso.go.kr
		// 요청변수 설정
    	String currentPage = req.getParameter("currentPage");    //요청 변수 설정 (현재 페이지. currentPage : n > 0)
		String countPerPage = req.getParameter("countPerPage");  //요청 변수 설정 (페이지당 출력 개수. countPerPage 범위 : 0 < n <= 100)
		String resultType = req.getParameter("resultType");      //요청 변수 설정 (검색결과형식 설정, json)
		String confmKey = req.getParameter("confmKey");          //요청 변수 설정 (승인키)
		String keyword = req.getParameter("keyword");            //요청 변수 설정 (키워드)
		String firstSort = req.getParameter("firstSort");            //요청 변수 설정 (키워드)
		// OPEN API 호출 URL 정보 설정
		String apiUrl = "https://www.juso.go.kr/addrlink/addrLinkApi.do?currentPage="+currentPage
				+"&countPerPage="+countPerPage
				+"&keyword="+URLEncoder.encode(keyword,"UTF-8")
				+"&confmKey="+confmKey
				+"&resultType="+resultType
				+"&firstSort=" +firstSort;
		URL url = new URL(apiUrl);
		/*
			url.openStream() : 요청한 url의 사이트 데이터를 읽어들인다.
			InputStreamReader : 바이트단위로 읽어들이는 inputstream을 통해 문자 단위로 읽어오는 방식으로 변형한다.
			BufferedReader : 입력속도향상을 위해사용. 데이터를 문자하나씩 읽는것보다 일시적으로 데이터를 저장하는 버퍼영역에서 문자를 보관하고,
							 문자를 다 읽어들이면 한번에 읽는다.
			StringBuffer   : StringBuffer 자료형은 append 라는 메소드를 이용하여 계속해서 문자열을 추가해 나갈 수 있다.
							 String + 연산이 있는 경우 객체가 자동으로 생성되지만, StringBuffer 경우 한번의 객체만 생성된다.
							 StringBuffer 은 String보다 메모리사용량이 많기때문에, 문자열 추가/삭제가 빈번한 경우에만 사용하자.*/
    	BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
    	StringBuffer sb = new StringBuffer();
    	String tempStr = null;

    	while(true){
    		tempStr = br.readLine(); //사이트에서 읽어온 데이터객체를 한줄씩 읽는다.
    		if(tempStr == null) break;
    		sb.append(tempStr);
    	}
    	br.close();
    	response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		response.getWriter().write(sb.toString());

    }
	@RequestMapping(value="/jusoApi")
	public static String main(String[] args, Model model) throws IOException {
		return "apiSampleApplicationJSON";
	}
}
