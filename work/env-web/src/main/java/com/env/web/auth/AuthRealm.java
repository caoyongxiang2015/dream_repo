package com.env.web.auth;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.env.commons.utils.StringUtils;
import com.env.constant.Constants;
import com.env.dto.PtPermission;
import com.env.dto.PtRole;
import com.env.dto.PtUser;
import com.env.service.PtRoleService;
import com.env.service.PtUserService;

public class AuthRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthRealm.class);
    
	@Autowired
	private PtUserService<PtUser> ptUserService;
	
	@Autowired
	private PtRoleService<PtRole> ptRoleService;

	/**
	 * 为当前登录的Subject授予角色和权限
	 * 
	 * @see 经测试:本例中该方法的调用时机为需授权资源被访问时
	 * @see 经测试:并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache
	 * @see 个人感觉若使用了Spring3
	 *      .1开始提供的ConcurrentMapCache支持,则可灵活决定是否启用AuthorizationCache
	 * @see 比如说这里从数据库获取权限信息时,先去访问Spring3.1提供的缓存,而不使用Shior提供的AuthorizationCache
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {

		// 获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()
		String loginId = (String) super.getAvailablePrincipal(principals);

		List<String> rolecodeList = new ArrayList<String>();
		List<String> permissioncodeList = new ArrayList<String>();
		List<String> permissionresourceList = new ArrayList<String>();

		// 从数据库中获取当前登录用户的详细信息
		PtUser user = ptUserService.getByLoginid(loginId);
		
		if (null != user) {

			// 获取当前登录用户的角色列表(含permission)
			List<PtRole> roles = ptRoleService.getByUserid(user.getId());
			
			// User中包含角色信息
			if (null != roles && roles.size() > 0) {
				// 获取当前登录用户的角色
				for (PtRole role : roles) {
					rolecodeList.add(role.getRoleCode());
					
					// 实体类Role中包含有角色权限的实体类信息
					if (null != role.getPtPermissions()
							&& role.getPtPermissions().size() > 0) {
						// 获取权限
						for (PtPermission pmss : role.getPtPermissions()) {
							if (!StringUtils.isEmpty(pmss.getPermissionCode())) {
								permissioncodeList.add(pmss.getPermissionCode());
								permissionresourceList.add(pmss.getResource());
							}
						}
					}
				}
			}
		} else {
			throw new AuthorizationException();
		}

		// 为当前用户设置角色和权限
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
		simpleAuthorInfo.addRoles(rolecodeList);
		simpleAuthorInfo.addStringPermissions(permissioncodeList);
		simpleAuthorInfo.addStringPermissions(permissionresourceList);
		
		if (rolecodeList.size() < 1 && permissioncodeList.size() < 1) {
			return null;// 未授权，跳转到unauthorizedUrl指定的地址
		} else {
			return simpleAuthorInfo;
		}

	}

	/**
	 * 验证当前登录的Subject
	 * 
	 * @see 经测试:本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		// 获取基于用户名和密码的令牌
		// 实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
		// 两个token的引用都是一样的,本例中是org.apache.shiro.authc.UsernamePasswordToken@33799a1e

		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		LOGGER.debug("验证当前Subject时获取到token为"
				+ ReflectionToStringBuilder.toString(token,
						ToStringStyle.MULTI_LINE_STYLE));
		PtUser user = ptUserService.loginUser(token.getUsername(),String.valueOf(token.getPassword()));
		if (null != user) {
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
					user.getLoginId(), user.getPwd(), this.getName());
			this.setSession(Constants.SESSION_LOGINUSER, user);
			return authcInfo;
		} else {
			// 返回null，就会在AuthLoginController中抛出UnknownAccountException异常
			return null;
		}
		
	}

	/**
	 * 将一些数据放到ShiroSession中,以便于其它地方使用
	 * 
	 * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
	 */
	private void setSession(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			System.out
					.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}

}
