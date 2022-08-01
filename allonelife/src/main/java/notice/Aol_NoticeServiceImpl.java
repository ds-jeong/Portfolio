package notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Aol_NoticeServiceImpl implements Aol_NoticeService {

	@Override
	public void notice_insert(Aol_NoticeVO vo) {
		dao.notice_insert(vo);
	}
	
	@Autowired private Aol_NoticeDAO dao;

	@Override
	public Aol_NoticePageVO notice_list(Aol_NoticePageVO page) {
		return dao.notice_list(page);
	}

	@Override
	public Aol_NoticeVO notice_detail(int id) {
		return dao.notice_detail(id);
	}

	@Override
	public void notice_read(int id) {
		dao.notice_read(id);
	}

	@Override
	public void notice_update(Aol_NoticeVO vo) {
		dao.notice_update(vo);
	}

	@Override
	public void notice_delete(int id) {
		dao.notice_delete(id);
	}

}
