package mainfamous;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MainFamousDAO implements MainFamousService{
	
	@Autowired @Qualifier("allonelife") private SqlSession sql;

	@Override
	public List<MainFamousVO> recipe_famous_list() {
		return sql.selectList(
				"mainfamous.mapper.recipelist");
	}

	@Override
	public List<MainFamousVO> exchange_famous_list() {
		return sql.selectList(
				"mainfamous.mapper.exchangelist");
	}

	@Override
	public List<MainFamousVO> tip_famous_list() {
		return sql.selectList(
				"mainfamous.mapper.tiplist");
	}

	@Override
	public List<MainFamousVO> board_famous_list() {
		return sql.selectList(
				"mainfamous.mapper.boardlist");
	}

	@Override
	public List<MainFamousVO> notice_new_list() {
		return sql.selectList(
				"mainfamous.mapper.noticelist");
	}

}
