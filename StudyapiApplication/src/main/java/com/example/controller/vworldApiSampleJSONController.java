package com.example.controller;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
//import org.springmodules.validation.commons.DefaultBeanValidator;


@Controller
public class vworldApiSampleJSONController {
	
    @RequestMapping(value="/sample/vworldgetAddrApi.do")
    public void vworldgetAddrApi(HttpServletRequest req, HttpServletResponse response, Model model) throws Exception {
		// api 사이트 : https://dev.vworld.kr/
    	String addr = req.getParameter("keyword");
    	String category = req.getParameter("category");
    	String currentPage = req.getParameter("currentPage");

		// 1. URL을 만들기 위한 StringBuilder.
		StringBuilder urlBuilder = new StringBuilder("http://api.vworld.kr/req/search"); /*URL*/
		// 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키.
		urlBuilder.append("?" + URLEncoder.encode("key","UTF-8") + "");
		urlBuilder.append("&" + URLEncoder.encode("service","UTF-8") + "=" + URLEncoder.encode("search", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("version","UTF-8") + "=" + URLEncoder.encode("2.0", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("request","UTF-8") + "=" + URLEncoder.encode("search", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("format","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("errorFormat","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("size","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("page","UTF-8") + "=" + URLEncoder.encode(currentPage, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("query","UTF-8") + "=" + URLEncoder.encode(addr, "UTF-8")); //리퀘스트
		urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("address", "UTF-8")); //리퀘
		urlBuilder.append("&" + URLEncoder.encode("category","UTF-8") + "=" + URLEncoder.encode(category, "UTF-8")); //리퀘
		urlBuilder.append("&" + URLEncoder.encode("crs","UTF-8") + "=" + URLEncoder.encode("EPSG:4326", "UTF-8"));

		// 3. URL 객체 생성.
		URL url = new URL(urlBuilder.toString());
		// 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성.
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 5. 통신을 위한 메소드 SET.
		conn.setRequestMethod("GET");
		// 6. 통신을 위한 Content-type SET.
		conn.setRequestProperty("Content-type", "application/json");
		// 7. 통신 응답 코드 확인.
		System.out.println("Response code: " + conn.getResponseCode());
		// 8. 전달받은 데이터를 BufferedReader 객체로 저장.
		BufferedReader rd;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		// 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장.
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		// 10. 객체 해제.
		rd.close();
		conn.disconnect();
		// 11. 전달받은 데이터 확인.
		//System.out.println(sb.toString());

		/*JSONParser parser = new JSONParser();
		JSONObject object = (JSONObject) parser.parse(sb.toString());
		JSONObject repn = (JSONObject) object.get("response");
		JSONObject result = (JSONObject) repn.get("result");
		JSONArray items = (JSONArray) result.get("items");*/

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json");
		response.getWriter().write(sb.toString());

    }
	@RequestMapping(value="/vworldApi")
	public static String main(String[] args, Model model) throws IOException {
		return "vworldApiSampleApplicationJSON";
	}
}
