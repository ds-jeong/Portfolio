package common;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommonServiceImpl implements CommonService {

	@Override
	public void emailSend(String name, String email, HttpServletRequest request) {
		// 1.기본형태 이메일전송
		// simpleSend(name, email);

		// 2.파일첨부가능 이메일전송
		// attachSend(name, email, request);

		// 3.Html 태그형식의 이메일전송
		htmlSend(name, email, request);
	}

	private void htmlSend(String name, String email, HttpServletRequest request) {
		HtmlEmail mail = new HtmlEmail();
		try {
			setProperties(mail, name, email);
			mail.setSubject("얼라이프(Allone Life) 회원가입을 축하합니다.");

			StringBuffer content = new StringBuffer("<html>");
			content.append("<body>");
			content.append("<h2>얼라이프(Allone Life) 회원가입을 축하합니다</h2>");
			content.append("회원가입기념으로 500얼을 지급하였습니다. 좋은 활동과 많은 정보를 얻어가세요.<br>");
			content.append("</body>");
			content.append("</html>");
			mail.setHtmlMsg(content.toString());

			/*
			 * EmailAttachment file = new EmailAttachment(); file.setPath(
			 * request.getSession() .getServletContext()
			 * .getRealPath("resources/images/hanul.logo.png")); mail.attach(file);
			 */
			mail.send();

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	@Override
	public void itemsend(String name, String email, HttpServletRequest request, int itemid) {
		itemsSends(name, email, request, itemid);
	}

	private void itemsSends(String name, String email, HttpServletRequest request, int itemid) {
		HtmlEmail mail = new HtmlEmail();
		String item_name = "";
		if (itemid == 1) {
			item_name = "문화상품권";
		} else if (itemid == 2) {
			item_name = "요기요 3,000원 할인쿠폰";
		} else if (itemid == 3) {
			item_name = "CGV 30% 할인쿠폰";
		} else if (itemid == 7) {
			item_name = "스타벅스 아이스 아메리카노 교환권";
		} else if (itemid == 8) {
			item_name = "베스킨라빈스 파인트 교환권";
		} else if (itemid == 9) {
			item_name = "CU 모바일 상품권";
		}
		try {
			setProperties(mail, name, email);
			mail.setSubject("신청하신 상품 '" + item_name + "'을 보내드립니다");

			StringBuffer content = new StringBuffer("<html>");
			content.append("<body>");
			content.append("<h2>얼라이프(Allone Life)에서 신청하신 상품을 보내드립니다.</h2>");
			content.append("신청하신 상품을 보내드립니다. 많은 이용 감사드립니다.<br>");
			content.append("</body>");
			content.append("</html>");
			mail.setHtmlMsg(content.toString());

			EmailAttachment file = new EmailAttachment();
			if (itemid == 1) {
				file.setPath(request.getSession().getServletContext().getRealPath("resources/images/culture.jpg"));
				mail.attach(file);
			} else if (itemid == 2) {
				file.setPath(request.getSession().getServletContext().getRealPath("resources/images/yogiyo.jpg"));
				mail.attach(file);
			}else if (itemid == 3) {
				file.setPath(request.getSession().getServletContext().getRealPath("resources/images/cgv.PNG"));
				mail.attach(file);
			}else if (itemid == 7) {
				file.setPath(request.getSession().getServletContext().getRealPath("resources/images/starbucks1.jpg"));
				mail.attach(file);
			}else if (itemid == 8) {
				file.setPath(request.getSession().getServletContext().getRealPath("resources/images/beskin.jpg"));
				mail.attach(file);
			}else if (itemid == 9) {
				file.setPath(request.getSession().getServletContext().getRealPath("resources/images/cu1.jpg"));
				mail.attach(file);
			}
			mail.send();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private void setProperties(Email mail, String name, String email) throws Exception {
		mail.setHostName("smtp.naver.com");
		mail.setCharset("utf-8");
		mail.setAuthentication("taiyaki9999", "wwwwwwwwww");
		mail.setSSLOnConnect(true);

		mail.setFrom("taiyaki9999@naver.com", "얼라이프");
		mail.addTo(email, name);
	}

	/*
	 * private void attachSend(String name, String email, HttpServletRequest
	 * request) { MultiPartEmail mail = new MultiPartEmail();
	 * 
	 * try { setProperties(mail, name, email);
	 * 
	 * mail.setSubject("스마트 웹&앱 파일첨부 확인 요망");
	 * mail.setMsg("회원가입을 축하하며 첨부된 파일을 확인해주세요");
	 * 
	 * EmailAttachment file = new EmailAttachment(); file.setPath(
	 * request.getSession() .getServletContext()
	 * .getRealPath("resources/images/hanul.png")); mail.attach(file); mail.send();
	 * }catch(Exception e) { System.out.println(e.getMessage()); } }
	 * 
	 * private void simpleSend(String name, String email) { SimpleEmail mail = new
	 * SimpleEmail(); try { setProperties(mail, name, email);
	 * mail.setSubject("스마트 웹&앱 개발자과정 참여자"); mail.setMsg("회원가입을 축하합니다!");
	 * mail.send();
	 * 
	 * }catch(Exception e) { System.out.println(e.getMessage()); } }
	 */

	private String makeFolder(String category, String upload) {
		StringBuffer folder = new StringBuffer(upload);
		// D://..../upload/notice
		folder.append("/" + category);
		Date now = new Date();
		// D://..../upload/notice/2019/09/05
		folder.append("/" + new SimpleDateFormat("yyyy/MM/dd").format(now));
		// 해당 폴더가 있는지 확인하여 없으면 폴더생성
		File dir = new File(folder.toString());
		if (!dir.exists())
			dir.mkdirs();
		return folder.toString();
	}

	@Override
	public String fileUpload(MultipartFile file, HttpSession ss, String category) {

		// 업로드할 서버의 물리적 위치
		// D://Spring/..../smart/resources
		String resources = ss.getServletContext().getRealPath("resources");
		// D://Spring/..../smart/resources/upload
		String upload = resources + "/" + "upload";
		// D://Spring/...ources/upload/notice/2019/09/05
		String folder = makeFolder(category, upload);
		String uuid = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

		try {
			// 생성한 폴더에 업로드한 파일 저장하기
			file.transferTo(new File(folder, uuid));

		} catch (Exception e) {
		}
		// /upload/notice/2019/09/05/ff58523_abc.txt
		return "http://112.164.58.12:80/allonelife/resources" + folder.substring(resources.length()) + "/" + uuid;
		//return "http://112.164.58.12:80" + folder.substring(resources.length()) + "/" + uuid;
	}

	@Override
	public File fileDownload(String name, String path, HttpSession ss, HttpServletResponse response) {
		// 다운로드할 파일생성
		File file = new File(ss.getServletContext().getRealPath("resources") + "/" + path);
		String mime = ss.getServletContext().getMimeType(name);
		if (mime == null)
			mime = "application/octet-stream";

		try {
			response.setContentType(mime);

			name = URLEncoder.encode(name, "utf-8");
			response.setHeader("content-disposition", "attachment; filename=" + name);
			ServletOutputStream out = response.getOutputStream();
			FileCopyUtils.copy(new FileInputStream(file), out);
			out.flush();
		} catch (Exception e) {
		}
		return file;
	}

}
