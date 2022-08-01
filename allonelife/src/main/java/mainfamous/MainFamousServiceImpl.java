package mainfamous;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainFamousServiceImpl implements MainFamousService {
	
	@Autowired private MainFamousDAO dao;
	
	@Override
	public List<MainFamousVO> recipe_famous_list() {
		return dao.recipe_famous_list();
	}

	@Override
	public List<MainFamousVO> exchange_famous_list() {
		return dao.exchange_famous_list();
	}

	@Override
	public List<MainFamousVO> tip_famous_list() {
		return dao.tip_famous_list();
	}

	@Override
	public List<MainFamousVO> board_famous_list() {
		return dao.board_famous_list();
	}

	@Override
	public List<MainFamousVO> notice_new_list() {
		return dao.notice_new_list();
	}

}
