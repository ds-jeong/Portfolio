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
public class DataController {
	private String pharmacy_url="http://apis.data.go.kr/B551182/pharmacyInfoService/getParmacyBasisList";
	private String serviceKey="FPgj2NXbJw46TcGkmAfZEiYFDbxilys7KLjk3KaB7AfeJE00ZhPNM0M8unwbsI69fSmT8SNfVEimE6ZZ2U14hA%3D%3D";
	
	private String animal_url ="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc";
	
	private String kangwondo_real_url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService";

	private String kangwondo_url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword";
	private String serviceKeyc="tdNSFiFpBow9sGQluLaFCSjo%2B2Aav2hbJarqu5lLJ5Gr1TR06u0kdPYzj%2BUZ0iwjq%2BYfxvIhJzD%2FMknbtO8LEQ%3D%3D";
	
	
	
	
	@Autowired private DataService service;
	
	/*//占쏙옙占썩동占쏙옙 占쏙옙호占쏙옙 占쏙옙회 占쏙옙청
	@ResponseBody @RequestMapping("/data/animal/shelter")
	public ArrayList<HashMap<String, Object>> animal_shelter(String sido, String sigungu) {
		StringBuilder url = new StringBuilder(animal_url + "/shelter");
		url.append("?ServiceKey=" + serviceKey);
		url.append("&_type=json");
		url.append("&upr_cd="+sido);
		url.append("&org_cd="+sigungu);
		return service.json_list(url);
	}
	
	//占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙회占쏙옙청
	@ResponseBody @RequestMapping("/data/animal/list")
	public ArrayList<HashMap<String, Object>> 
		animal_list(@RequestBody HashMap<String, Object> map) {
		StringBuilder url = new StringBuilder(animal_url + "/abandonmentPublic");
		url.append("?ServiceKey=" + serviceKey);
		url.append("&_type=json");
		url.append("&upr_cd="+map.get("sido"));
		url.append("&org_cd="+map.get("sigungu"));
		url.append("&care_reg_no="+map.get("shelter"));
		url.append("&upkind="+map.get("upkind"));
		url.append("&kind="+map.get("kind"));
		return service.json_list(url);
	}
	//동물 종류
	@ResponseBody @RequestMapping("/data/animal/kind")
	public ArrayList<HashMap<String, Object>> animal_kind(String upkind){
		StringBuilder url = new StringBuilder(animal_url + "/kind");
		url.append("?ServiceKey=" + serviceKey);
		url.append("&_type=json");
		url.append("&up_kind_cd="+upkind);		
		return service.json_list(url);
	}
	//동물 시군구
	@ResponseBody @RequestMapping("/data/animal/sigungu")
	public ArrayList<HashMap<String, Object>> animal_sigungu(String sido) {
		StringBuilder url = new StringBuilder(animal_url + "/sigungu");
		url.append("?ServiceKey=" + serviceKey);
		url.append("&_type=json");
		url.append("&upr_cd="+sido);		
		return service.json_list(url);
	}
	
	//동물 시도
	@ResponseBody @RequestMapping(value="/data/animal/sido", produces="application/text; charset=utf-8")
	public String animal_sido() {
		StringBuilder url = new StringBuilder(animal_url + "/sido");
		url.append("?ServiceKey=" + serviceKey);
		return service.xml_list(url);
	}*/

	
	@RequestMapping("/list.da")
	public String list() {
		return "data/list";
	}
}

