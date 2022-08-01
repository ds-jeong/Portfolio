package recipe;

import java.util.HashMap;
import java.util.List;

import exchange.GoodVO;
import item.PointhVO;
import member.MemberVO;

public interface RecipeService {
	//CRUD
		void recipe_insert(RecipeVO vo);
		RecipePageVO recipe_list(RecipePageVO page);
		RecipeVO recipe_detail(int id);
		void recipe_read(int id);
		void recipe_update(RecipeVO vo);
		void recipe_delete(int id);
		
		boolean recipe_comment_insert(HashMap<String, Object> map);
		
		List<RecipeCommentVO> recipe_comment_list(int pid);
		boolean recipe_comment_delete(int id);
		boolean recipe_comment_update(RecipeCommentVO vo);
		
		void recipe_good_insert(GoodVO vog);
		void recipe_good_update(RecipeVO vo);
		boolean recipe_good_select(GoodVO vog);

		void recipe_root_step_update(RecipeVO vo);
		void recipe_stepdown_update(RecipeVO vo);

		void recipe_point_update(MemberVO vo);
		void recipe_point_insert(PointhVO pvo);
		void recipe_pointm_update(MemberVO vo);
		void recipe_pointm_insert(PointhVO pvo);

}
