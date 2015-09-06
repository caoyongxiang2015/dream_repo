package com.env.util;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 短信发送器<br>
 *
 * @author chengjianfang
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component("smsSender")
public class SmsSender {
    /**
     * 日志记录器
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsSender.class);
    /**
     * 发送URL
     */
//    @Value("#{sms['sms.sendUrl']}")
    private String sendUrl = "http://www.139000.com/send/gsend.asp";
    /**
     * 检查URL
     */
//    @Value("#{sms['sms.checkUrl']}")
    private String checkUrl = "http://www.139000.com/send/checkcontent.asp";
    /**
     * 用户名
     */
//    @Value("#{sms['sms.userName']}")
    private String userName = "306635282";
    /**
     * 密码
     */
//    @Value("#{sms['sms.password']}")
    private String password = "it7519cao";

    /**
     * 
     * 功能描述: 发送短信<br>
     * 非长短信方式
     *
     * @param receiver 接收方号码
     * @param content 短信内容
     * @return 发送成功与否
     */
    public boolean sendSms(String receiver, String content) {
//        if (check(content)) {
//            return true;//send(receiver, content, false);
//        } else {
//            return false;
//        }
        return true;//send(receiver, content, false);
    }

    /**
     * 
     * 功能描述: 发送短信<br>
     *
     * @param receiver 接收方号码
     * @param content 短信内容
     * @param isLong 是否长短信
     * @return 发送成功与否
     */
    public boolean sendSms(String receiver, String content, boolean isLong) {
        if (check(content)) {
            return false;//send(receiver, content, isLong);
        } else {
            return false;
        }
    }

