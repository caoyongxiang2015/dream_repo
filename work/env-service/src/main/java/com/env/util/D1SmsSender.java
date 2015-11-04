package com.env.util;


import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 短信供应商：上海第翼
 * 短信发送器<br>
 *
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component("d1SmsSender")
public class D1SmsSender {
    /**
     * 日志记录器
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(D1SmsSender.class);


    private String sendUrl = "http://sms.1xinxi.cn/asmx/smsservice.aspx?";
    private String userName = "419792519";
    private String password = "2293BCFCAAB1C8463477C5FCDB74";
	private String sign="好职客";// 签名，短信开头
	public static final String CUSTOMER_PHONE = "13390793901";
	
    public static void main(String []args){
//    	new D1SmsSender().sendSms("13390793901","您正在注册好客会员，短信验证码1234，有效期120秒，客服人员不会向您索要，请注意保密");
    }
    
    /**
     * 
	《=70字算一条
	》70字按 字数/67 计算
	例子： 1、70字                   按1条计费
		 2、134字    134/67=2      按2条计费
		 3、135字  135/67= 2.01    按3条计费  有余数进1

     * @param receiver
     * @param content
     * @return
     */
    public boolean sendSms(String receiver,String content) {
    	return true;
    }
    
    public boolean sendSms1(String receiver,String content) {
    	boolean sendSuccess = false;
    	
    	if (StringUtils.isBlank(receiver)) {
            LOGGER.error("目标手机号为空");
            return false;
        }
    	if (StringUtils.isBlank(content)) {
    		LOGGER.error("发送内容为空");
    		return false;
    	}

    	LOGGER.debug("短信内容长度是"+content.length());
    	
		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer(sendUrl);

		// 向StringBuffer追加用户名
		sb.append("name=").append(userName);

		// 向StringBuffer追加密码（登陆网页版，在管理中心--基本资料--接口密码，是28位的）
		sb.append("&pwd=").append(password);

		// 向StringBuffer追加手机号码
		sb.append("&mobile=").append(receiver);

		// 向StringBuffer追加消息内容转URL标准码
		try {
			sb.append("&content="+URLEncoder.encode(content,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
    		LOGGER.error("内容UTF-8编码异常");
    		sendSuccess = false;
		}
		
		//追加发送时间，可为空，为空为及时发送
		sb.append("&stime=");
		
		//加签名
		try {
			sb.append("&sign="+URLEncoder.encode(sign,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
    		LOGGER.error("签名UTF-8编码异常");
    		sendSuccess = false;
		}
		
		//type为固定值pt  extno为扩展码，必须为数字 可为空
		sb.append("&type=pt&extno=");
		
		// 创建url对象
		LOGGER.debug("发送短信链接"+sb.toString());
		
		URL url = null;
		try {
			url = new URL(sb.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			sendSuccess = false;
		}

		// 打开url连接
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
			sendSuccess = false;
		}

		// 设置url请求方式 ‘get’ 或者 ‘post’
		try {
			connection.setRequestMethod("POST");
		} catch (ProtocolException e) {
			e.printStackTrace();
			sendSuccess = false;
		}

		// 发送
		InputStream is = null;
		try {
			is = url.openStream();
		} catch (IOException e) {
			e.printStackTrace();
			sendSuccess = false;
		}

		//转换返回值
		String returnStr = convertStreamToString(is);
		
		// 无论发送的号码是多少，一个发送请求只返回一个sendid，如果响应的状态不是“0”，则只有状态和消息
		// 返回结果为[  状态,  发送编号,                      无效号码数,  成功提交数, 黑名单数,  消息]，
		// 返回结果为     ‘0,    20130821110353234137876543,  0,         500,     0,       提交成功’
		System.out.println("发送短信返回结果是"+returnStr);
		try{

            if (StringUtils.isNotBlank(returnStr)) {
            	if(returnStr.indexOf(",")>=0){
            		String []results = returnStr.split(",");
            		if("0".equals(results[0])){
            			LOGGER.debug("短信发送成功,接收者"+receiver+",内容:"+content);
            			sendSuccess = true;
            		}
            		if(results.length>3){
            			LOGGER.debug("短信成功发送条数"+results[3]);
            		}
            	}else{
            		// 失败
            		LOGGER.error("短信发送失败,返回内容"+returnStr);
            		sendSuccess = false;
            	}
            }
		}catch(Exception e){
			sendSuccess = false;
		}
		
		return sendSuccess;
    
    }
    

	/**
	 * 转换返回值类型为UTF-8格式.
	 * @param is
	 * @return
	 */
	public String convertStreamToString(InputStream is) {    
        StringBuilder sb1 = new StringBuilder();    
        byte[] bytes = new byte[4096];  
        int size = 0;  
        
        try {    
        	while ((size = is.read(bytes)) > 0) {  
                String str = new String(bytes, 0, size, "UTF-8");  
                sb1.append(str);  
            }  
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            try {    
                is.close();    
            } catch (IOException e) {    
               e.printStackTrace();    
            }    
        }    
        return sb1.toString();    
    }
	

}
