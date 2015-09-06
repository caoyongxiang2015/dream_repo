
/*
 * 【SpringMVC数据绑定：】
 * 
 * @RequestParam绑定单个请求参数值；
 * 
 * @PathVariable绑定URI模板变量值；
 * 
 * @CookieValue绑定Cookie数据值
 * 
 * @RequestHeader绑定请求头数据；
 * 
 * @ModelValue绑定参数到命令对象；
 * 
 * @SessionAttributes绑定命令对象到session；
 * 
 * @RequestBody绑定请求的内容区数据并能进行自动类型转换等。
 * 
 * @RequestPart绑定“multipart/data”数据，除了能绑定@RequestParam能做到的请求参数外，还能绑定上传的文件等。
 */

package com.env.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleController extends BaseController{

	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SampleController.class);

	public SampleController() {
	}

	@RequestMapping("/index")
	public String index() {
		return "sample/pages/index";
	}

	
	@RequestMapping("/rightSample")
	public String rightSample() {
		return "sample/pages/shiro";
	}
	
	@RequestMapping("/menuSample")
	public String menuSample() {
		return "sample/pages/menuSample";
	}

	@RequestMapping("/listSample")
	public String listSample() {
		return "sample/pages/listSample";
	}

	@RequestMapping("/formSample")
	public String formSample() {
		return "sample/pages/formSample";
	}

	@RequestMapping("/alertMessage")
	public String alertMessage(String levelStr, Model model) {
        if (StringUtils.isBlank(levelStr)) {
            addMessage(model, "简单消息");
        } else if ("default".equals(levelStr)) {
            addDefaultMessage(model, "默认消息");
        } else if ("info".equals(levelStr)) {
            addInfoMessage(model, "信息消息");
        } else if ("success".equals(levelStr)) {
            addSuccessMessage(model, "成功消息");
        } else if ("warn".equals(levelStr)) {
            addWarnMessage(model, "警告消息");
        } else if ("error".equals(levelStr)) {
            addErrorMessage(model, "错误消息");
        } else if ("all".equals(levelStr)) {
            addMessage(model, "全部-简单消息");
            addInfoMessage(model, "全部-信息消息1", "全部-信息消息2", "全部-信息消息3");
        } else {
            addDefaultMessage(model, "默认信息");
        }
		return "sample/pages/alertMessage";
	}

	@RequestMapping("/modelPop")
	public String modelPop() {
		return "sample/pages/modelPop";
	}
	
	@RequestMapping("/testPopSection")
	public String testPopSection() {
		return "sample/pages/testPopSection";
	}
	
	@RequestMapping("/testPopValidateSection")
	public String testPopValidateSection() {
		return "sample/pages/testPopValidateSection";
	}


	@RequestMapping("/switchSample")
	public String switchSample() {
		return "sample/pages/switchSample";
	}

	@RequestMapping("/tagsSample")
	public String tagsSample() {
		return "sample/pages/tagsSample";
	}

}
