package com.env.web.util;


import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.env.commons.utils.MemoryPropertyPlaceholderConfigurer;


public class MailSender {
    /**
     * FileSystemResource file = new FileSystemResource(new
     * File("g:/test.rar"));
     * 
     * FileSystemResource img = new FileSystemResource(new File("g:/123.jpg"));
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(MailSender.class);

    /**
     * 
     * @param msgtitle 标题
     * @param msgmemo 内容
     * @param mailAdress 收件地址
     * @param moduleName 模块名称
     * @param imgFileName 可为null
     * @param img 可为null
     * @param attachedFileName 可为null
     * @param file 可为null
     * @return
     */
    public boolean sendMail(String msgtitle, String msgmemo, String mailAdress,
            String moduleName, String imgFileName, FileSystemResource img,
            String attachedFileName, FileSystemResource file) {
        boolean sendSuccess = true;
        
//        if (Boolean.parseBoolean(MemoryPropertyPlaceholderConfigurer
//                .getContextProperty("sendEmail").toString())) 
        {
            JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
            try {
				// 设定mail server
//                senderImpl.setHost(MemoryPropertyPlaceholderConfigurer
//                        .getContextProperty("mail.server.host").toString());
//                senderImpl
//                        .setDefaultEncoding(MemoryPropertyPlaceholderConfigurer
//                                .getContextProperty("mail.server.encoding")
//                                .toString());
                senderImpl.setHost("smtp.yeah.net");// 需要开启邮箱smtp授权
                senderImpl.setDefaultEncoding("gb2312");

                
				// 建立邮件消息,发送简单邮件和html邮件的区别
                MimeMessage mailMessage = senderImpl.createMimeMessage();
//                MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage);
                MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,true);

				// 设置收件人，寄件人
                try {
                    messageHelper.setTo(mailAdress);
                    messageHelper.setFrom("haozhike@yeah.net");
                    try {
                        messageHelper.setSubject(MimeUtility.encodeText(
                                msgtitle,"gb2312", "B"));

						// true 表示启动HTML格式的邮件
//                        messageHelper.setText("<html><head></head><body><h1>"
//                                + msgmemo + "</h1></body></html>", true);
                        messageHelper.setText("<html><head></head><body>"
                        		+ msgmemo + "</body></html>", true);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    if (img != null) {
                        messageHelper.addInline(imgFileName, img);
                    }
                    if (file != null) {
//                    	messageHelper.addAttachment(MimeUtility.encodeWord(attachedFileName),file);     
                        messageHelper.addAttachment(attachedFileName, file);
                    }
                } catch (MessagingException e) {
                    e.printStackTrace();
                }

//                senderImpl.setUsername(MemoryPropertyPlaceholderConfigurer
//						.getContextProperty("mail.server.userName").toString()); // 根据自己的情况,设置username
//                senderImpl.setPassword(MemoryPropertyPlaceholderConfigurer
//						.getContextProperty("mail.server.password").toString()); // 根据自己的情况,
																					// 设置password
                senderImpl.setUsername("haozhike@yeah.net"); // 根据自己的情况,设置username
                senderImpl.setPassword("bhmfcrsljzkgkyru"); // 根据自己的情况,
                Properties prop = new Properties();
//                Map<String, String> contextProperty = MemoryPropertyPlaceholderConfigurer
//                        .getContextProperty();
//                for (String contextKey : contextProperty.keySet()) {
//                    if (contextKey.startsWith("mail.smtp.")) {
//                        prop.put(contextKey, contextProperty.get(contextKey));
//                    }
//                }
                 prop.put("mail.smtp.auth", "true"); //
				// 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
                 prop.put("mail.smtp.timeout", "25000");
                senderImpl.setJavaMailProperties(prop);
				// 发送邮件
                senderImpl.send(mailMessage);
				LOGGER.info("模块[" + moduleName + "]发送至[" + mailAdress
						+ "]的 邮件发送成功");
                sendSuccess = true;
            } catch (Exception e) {
                sendSuccess = false;
				LOGGER.warn("模块[" + moduleName + "]发送至[" + mailAdress
						+ "]的 邮件发送失败", e);
            }
//        } else {
//            sendSuccess = Boolean.parseBoolean(MemoryPropertyPlaceholderConfigurer
//                    .getContextProperty("defaultEmailSendStatus").toString());
//			LOGGER.warn("邮件发送功能禁止，模块[" + moduleName + "]不会发送至[" + mailAdress
//					+ "]，返回参数使用默认参数[" + sendSuccess + "]");
        }
        return sendSuccess;
    }

    /**
	 * 批量发送邮件
	 * 
	 * @param msgtitle
	 * @param msgmemo
	 * @param mailAdress
	 * @param moduleName
	 * @param imgFileName
	 * @param img
	 * @param attachedFileName
	 * @param file
	 * @return
	 */
    public boolean sendMails(String msgtitle, String msgmemo,
            String mailAdress, String moduleName, String imgFileName,
            FileSystemResource img, String attachedFileName,
            FileSystemResource file) {
        boolean flag = true;
            JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
            try {
				// 设定mail server
                senderImpl.setHost("smtp.yeah.net");// 需要开启邮箱smtp授权
                senderImpl.setDefaultEncoding("gb2312");
				// 建立邮件消息,发送简单邮件和html邮件的区别
                MimeMessage mailMessage = senderImpl.createMimeMessage();
//                MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage);
                MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,true);

				// 设置收件人，寄件人
                try {
                	InternetAddress[] to = InternetAddress.parse(mailAdress);
                	messageHelper.setTo(to);
//                    messageHelper.setTo(mailAdress);
                    messageHelper.setFrom("haozhike@yeah.net");
                    try {
                    	messageHelper.setSubject(MimeUtility.encodeText(msgtitle,"gb2312", "B"));

						// true 表示启动HTML格式的邮件
                        messageHelper.setText("<html><head></head><body><h1>"
                                + msgmemo + "</h1></body></html>", true);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    if (img != null) {
                        messageHelper.addInline(imgFileName, img);
                    }
                    if (file != null) {
                        messageHelper.addAttachment(attachedFileName, file);
                    }
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                
                senderImpl.setUsername("haozhike@yeah.net"); // 根据自己的情况,设置username
                senderImpl.setPassword("bhmfcrsljzkgkyru"); // 根据自己的情况
                
                Properties prop = new Properties();
                prop.put("mail.smtp.auth", "true"); //
				// 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
                prop.put("mail.smtp.timeout", "25000");
                
                senderImpl.setJavaMailProperties(prop);
                senderImpl.setJavaMailProperties(prop);
                
				// 发送邮件
                senderImpl.send(mailMessage);
				LOGGER.info("模块[" + moduleName + "]发送至[" + mailAdress
						+ "]的 邮件发送成功");
            } catch (Exception e) {
                flag = false;
				LOGGER.warn("模块[" + moduleName + "]发送至[" + mailAdress
						+ "]的 邮件发送失败", e);
            }
        return flag;
    }
}
