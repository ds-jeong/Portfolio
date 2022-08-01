package kangwondo;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class KangwondoDAO implements KangwondoService {
	
	@Autowired @Qualifier("allonelife") private SqlSession sql;
	
	@Override
	public void kangwondo_insert(KangwondoVO vo) {
		// TODO Auto-generated method stub
		sql.insert("kangwondo.mapper.insert", vo);
	}

	@Override
	public KangwondoPageVO kangwondo_list(KangwondoPageVO page) {
		page.setTotalList(
				(Integer)sql.selectOne(
						"kangwondo.mapper.totalCount", page) );
			List<KangwondoVO> list 
				= sql.selectList("kangwondo.mapper.list", page);
			page.setList(list);
			return page;
	}

	@Override
	public KangwondoVO kangwondo_detail(int no) {
		// TODO Auto-generated method stub
		return sql.selectOne("kangwondo.mapper.detail", no);
	}

	@Override
	public void kangwondo_read(int no) {
		// TODO Auto-generated method stub
		sql.update("kangwondo.mapper.read", no);
	}

	@Override
	public void kangwondo_update(KangwondoVO vo) {
		// TODO Auto-generated method stub
		sql.update("kangwondo.mapper.update", vo);
	}

	@Override
	public void kangwondo_delete(int no) {
		// TODO Auto-generated method stub
		sql.delete("kangwondo.mapper.delete", no);
	}

	@Override
	public boolean kangwondo_comment_insert(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<KangwondoCommentVO> kangwondo_comment_list(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean kangwondo_comment_delete(int no) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean kangwondo_comment_update(KangwondoCommentVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void kangwondo_root_step_update(KangwondoVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void kangwondo_stepdown_update(KangwondoVO vo) {
		// TODO Auto-generated method stub

	}

}
