package recipe;

import java.util.List;

import org.springframework.stereotype.Component;

import common.PageVO;

@Component
public class RecipePageVO extends PageVO{
	private List<RecipeVO> list;
	
	public List<RecipeVO> getList(){
		return list;
	}
	
	public void setList(List<RecipeVO> list) {
		this.list = list;
	}

}
