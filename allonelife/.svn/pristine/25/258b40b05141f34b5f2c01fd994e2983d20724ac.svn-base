package recipe;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import exchange.GoodVO;
import item.PointhVO;
import member.MemberVO;

@Repository
public class RecipeDAO implements RecipeService {
	
	@Autowired @Qualifier("allonelife") private SqlSession sql;

	@Override
	public void recipe_pointm_update(MemberVO vo) {
		sql.update("recipe.mapper.point_item_update", vo);		
	}
	
	@Override
	public void recipe_pointm_insert(PointhVO pvo) {
		sql.insert("recipe.mapper.item_insert", pvo);
	}
	
	@Override
	public void recipe_point_update(MemberVO vo) {
		sql.update("recipe.mapper.point_itemone_update", vo);		
	}
	
	@Override
	public void recipe_point_insert(PointhVO pvo) {
		sql.insert("recipe.mapper.itemone_insert", pvo);
	}
	
	@Override
	public void recipe_good_update(RecipeVO vo) {
		sql.update("recipe.mapper.good_update", vo);
	}
	@Override
	public boolean recipe_good_select(GoodVO vog) {
		return (Integer) sql.selectOne("recipe.mapper.select_good", vog) == 1 ? false : true;
	}
	@Override
	public void recipe_good_insert(GoodVO vog) {
		sql.insert("recipe.mapper.good_insert", vog);
	}
	
	@Override
	public void recipe_insert(RecipeVO vo) {
		sql.insert("recipe.mapper.insert", vo);
	}

	@Override
	public RecipePageVO recipe_list(RecipePageVO page) {
		page.setTotalList(
			(Integer)sql.selectOne(
					"recipe.mapper.totalCount", page) );
		List<RecipeVO> list 
			= sql.selectList("recipe.mapper.list", page);
		page.setList(list);
		return page;
	}

	@Override
	public RecipeVO recipe_detail(int id) {
		return sql.selectOne("recipe.mapper.detail", id);
	}

	@Override
	public void recipe_read(int id) {
		sql.update("recipe.mapper.read", id);
	}

	@Override
	public void recipe_update(RecipeVO vo) {
		sql.update("recipe.mapper.update", vo);
	}

	@Override
	public void recipe_delete(int id) {
		sql.delete("recipe.mapper.delete", id);
	}

	@Override
	public boolean recipe_comment_insert(HashMap<String, Object> map) {
		return sql.insert("recipe.mapper.comment_insert", map) > 0 ? true : false;
	}

	@Override
	public List<RecipeCommentVO> recipe_comment_list(int pid) {
		return sql.selectList("recipe.mapper.comment_list", pid);
	}

	@Override
	public boolean recipe_comment_delete(int id) {
		return sql.delete("recipe.mapper.comment_delete", id)>0 ? true : false;
	}

	@Override
	public boolean recipe_comment_update(RecipeCommentVO vo) {
		return sql.update("recipe.mapper.comment_update", vo)>0 ? true : false;
	}
	@Override
	public void recipe_root_step_update(RecipeVO vo) {
		sql.update("recipe.mapper.root_step_update", vo);
	}
	@Override
	public void recipe_stepdown_update(RecipeVO vo) {
		sql.update("recipe.mapper.stepdown_update", vo);
	}

}
