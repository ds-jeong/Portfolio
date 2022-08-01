package tip;

import java.util.List;

import org.springframework.stereotype.Component;

import common.PageVO;

@Component
public class TipPageVO extends PageVO{
	private List<TipVO> list;
	
	public List<TipVO> getList(){
		return list;
	}
	
	public void setList(List<TipVO> list) {
		this.list = list;
	}

}
