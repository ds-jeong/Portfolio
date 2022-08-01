package common;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.mail.Folder;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
@Service
public class CommonServiceImpl implements CommonService {

	public void emailSend(String name, String email, HttpServletRequest request) {
		//1. 기본형태 이메일전송
		//simpleSend(name, email);
		
		//2.파일첨부가능 이메일전송
		//attachSend(name, email, request);
		
		//3.HTML 태그형식의 이메일전송
		htmlSend(name, email, request);
	}
	
	private void htmlSend(String name, String email, HttpServletRequest request) {
		HtmlEmail mail = new HtmlEmail();
		try {
			setProperties(mail, name, email);
			mail.setSubject("ㅎㅇ");
			StringBuffer content
					= new StringBuffer("<html>");
			content.append("<body>");
			content.append("<h2>회원가입을 축하합니다.</h2>");
			content.append("<a href='http://hanuledu.co.kr'>한울과정보기</a>");
			content.append("스마트웹&앱 과정<br>");
			content.append("가입을축하합니다<br>");
			content.append("<input type='button' value='확인'"
					+ "onclick='alert(\"잘 되나\")' />");
			content.append("</body>");
			content.append("</html>");
			mail.setHtmlMsg(content.toString());
			
			EmailAttachment file = new EmailAttachment();
			file.setPath(request.getSession().getServletContext().getRealPath("resources/img/hanul.logo.png"));
			mail.attach(file);
			mail.send();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private void setProperties(Email mail, String name, String email) throws Exception{
		mail.setHostName("smtp.naver.com");
		mail.setCharset("utf-8");
		mail.setDebug(true);
		
		
		mail.setAuthentication("ektmf9405", "");
		mail.setSSLOnConnect(true);
		
		
		mail.setFrom("ektmf9405@naver.com","관리자");
		mail.addTo(email, name);
	}
	private void attachSend(String name, String email, HttpServletRequest request) {
		MultiPartEmail mail =  new MultiPartEmail();
		
		try {
			setProperties(mail, name, email);
			
			mail.setSubject("스마트 웹");
			mail.setMsg("하이");
			
			EmailAttachment file = new EmailAttachment();//첨부파일객체
			file.setPath(request.getSession()
					.getServletContext()
					.getRealPath("resources/img/hanul.png"));
			mail.attach(file);
			mail.send();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void simpleSend(String name, String email) {
		SimpleEmail mail =  new SimpleEmail();
		
		try {
			setProperties(mail, name, email);
			
			mail.setSubject("스마트 웹");
			mail.setMsg("하이");
			mail.send();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private String makeFolder(String category, String upload) {
		StringBuffer folder = new StringBuffer(upload);
		//D://Spring/.../smart/resources/upload/notice 까지 접근
		folder.append( File.separator + category);
		//D://Spring/.../smart/resources/upload/notice/2019 까지 접근
		Date now = new Date();
		folder.append(File.separator + new SimpleDateFormat("yyyy/MM/dd").format(now));
		//해당 폴더가 있는지 확인하여 없으면 폴더생성
		File dir = new File(folder.toString());
		if( ! dir.exists()) dir.mkdirs();
		return folder.toString();
	}
	
	@Override
	public String fileUpload(MultipartFile file, HttpSession ss, String category) {
		//업로드할 서버의 물리적 위치
		//D://Spring/.../smart/resources 까지 접근
		String resources= ss.getServletContext().getRealPath("resources");
		//D://Spring/.../smart/resources/upload 까지 접근
		String upload = resources + File.separator + "upload";
		
		String folder = makeFolder(category, upload);
		//랜덤한아이디
		//D://Spring/.../smart/resources/upload/2019/09/05 까지 접근
		String uuid= UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		try {
			//생성한 폴더에 업로드한 파일 저장하기
			file.transferTo( new File(folder, uuid) );			
		} catch (Exception e) {
		}
		
		//D://Spring/.../smart/resources/upload/2019/09/05/dd555_abc.txt 까지 접근
		return folder.substring(resources.length())
					+ File.separator + uuid;
	}

	@Override
	public File fileDownload(String name, String path, HttpSession ss, HttpServletResponse response) {
		// 다운로드할 파일생성
		File file = new File(ss.getServletContext().getRealPath("resources")
				+ File.separator + path);
		String mime = ss.getServletContext().getMimeType(name);
		if (mime == null) mime = "application/octet-stream";
		try {
			response.setContentType(mime);
			
			URLEncoder.encode(name, "utf-8");
			response.setHeader("content-disposition", "attachment; filename=" + name);
			ServletOutputStream out = response.getOutputStream();
			FileCopyUtils.copy(new FileInputStream(file), out);
			out.flush();
		} catch (Exception e) {
			
		}
		return file;
			
		}
}
