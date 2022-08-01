package mainfamous;

import java.util.List;

public interface MainFamousService {
	//CRUD (Create/Read/Update/Delete)
	List<MainFamousVO> notice_new_list();
	List<MainFamousVO> recipe_famous_list();
	List<MainFamousVO> exchange_famous_list();
	List<MainFamousVO> tip_famous_list();
	List<MainFamousVO> board_famous_list();
}
