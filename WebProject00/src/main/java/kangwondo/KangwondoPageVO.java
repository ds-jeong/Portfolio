package kangwondo;

import java.util.List;

import org.springframework.stereotype.Component;

import common.PageVO;
@Component
public class KangwondoPageVO extends PageVO{
private List<KangwondoVO> list;
	
	public List<KangwondoVO> getList(){
		return list;
	}
	
	public void setList(List<KangwondoVO> list) {
		this.list = list;
	}

}
