package org.jds.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.LoggerFactory;

public class OracleConnectionTest {
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(OracleConnectionTest.class);
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@ 192.168.219.103:1521:orcl";
	private static final String USER = "jds";
	private static final String PW = "jds";

	@Test //JUnit이 테스트하는 코드
	public void testConnection() throws Exception {
	        Class.forName(DRIVER);
	        try(Connection conn= DriverManager.getConnection(URL, USER, PW)) {
	                Logger.info("오라클에 연결되었습니다.");
	        }catch(Exception e) {
	                e.printStackTrace();
	        }
	}
}
