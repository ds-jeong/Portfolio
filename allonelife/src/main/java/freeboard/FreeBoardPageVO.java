package freeboard;

import java.util.List;

import org.springframework.stereotype.Component;

import common.PageVO;
@Component
public class FreeBoardPageVO extends PageVO{
	private List<FreeBoardVO> list;

	public List<FreeBoardVO> getList() {
		return list;
	}

	public void setList(List<FreeBoardVO> list) {
		this.list = list;
	}
	
	
}
