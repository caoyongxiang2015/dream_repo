package com.env.commons.utils;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;

/**
 * 用户工具<br>
 * 登录后可用该工具获取登陆者相关信息
 */
public class UserUtils {

	/**
	 * 获取当前登录用户对象
	 * 
	 * @return 当前登录人PtUser对象，null if not login
	 */
	public static Object getCurrentUser() {
		if (null != SecurityUtils.getSubject()) {
			// "SESSION_LOGINUSER" 与 Constants中的常量SESSION_LOGINUSER保持一致
			return SecurityUtils.getSubject().getSession()
					.getAttribute("SESSION_LOGINUSER");
		}
		return null;
	}

	/**
	 * 获取当前登录人IP
	 * 
	 * @return 当前登录人IP，null if not login
	 */
	public static String getCurrentUserIp() {
		Map<String, Object> userAttributes = getUserAttributes();
		if (null != userAttributes) {
			Object obj = userAttributes.get("ip");
			if (obj != null) {
				return obj.toString();
			}
		}
		return null;
	}

	/**
	 * 获取登录用户登录类型
	 * 
	 * @return 登录类型
	 */
	public static Integer getLoginType() {
		if (getUserAttributes() != null) {
			return Integer.parseInt(getUserAttributes().get("loginType")
					.toString());
		}
		return null;
	}

	/**
	 * 获取登录用户的登录名
	 * 
	 * @return 登录名
	 */
	public static String getAccount() {
		if (getUserAttributes() != null) {
			return getUserAttributes().get("account").toString();
		}
		return null;
	}

	/**
	 * 获取登录用户的登录ID
	 * 
	 * @return 登录ID
	 */
	public static Integer getLoginId() {
		if (getUserAttributes() != null) {
			Object obj = getUserAttributes().get("loginId");
			if (obj != null) {
				return Integer.parseInt(obj.toString());
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * 获取登录用户的职员ID
	 * 
	 * @return 职员ID
	 */
	public static Integer getEmployeeId() {
		Map<String, Object> userAttributes = getUserAttributes();
		if (null == userAttributes) {
			return null;
		} else {
			Object obj = userAttributes.get("employeeId");
			if (null == obj) {
				return null;
			} else {
				return Integer.parseInt(obj.toString());
			}
		}
	}

	/**
	 * 获取用户属性
	 * 
	 * @return 用户属性集合
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getUserAttributes() {
		if (null != SecurityUtils.getSubject()
				&& null != SecurityUtils.getSubject().getPrincipals()) {
			return SecurityUtils.getSubject().getPrincipals()
					.oneByType(Map.class);
		}
		return null;
	}

	/**
	 * 获取用户角色数组
	 * 
	 * @return 用户角色数组
	 */
	public static String[] getRoles() {
		return StringUtils
				.split((String) getUserAttributes().get("roles"), ",");
	}

	/**
	 * 获取用户权限数组
	 * 
	 * @return 用户权限数组
	 */
	public static String[] getPermissions() {
		return StringUtils.split((String) getUserAttributes()
				.get("permissions"), ",");
	}

	/**
	 * 获取用户是否具有指定权限
	 * 
	 * @param role
	 *            用于比对的权限
	 * @return 是否具有该权限<li>true--具有该权限<li>false--不具有该权限
	 */
	public static boolean hasRole(String role) {
		String[] roles = getRoles();
		if (roles != null) {
			for (String r : roles) {
				if (r.equalsIgnoreCase(role)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 获取用户登录时间
	 * 
	 * @return
	 */
	public static String getLoginTime() {
		if (getUserAttributes() != null) {
			Object obj = getUserAttributes().get("loginTime");
			if (obj != null) {
				return obj.toString();
			} else {
				return null;
			}
		}
		return null;
	}

}
