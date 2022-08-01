package kangwondo;

import java.util.HashMap;
import java.util.List;

public interface KangwondoService {
	//CRUD
			void kangwondo_insert(KangwondoVO vo);
			KangwondoPageVO kangwondo_list(KangwondoPageVO page);
			KangwondoVO kangwondo_detail(int no);
			void kangwondo_read(int no);
			void kangwondo_update(KangwondoVO vo);
			void kangwondo_delete(int no);
			
			boolean kangwondo_comment_insert(HashMap<String, Object> map);
			
			List<KangwondoCommentVO> kangwondo_comment_list(int pid);
			boolean kangwondo_comment_delete(int no);
			boolean kangwondo_comment_update(KangwondoCommentVO vo);
			
			void kangwondo_root_step_update(KangwondoVO vo);
			void kangwondo_stepdown_update(KangwondoVO vo);
			
		
}
