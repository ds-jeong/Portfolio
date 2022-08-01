package recipe;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exchange.GoodVO;
import item.PointhVO;
import member.MemberVO;

@Service
public class RecipeServiceImpl implements RecipeService {
	@Autowired private RecipeDAO dao;
	
	@Override
	public void recipe_pointm_update(MemberVO vo) {
		dao.recipe_pointm_update(vo);
	}
	
	@Override
	public void recipe_pointm_insert(PointhVO pvo) {
		dao.recipe_pointm_insert(pvo);
	}
	@Override
	public void recipe_point_update(MemberVO vo) {
		dao.recipe_point_update(vo);
	}
	
	@Override
	public void recipe_point_insert(PointhVO pvo) {
		dao.recipe_point_insert(pvo);
	}
	
	@Override
	public void recipe_good_update(RecipeVO vo) {
		dao.recipe_good_update(vo);
	}
	
	@Override
	public boolean recipe_good_select(GoodVO vog) {
		return dao.recipe_good_select(vog);
	}
	
	@Override
	public void recipe_good_insert(GoodVO vog) {
		dao.recipe_good_insert(vog);
	}
	@Override
	public void recipe_insert(RecipeVO vo) {
		dao.recipe_insert(vo);
	}

	@Override
	public RecipePageVO recipe_list(RecipePageVO page) {
		return dao.recipe_list(page);
	}

	@Override
	public RecipeVO recipe_detail(int id) {
		return dao.recipe_detail(id);
	}

	@Override
	public void recipe_read(int id) {
		dao.recipe_read(id);
	}

	@Override
	public void recipe_update(RecipeVO vo) {
		dao.recipe_update(vo);
	}

	@Override
	public void recipe_delete(int id) {
		dao.recipe_delete(id);
	}

	@Override
	public boolean recipe_comment_insert(HashMap<String, Object> map) {
		return dao.recipe_comment_insert(map);
	}

	@Override
	public List<RecipeCommentVO> recipe_comment_list(int pid) {
		return dao.recipe_comment_list(pid);
	}

	@Override
	public boolean recipe_comment_delete(int id) {
		return dao.recipe_comment_delete(id);
	}

	@Override
	public boolean recipe_comment_update(RecipeCommentVO vo) {
		return dao.recipe_comment_update(vo);
	}

	@Override
	public void recipe_root_step_update(RecipeVO vo) {
		dao.recipe_root_step_update(vo);
	}

	@Override
	public void recipe_stepdown_update(RecipeVO vo) {
		 dao.recipe_stepdown_update(vo);
	}	

}