    /**
     * 
     * 功能描述: 短信检查<br>
     * 检查短信合法性
     *
     * @param content 短信内容
     * @return 是否合法
     */
    private boolean check(String content) {
        boolean checkSuccess = false;
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = null;
        try {
//            URL url = new URL(getCheckUrl(content));
        	String surl = getCheckUrl(content);
        	URLEncoder.encode(surl,"GB2312");
            URL url = new URL(surl);
            LOGGER.debug("checkUrl:" + url);
            URLConnection conn = url.openConnection();
//            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK"));
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            for (String line = null; (line = reader.readLine()) != null;) {
                sb.append(line + "\n");
            }
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (Exception ex) {
                    LOGGER.info("关闭读流失败", ex);
                }
            }
            String checkResult = sb.toString();
            LOGGER.debug("checkResult:" + checkResult);
            if (StringUtils.isNotBlank(checkResult)) {
                int errIdBeginIndex = getIndex(checkResult, "errid=");
                int errIdEndIndex = checkResult.indexOf('&', errIdBeginIndex);
                if (-1 != errIdBeginIndex && -1 != errIdEndIndex) {
                    // 内容合法
                    if (StringUtils.equals("0", checkResult.substring(errIdBeginIndex, errIdEndIndex))) {
                        checkSuccess = true;
                    } else {
                        int errBeginIndex = getIndex(checkResult, "err=");
                        if (-1 != errBeginIndex) {
                            // 短信内容非法
                            LOGGER.error("短信检查失败，失败原因：" + checkResult.substring(errBeginIndex));
                        }
                    }
                }
            }
        }
        return checkSuccess;
    }

    /**
     * 功能描述: 获取索引结束位置<br>
     * 索引位置+匹配字符串长度
     * 
     * @author chengjianfang
     *
     * @param baseResult 待匹配字符串
     * @param key 匹配字符串
     * @return 索引结尾位置
     */
    private int getIndex(String baseResult, String key) {
        return baseResult.indexOf(key) + key.length();
    }

    /**
     * 短信发送
     * 
     * @author chengjianfang
     * 
     * @param receiver 接收方手机号码
     * @param content 为不超过60个汉字、字符、数字的字符串，小灵通号码不超过40个字。超过的字符自动截掉。如果是超长短信，不能超过240个字符
     * @param isLong 是否开启长短信
     * @return 发送成功与否
     */
    private boolean send(String receiver, String content, boolean isLong) {
        boolean sendSuccess = false;
        // 获取发送url
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = null;
        try {
            URL url = new URL(getSentUrl(receiver, content, isLong));
            LOGGER.debug("sendUrl:" + url);
            URLConnection conn = url.openConnection();
//            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK"));
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            for (String line = null; (line = reader.readLine()) != null;) {
                sb.append(line + "\n");
            }
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (Exception ex) {
                    LOGGER.info("关闭读流失败", ex);
                }
            }
            String sendResult = sb.toString();
            LOGGER.debug("sendResult:" + sendResult);
            if (StringUtils.isNotBlank(sendResult)) {
                int numberBeginIndex = getIndex(sendResult, "num=");
                int messageBeginIndex = getIndex(sendResult, "err=");
                int numberEndIndex = sendResult.indexOf('&', numberBeginIndex);
                int messageEndIndex = sendResult.indexOf('&', messageBeginIndex);
                if (-1 != numberBeginIndex && -1 != numberEndIndex) {
                    String num = sendResult.substring(numberBeginIndex, numberEndIndex);
                    if (StringUtils.isNumeric(num) && Integer.valueOf(num) > 0) {
                        sendSuccess = true;
                    } else if (-1 != messageBeginIndex && -1 != messageEndIndex) {
                        LOGGER.error("短信发送失败，失败原因：" + sendResult.substring(messageBeginIndex, messageEndIndex));
                    }
                } else {
                    LOGGER.error("短信发送响应无错误码");
                }
            } else {
                LOGGER.error("短信发送响应为空");
            }
        }
        return sendSuccess;
    }

    /**
     * 
     * 功能描述: 获取发送的url<br>
     * 〈功能详细描述〉
     *
     * @author chengjianfang
     * @version [版本号, 2014-8-19]
     * @param receiver 接收方手机号
     * @param content 为不超过60个汉字、字符、数字的字符串，小灵通号码不超过40个字。超过的字符自动截掉。如果是超长短信，不能超过240个字符
     * @param isLong 是否开启长短信。账号需要开通此功能，且通道和手机支持才能使用
     * @return
     */
    private String getSentUrl(String receiver, String content, boolean isLong) {
        StringBuilder sb = new StringBuilder(sendUrl);
        try {
            sb.append("?name=").append(URLEncoder.encode(userName, "GB2312")).append("&pwd=").append(password);
        } catch (UnsupportedEncodingException ex) {
            LOGGER.info("账户信息转换URLEncoder失败", ex);
        }
        if (StringUtils.isNotBlank(receiver)) {
            sb.append("&dst=" + receiver);
        } else {
            LOGGER.info("目标手机号为空");
        }
        if (StringUtils.isNotBlank(content)) {
            try {
                sb.append("&msg=" + URLEncoder.encode(content, "GB2312"));
            } catch (UnsupportedEncodingException e) {
                LOGGER.error(e.toString());
            }
        } else {
            LOGGER.info("短信内容为空");
        }
        if (isLong) {
            sb.append("&txt=ccdx");
        }
        return sb.toString();
    }

    /**
     * 
     * 功能描述:校验短信内容的合法性和用户名密码是否正确 <br>
     * 〈功能详细描述〉
     *
     * @author chengjianfang
     * @version [版本号, 2014-8-19]
     * @param content 短信内容为不超过540个汉字、字符、数字的字符串
     * @param appId 平台标识，每个平台都使用自己的用户和密码进行消息的发送
     * @return
     * @since [产品/模块版本](可选)
     */
    private String getCheckUrl(String content) {
        StringBuilder sb = new StringBuilder(checkUrl);
        sb.append("?name=").append(userName).append("&pwd=").append(password);
        if (StringUtils.isNotBlank(content)) {
            sb.append("&content=" + content);
        } else {
            LOGGER.info("要检查合法性的短信内容为空");
        }
        return sb.toString();
    }
}
