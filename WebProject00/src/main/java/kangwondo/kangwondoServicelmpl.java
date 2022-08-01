package kangwondo;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class kangwondoServicelmpl implements KangwondoService {
	@Autowired private KangwondoDAO dao;
	@Override
	public void kangwondo_insert(KangwondoVO vo) {
		// TODO Auto-generated method stub
		dao.kangwondo_insert(vo);
	}

	@Override
	public KangwondoPageVO kangwondo_list(KangwondoPageVO page) {
		// TODO Auto-generated method stub
		return dao.kangwondo_list(page);
	}

	@Override
	public KangwondoVO kangwondo_detail(int no) {
		// TODO Auto-generated method stub
		return dao.kangwondo_detail(no);
	}

	@Override
	public void kangwondo_read(int no) {
		// TODO Auto-generated method stub
		dao.kangwondo_read(no);
	}

	@Override
	public void kangwondo_update(KangwondoVO vo) {
		// TODO Auto-generated method stub
		dao.kangwondo_update(vo);
	}

	@Override
	public void kangwondo_delete(int no) {
		// TODO Auto-generated method stub
		dao.kangwondo_delete(no);
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
