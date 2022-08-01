package customer_manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import freeboard.FreeBoardVO;

@Repository
public class CustomerManagerDAO implements CustomerManagerService {

	@Override
	public void customer_manager_insert(CustomerManagerVO vo) {
		// TODO Auto-generated method stub

	}
	@Autowired @Qualifier("allonelife") private SqlSession sql;
	@Override
	public CustomerManagerPageVO customer_manager_list(CustomerManagerPageVO page) {
		
		page.setTotalList((Integer)sql.selectOne("customermanager.mapper.totalCount", page));
		List<CustomerManagerVO> list =sql.selectList("customermanager.mapper.list", page);
		page.setList(list);
		return page;
		
	}

	@Override
	public CustomerManagerVO customer_manager_detail(String id) {
		return sql.selectOne("customermanager.mapper.detail", id);
	}

	@Override
	public void customer_manager_read(String id) {

	}

	@Override
	public void customer_manager_update(CustomerManagerVO vo) {

	}

	@Override
	public void customer_manager_delete(String id) {
		sql.delete("customermanager.mapper.delete", id);	
	}

}
