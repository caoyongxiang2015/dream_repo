/**
 * Description: PtUser控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-22 下午 23:26:51
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-22   caoyx   1.0         Initial
 */
package com.env.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.env.commons.utils.JsonUtils;
import com.env.commons.utils.RegExpValidatorUtils;
import com.env.commons.utils.StringUtils;
import com.env.constant.Constants;
import com.env.dao.api.Page;
import com.env.dao.api.QueryParams;
import com.env.dto.PtUser;
import com.env.service.intf.IPtUserService;
import com.env.util.D1SmsSender;
import com.env.util.MobileValidateCodeUtil;
import com.env.util.SmsSender;
import com.env.util.bean.MobileValidateCodeCheckResult;
import com.env.vo.PtUserVo;
import com.google.gson.Gson;


/**
 * PtUser控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/ptuser")
public class PtUserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PtUserController.class);

    @Autowired
//    private SmsSender smsSender;
	private D1SmsSender smsSender;
    
	/**
	 * 自动注入PtUser业务层实现
	 */
	@Autowired
	private IPtUserService ptUserService;

	/**
	 * 用户注册
	 * 注册成功后，弹出提示框‘恭喜您，注册成功，3秒后跳转到我的资料页面’；ajax请求
	 * @param ptUserVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "reg")
	public String reg (PtUserVo ptUserVo ){
		Integer id = -1;
		try{
			id = ptUserService.save(ptUserVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "";
	}

	/**
     * 
     * 功能描述: 获取手机验证码
     * 
     * @param session 会话
     * @return 展示视图
     */
	@ResponseBody
    @RequestMapping(value = "/register/getCode", method = RequestMethod.POST)
    public String getCode(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", false);
        map.put("message", "短信发送失败!");
        try {
            String phone = request.getParameter("phone");
            int type = Integer.parseInt(request.getParameter("type"));
            if (RegExpValidatorUtils.isPhone(phone)) {
                // 创建手机验证码（已放入session）
                String code = MobileValidateCodeUtil.setMobileValidateCode(session);
                StringBuffer content = new StringBuffer();
                switch (type) {
                    case 1:// 注册
                        content.append("您正在注册春宇金融会员，手机动态密码").append(code).append("，有效期120秒，客服电话4008-333-888");
                        break;
                    case 2:// 找回密码
                        content.append("您正在找回密码，手机动态密码").append(code).append("，有效期120秒，客服电话4008-333-888");
                        break;
                    case 3:// 修改手机号码
                        content.append("您正在修改手机号码，手机动态密码").append(code).append("，有效期120秒，客服电话4008-333-888");
                        break;
                    default:
                        break;
                }
                // 发送验证码
                if (smsSender.sendSms(phone, content.toString())) {
                    map.put("result", true);
                    map.put("message", "短信已发送!");
                }
            }
        } catch (Exception e) {
            LOGGER.error("getCode", e.getMessage());
            e.printStackTrace();
        }
        return new Gson().toJson(map);

    }
	

    /**
     * 前台用户注册操作
     * 
     * @param request
     * @return
     */
	@ResponseBody
    @RequestMapping(value = "/register/userRegister", method = RequestMethod.POST)
    public String userRegister(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Map<String, Object> map = checkRegisterAll(request, session);
        if (map.size() < 1) {
            String loginId = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            PtUser accountBean = new PtUser();
            accountBean.setLoginId(loginId);
            accountBean.setPwd(password);
            accountBean.setEmail(email);
            accountBean.setPhone(phone);
            if (ptUserService.userRegister(accountBean)) {
                map.put("redirect", "/index.htm"); // 返回视图
            } else {
                map.put("result", false);
                map.put("message", "注册失败");
            }
        }
        return new Gson().toJson(map);
    }
	

    /**
     * 注册时后台验证方法
     * 
     * @param request
     * @return
     */
    private Map<String, Object> checkRegisterAll(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String authCode = request.getParameter("authCode");
        if (StringUtils.isNotBlank(username)) {
            // 验证用户名格式
            if (RegExpValidatorUtils.isUserName(username)) {
                if (!ptUserService.isExistLoginid(username)) {
                    map.put("key", "username");
                    map.put("msg", "用户名已存在");
                    return map;
                }
            } else {
                map.put("key", "username");
                map.put("msg", "用户名为6-25位数字字母汉子组合");
                return map;
            }
        } else {
            map.put("key", "username");
            map.put("msg", "用户名为空");
            return map;
        }

        if (StringUtils.isNotBlank(password) && StringUtils.isNotBlank(newPassword)) {
            if (RegExpValidatorUtils.isPassWrod(password)) {
                if (RegExpValidatorUtils.isPassWrod(newPassword)) {
                    if (!newPassword.equals(password)) {
                        map.put("key", "newPassword");
                        map.put("msg", "两次输入密码不一致");
                        return map;
                    }
                } else {
                    map.put("key", "newPassword");
                    map.put("msg", "6-18位数字字母组合");
                    return map;
                }
            } else {
                map.put("key", "password");
                map.put("msg", "6-18位数字字母组合");
                return map;
            }
        } else {
            map.put("key", "password");
            map.put("msg", "密码为空");
            return map;
        }
        if (StringUtils.isNotBlank(email)) {
            if (RegExpValidatorUtils.isEmail(email)) {
                if (!ptUserService.checkEmail(email)) {
                    map.put("key", "email");
                    map.put("msg", "email已存在");
                    return map;
                }
            } else {
                map.put("key", "email");
                map.put("msg", "email格式不正确");
                return map;
            }
        } else {
            map.put("key", "email");
            map.put("msg", "email为空");
            return map;
        }
        if (StringUtils.isNotBlank(phone)) {
            if (RegExpValidatorUtils.isPhone(phone)) {
                if (!ptUserService.checkPhone(phone)) {
                    map.put("key", "phone");
                    map.put("msg", "手机号已存在");
                    return map;
                }
            } else {
                map.put("key", "phone");
                map.put("msg", "手机号码应为11位数字");
                return map;
            }
        } else {
            map.put("key", "phone");
            map.put("msg", "手机号为空");
            return map;
        }

        if (StringUtils.isNotBlank(authCode)) {
            MobileValidateCodeCheckResult result = MobileValidateCodeUtil.checkMobileValidateCode(session, authCode);
            if (!result.isCheckStatus()) {
                map.put("key", "authCode");
                map.put("msg", result.getCheckMessage());
                return map;
            }
        } else {
            map.put("key", "authCode");
            map.put("msg", "手机验证码为空");
            return map;
        }
        return map;
    }
	
	
	
	
	
	
	
	/**
	 * 去列表页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "list")
	public String list(Integer number , HttpServletRequest request){

        // 拿到所有的入参放到map里
        Map<String, Object> searchParams = new HashMap<String, Object>();//Servlets.getParametersStartingWith(request, null);
        
        Page page = new Page();
        
        if (null != number) {
            page.setCurrentPage(number);
            String pageSize = request.getParameter("pageSize");
            if(null != pageSize && !"".equals(pageSize)){
                page.setPageSize(Integer.parseInt(pageSize));
            }
        }
        
        QueryParams<PtUser> queryParams=new QueryParams<PtUser>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<PtUser> ptUserList = ptUserService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("ptUserList", ptUserList);

		return "ptuser/pages/list";
	}
	
	/**
	 * 去新增PtUser
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "ptuser/pages/add";
	}

	
	/**
	 * 新增PtUser
	 * 
	 * @param ptUserVo PtUser页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (PtUserVo ptUserVo ){
		Integer id = -1;
		try{
			id = ptUserService.save(ptUserVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptuser/detail/"+id;
	}

	/**
	 * 删除PtUser
	 * 
	 * @param id PtUser页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    ptUserService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptuser/list";
	}

	/**
	 * 去修改PtUser
	 * 
	 * @param id PtUser页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				PtUser ptUserEntity = (PtUser) ptUserService.getById(id);
				model.addAttribute("entity", ptUserEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "ptuser/pages/update";
	}

	@ResponseBody
	@RequestMapping(value = "modifypwd",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	public String modifypwd (HttpServletRequest request){
		String oldpwd = request.getParameter("oldpwd");
		String newpwd = request.getParameter("newpwd");
		String confirmpwd = request.getParameter("confirmpwd");
		
		PtUser user = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
		PtUser old = (PtUser) ptUserService.getById(user.getId());
		Map map = new HashMap();
		if(!oldpwd.equals(old.getPwd())){
			map.put("success", false);
			map.put("msg", "原始密码不正确");
			return JsonUtils.toJson(map);
		}
		if(!newpwd.equals(confirmpwd)){
			map.put("success", false);
			map.put("msg", "新密码与确认密码不一致");
			return JsonUtils.toJson(map);
		}
		old.setPwd(confirmpwd);
		ptUserService.update(old);
		
		map.put("success", true);
		map.put("msg", "修改成功");
		return JsonUtils.toJson(map);
	}
	
	/**
	 * 修改PtUser
	 * 
	 * @param ptUserVo PtUser页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (PtUserVo ptUserVo){
		try{
			ptUserService.update(ptUserVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptuser/detail/"+ ptUserVo.getEntity().getId();
	}


	/**
	 * 跳转到PtUser详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		PtUser com = (PtUser) ptUserService.getById(id);
		model.addAttribute("entity", com);
		return "ptuser/pages/detail";
	}
}
