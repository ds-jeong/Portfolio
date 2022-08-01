package common;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public interface CommonService {
	void emailSend(String name, String email, HttpServletRequest request);
	
	String fileUpload(MultipartFile file, HttpSession session, String category);
	
	File fileDownload(String name, String path, HttpSession session, HttpServletResponse response);

	void itemsend(String name, String email, HttpServletRequest request, int itemid);
	
	
}
