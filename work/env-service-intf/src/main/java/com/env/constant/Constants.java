package com.env.constant;

public class Constants {

	/**
	 * 登陆用户，存入session中的KEY
	 */
	public static final String SESSION_LOGINUSER = "SESSION_LOGINUSER";

	public static final String REDIRECT_URL = "redirectUrl";
	
	/**
	 * 登陆用户名不存在
	 */
	public static final String USERNAME_EXISTED="USERNAME_EXISTED";
	/**
	 * 登陆密码错误
	 */
	public static final String PASSWORD_ERROR="PASSWORD_ERROR";
	
	/**
	 * 用户名不符合规则
	 */
	public static final String USERNAME_RULE_ERROR = "USERNAME_RULE_ERROR";
	/**
	 * 密码不符合规则
	 */
	public static final String PASSWORD_RULE_ERROR = "PASSWORD_RULE_ERROR";
	/**
	 * 用户名或密码错误
	 */
	public static final String USERNAME_OR_PWD_ERROR = "USERNAME_OR_PWD_ERROR";

	/**
	 *  同一家公司每天发布需求的次数 2
	 */
	public static final int REQ_RELEASE_DAY_COMPANY_COUNT = 2;
	/**
	 *  同一家公司每月发布需求的次数 6
	 */
	public static final int REQ_RELEASE_MONTH_COMPANY_COUNT = 6;

	/**
	 *  每天发布需求的公司数 3
	 */
	public static final int REQ_RELEASE_DAY_COMPANY_COUNT_2 = 3;
	/**
	 *  每月发布需求的公司数 10
	 */
	public static final int REQ_RELEASE_MONTH_COMPANY_COUNT_2 = 10;
	
}
