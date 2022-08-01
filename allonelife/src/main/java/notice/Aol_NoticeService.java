package notice;

public interface Aol_NoticeService {
	void notice_insert(Aol_NoticeVO vo);
	Aol_NoticePageVO notice_list(Aol_NoticePageVO page);
	Aol_NoticeVO notice_detail(int id);
	void notice_read(int id);
	void notice_update(Aol_NoticeVO vo);
	void notice_delete(int id);
}
