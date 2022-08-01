package customer_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerManagerServiceImpl implements CustomerManagerService {
	@Autowired private CustomerManagerDAO dao;
	
	@Override
	public void customer_manager_insert(CustomerManagerVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public CustomerManagerPageVO customer_manager_list(CustomerManagerPageVO page) {
		// TODO Auto-generated method stub
		return dao.customer_manager_list(page);
	}

	@Override
	public CustomerManagerVO customer_manager_detail(String id) {
		// TODO Auto-generated method stub
		return dao.customer_manager_detail(id);
	}

	@Override
	public void customer_manager_read(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void customer_manager_update(CustomerManagerVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void customer_manager_delete(String id) {
		dao.customer_manager_delete(id);

	}

}
