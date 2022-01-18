package com.inface.infaceCBP.web;


import com.inface.infaceCBP.exception.AlertPageException;
import org.springframework.ui.Model;

public class BaseController {

	private static String ALERT_PAGE_VIEW = "common/error/alertPage";

	/**
	 * AlertPageException 객체를 활용한 리다이렉트 처리
	 *
	 * @param msg alert 메세지
	 * @param url redirect 경로
	 * @param model 요청한 controller 의 ui model
	 * @return
	 */
	protected String alertPageRedirect(String msg, String url, Model model) {
		// 리다이렉트의 경우는 절대경로로 설정한다.
		if (url != null && !url.startsWith("/")) {
			url = "/" + url;
		}
		Object ex = AlertPageException.builder()
				.alertMsg(msg)
				.redirectUrl(url)
				.build();
		model.addAttribute("exception", ex);

		return ALERT_PAGE_VIEW;
	}

}
