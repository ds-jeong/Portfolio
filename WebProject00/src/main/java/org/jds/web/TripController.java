package org.jds.web;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import data.DataService;

@Controller
public class TripController {
	
	
	private String kangwondo_real_url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService";

	private String kangwondo_url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword";
	private String serviceKeyc="tdNSFiFpBow9sGQluLaFCSjo%2B2Aav2hbJarqu5lLJ5Gr1TR06u0kdPYzj%2BUZ0iwjq%2BYfxvIhJzD%2FMknbtO8LEQ%3D%3D";
	
	
	
	
	@Autowired private DataService service;
	//관광지리스트
			@ResponseBody @RequestMapping("/data/trip/detail")
			public ArrayList<HashMap<String, Object>> 
				trip_detail(String contentid) {
				StringBuilder url = new StringBuilder(kangwondo_real_url + "/detailCommon");
				url.append("?serviceKey=" + serviceKeyc);
				url.append("&numOfRows=10");
				url.append("&pageNo=1");
				url.append("&MobileOS=ETC");
				url.append("&MobileApp=AppTest");
				url.append("&contentId="+contentid);
				url.append("&defaultYN=Y");
				url.append("&firstImageYN=Y");
				url.append("&areacodeYN=Y");
				url.append("&catcodeYN=Y");
				url.append("&addrinfoYN=Y");
				url.append("&mapinfoYN=Y");
				url.append("&overviewYN=Y");
				url.append("&contentTypeId=12");
			
				url.append("&_type=json");
				
				
				return service.json_list(url);
				
			}
	
	/*//강원도리스트
	@ResponseBody @RequestMapping(value="/data/kangwondo/detail", produces="application/text; charset=utf-8")
	public String kangwondo_detail() {
		StringBuilder url = new StringBuilder(kangwondo_real_url + "/detailCommon");
				url.append("?serviceKey=" + serviceKeyc);
				url.append("&numOfRows=10");
				url.append("&pageNo=1");
				url.append("&MobileOS=ETC");
				url.append("&MobileApp=AppTest");
				url.append("&contentId=126510");
				url.append("&defaultYN=Y");
				url.append("&firstImageYN=Y");
				url.append("&areacodeYN=Y");
				url.append("&catcodeYN=Y");
				url.append("&addrinfoYN=Y");
				url.append("&mapinfoYN=Y");
				url.append("&overviewYN=Y");
				url.append("&contentTypeId=12");
			
						
				return service.xml_list(url);
			}
	
	*/
	//관광지리스트
		@ResponseBody @RequestMapping("/data/trip/list")
		public ArrayList<HashMap<String, Object>> 
			kangwondo_list(@RequestBody HashMap<String, Object> map) {
			StringBuilder url = new StringBuilder(kangwondo_real_url + "/areaBasedList");
			url.append("?ServiceKey=" + serviceKeyc);
			url.append("&numOfRows=10");
			url.append("&pageNo=1");
			url.append("&MobileOS=ETC");
			url.append("&MobileApp=AppTest");
			url.append("&arrange=A");
			url.append("&contentTypeId=12");
			url.append("&listYN=Y");
			url.append("&areaCode="+map.get("sido"));
			url.append("&sigunguCode="+map.get("sigungu"));
			url.append("&_type=json");
			
			
			return service.json_list(url);
			
		}
	// 시군구
		@ResponseBody @RequestMapping("/data/trip/sigungu")
		public ArrayList<HashMap<String, Object>> kangwondo_sigungu(String sido) {
			StringBuilder url = new StringBuilder(kangwondo_real_url + "/areaCode");
			url.append("?ServiceKey=" + serviceKeyc);
			url.append("&areaCode="+sido );
			url.append("&numOfRows=10");
			url.append("&pageNo=1");
			url.append("&MobileOS=ETC");
			url.append("&MobileApp=AppTest");
			url.append("&_type=json");
			
			return service.json_list(url);
		}
		
	
	//시도
		@ResponseBody @RequestMapping(value="data/trip/sido", produces="application/text; charset=utf-8")
		public String kangwondo_sido() {
			StringBuilder url = new StringBuilder(kangwondo_real_url + "/areaCode");
			url.append("?serviceKey=" + serviceKeyc);
			url.append("&numOfRows=20");
			url.append("&MobileOS=ETC");
			url.append("&MobileApp=AppTest");
			
			return service.xml_list(url);
		}
	
	//강원도리스트
		@ResponseBody @RequestMapping(value="/data/kangwondo", produces="application/text; charset=utf-8")
		public String car_list() {
				StringBuilder url = new StringBuilder(kangwondo_url);
					url.append("?serviceKey=" + serviceKeyc);
					url.append("&numOfRows=10");
					url.append("&pageNo=1");
					url.append("&MobileOS=ETC");
					url.append("&MobileApp=AppTest");
					url.append("&listYN=Y&arrange=A");
					url.append("&keyword=%EA%B0%95%EC%9B%90");
					
				
							
					return service.xml_list(url);
				}
	
	//占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 화占쏙옙占시�
		@RequestMapping("/list.tr")
		public String listapi() {
			return "data/trip";
		}
	
}

