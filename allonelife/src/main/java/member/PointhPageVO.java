package member;

import java.util.List;

import org.springframework.stereotype.Component;

import common.PageVO;
import item.PointhVO;

@Component
public class PointhPageVO extends PageVO {
private List<PointhVO> list;
private String userid;
	
	public List<PointhVO> getList(){
		return list;
	}
	
	public void setList(List<PointhVO> list) {
		this.list = list;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
		
}
