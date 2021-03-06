package com.example.StudyXmlToJson.controller;


import org.json.JSONObject;
import org.json.XML;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

@Controller
public class XmlToJsonController {

	@RequestMapping(value = "/sample/getAddrApi.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String getAddrApi(HttpServletRequest req) throws Exception {
		//https://www.juso.go.kr/ : 도로명주소API사용

		// 요청변수 설정
		String currentPage = req.getParameter("currentPage");    //요청 변수 설정 (현재 페이지. currentPage : n > 0)
		String countPerPage = req.getParameter("countPerPage");  //요청 변수 설정 (페이지당 출력 개수. countPerPage 범위 : 0 < n <= 100)
		String confmKey = req.getParameter("confmKey");          //요청 변수 설정 (승인키)
		String keyword = req.getParameter("keyword");            //요청 변수 설정 (키워드)
		// OPEN API 호출 URL 정보 설정
		String apiUrl = "https://www.juso.go.kr/addrlink/addrLinkApi.do?currentPage="+currentPage+"&countPerPage="+countPerPage+"&keyword="+URLEncoder.encode(keyword,"UTF-8")+"&confmKey="+confmKey;
		URL url = new URL(apiUrl);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
		StringBuffer sb = new StringBuffer();
		String tempStr = null;

		while(true){
			tempStr = br.readLine();
			if(tempStr == null) break;
			sb.append(tempStr);								// 응답결과 XML 저장
		}
		br.close();
		/*response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		response.getWriter().write(sb.toString());			*/

		System.out.println("XML 데이터 객체 : " + sb.toString());

		JSONObject obj = XML.toJSONObject(sb.toString());
		String jsonResult = obj.toString();
		System.out.println("jsonResult : " + jsonResult);



		return jsonResult;

	}

	@RequestMapping(value="/jusoApi")
	public static String main(String[] args, Model model) throws IOException {
		return "apiSampleApplicationXML";
	}
}
