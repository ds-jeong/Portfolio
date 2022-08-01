package member;

import java.util.List;

import org.springframework.stereotype.Component;

import common.PageVO;

@Component
public class MyWritePageVO extends PageVO {
	private List<MyWriteVO> list;
	private String userid;
	
	public List<MyWriteVO> getList(){
		return list;
	}
	
	public void setList(List<MyWriteVO> list) {
		this.list = list;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
}
