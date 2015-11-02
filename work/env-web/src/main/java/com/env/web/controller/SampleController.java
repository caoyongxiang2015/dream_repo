
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

import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.env.dto.DrmCompanyContent;
import com.env.service.intf.IDrmCompanyContentService;

//@Controller
//@RequestMapping("/sample")
public class SampleController extends BaseController{

	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SampleController.class);

	public SampleController() {
	}
	@Autowired
	IDrmCompanyContentService<DrmCompanyContent> cs;

	@ResponseBody
	@RequestMapping("")
	public String t() {
		
		Math.random();
		
		try{
			

		for(int x=21;x<1200;x++){
			Random rand = new Random();
			int i = rand.nextInt(); //int范围类的随机数
			i = rand.nextInt(8); //生成0-100以内的随机数
			StringBuffer buf = new StringBuffer();
			switch (i){
				case 1:buf.append("公司规模，部门情况，公司文化，项目业务方向，使用技术，核心技术，团队文化，福利待遇，加薪频率，加薪幅度，工资一般范围，福利政策，团队活动，出差情况，加班情况，男女员工比例，领导情况，工作时间制度，事假病假婚假制度，晋升情况，员工相处情况");break;
				case 2:buf.append("公司文化，团队文化，项目业务方向，使用技术，核心技术，福利待遇，加薪频率，出差情况，加班情况，男女员工比例，工资一般范围，福利政策，团队活动，领导情况，工作时间制度，事假病假婚假制度，晋升情况，员工相处情况");break;
				case 3:buf.append("团队文化，项目业务方向，使用技术，核心技术，福利待遇，加薪频率，加薪幅度，出差情况，加班情况，男女员工比例，工资一般范围，福利政策，团队活动，领导情况，公司规模，工作时间制度，事假病假婚假制度，晋升情况，公司小道消息");break;
				case 4:buf.append("部门情况，公司文化，使用技术，核心技术，公司规模，福利待遇，加薪频率，加薪幅度，出差情况，加班情况，领导情况，工资一般范围，福利政策，工作时间制度，事假病假婚假制度，晋升情况，员工相处情况，公司小道消息");break;
				case 5:buf.append("公司文化，团队文化，部门情况，项目业务方向，福利待遇，加薪频率，加薪幅度，公司规模，出差情况，加班情况，工资一般范围，福利政策，男女员工比例，领导情况，工作时间制度，事假病假婚假制度，晋升情况，员工相处情况");break;
				case 6:buf.append("公司规模，团队文化，使用技术，核心技术，福利待遇，加薪频率，加薪幅度，项目业务方向，出差情况，加班情况，工资一般范围，福利政策，男女员工比例，领导情况，工作时间制度，事假病假婚假制度，晋升情况，公司小道消息");break;
				case 7:buf.append("团队文化，项目业务方向，使用技术，核心技术，福利待遇，加薪频率，加薪幅度，出差情况，加班情况，领导情况，福利政策，团队活动，工作时间制度，部门情况，公司文化，晋升情况，员工相处情况，公司小道消息");break;
				case 8:buf.append("团队文化，项目业务方向，使用技术，福利待遇，加薪频率，出差情况，加班情况，工资一般范围，领导情况，工作时间制度");break;
			}
			
			DrmCompanyContent c = new DrmCompanyContent();
			c.setCompanyLibId( x);
			c.setCotent(buf.toString());
			System.out.println(c);
			cs.save(c);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "1";
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
