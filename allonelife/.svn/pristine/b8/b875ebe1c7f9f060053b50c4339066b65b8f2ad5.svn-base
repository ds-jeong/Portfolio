package notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class Aol_NoticeDAO implements Aol_NoticeService{

	@Override
	public void notice_insert(Aol_NoticeVO vo) {
		sql.insert("notice.mapper.insert", vo);
	}

	@Autowired @Qualifier("allonelife") private SqlSession sql;
	@Override
	public Aol_NoticePageVO notice_list(Aol_NoticePageVO page) {
		
		page.setTotalList((Integer)sql.selectOne("notice.mapper.totalCount", page));
		List<Aol_NoticeVO> list =sql.selectList("notice.mapper.list", page);
		page.setList(list);
		return page;
	}

	@Override
	public Aol_NoticeVO notice_detail(int id) {
		return sql.selectOne("notice.mapper.detail", id);
	}

	@Override
	public void notice_read(int id) {
		sql.update("notice.mapper.read1", id);
	}

	@Override
	public void notice_update(Aol_NoticeVO vo) {
		sql.update("notice.mapper.update", vo);
	}

	@Override
	public void notice_delete(int id) {
		sql.delete("notice.mapper.delete", id);
	}

}
