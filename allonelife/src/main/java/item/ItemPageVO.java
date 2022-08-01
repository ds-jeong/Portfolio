package item;

import java.util.List;

import org.springframework.stereotype.Component;

import common.PageVO;
@Component
public class ItemPageVO extends PageVO{
	private List<PointhVO> list;

	public List<PointhVO> getList() {
		return list;
	}

	public void setList(List<PointhVO> list) {
		this.list = list;
	}
	
	
}
