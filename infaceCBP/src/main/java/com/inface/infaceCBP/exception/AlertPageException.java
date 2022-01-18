package com.inface.infaceCBP.exception;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
public class AlertPageException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Throwable cause; // 지정하면 에러로그를 기록함.

	@NonNull // 필수입력
	private String alertMsg;

	private String redirectUrl;
	private boolean historyBack;

	private boolean selfClose;
	private boolean selfReload;
	private boolean parentReload;

}