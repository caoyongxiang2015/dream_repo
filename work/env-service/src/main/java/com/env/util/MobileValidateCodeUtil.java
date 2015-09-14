package com.env.util;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.env.util.bean.MobileValidateCode;
import com.env.util.bean.MobileValidateCodeCheckResult;

/**
 * 手机验证码工具<br>
 *
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MobileValidateCodeUtil {
    /**
     * 日志记录器
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MobileValidateCodeUtil.class);

    /**
     * 手机验证码的会话主键
     */
    private static final String MOBILE_VALIDATE_CODE_KEY = "session.mobileValidateCode";

    /**
     * 手机验证码队列
     */
    private static final Queue<MobileValidateCode> MOBILE_VALIDATE_CODES = new LinkedBlockingQueue<MobileValidateCode>();

    /**
     * 超时时间（2分钟）
     */
    private static final int TIME_OUT = 1 * 60 * 1000;// 2 * 60 * 1000;

    /**
     * 
     * 功能描述: 设置验证码对象<br>
     *
     * @param session 会话
     * @return 验证码设置是否成功<br>
     *         <li>true--设置成功<li>false--设置失败
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     * 
     *        <pre>
     * e.g.
     *     // 设置并获取手机验证码
     *     String code = setMobileValidateCode(session);
     *     // 发送手机验证码
     *     if (StringUtils.isNotBlank(code)) {
     *         // 发送
     *         ......
     *     } else {
     *         // 不发生(可以选择重新生成或控制生成次数，或提示失败)
     *         ......
     *     }
     * 
     * </pre>
     */
    public static final String setMobileValidateCode(HttpSession session) {
        MobileValidateCode mobileValidateCode = new MobileValidateCode();
        session.setAttribute(MOBILE_VALIDATE_CODE_KEY, mobileValidateCode);
        mobileValidateCode.setLastTime(System.currentTimeMillis() + TIME_OUT);
        if (MOBILE_VALIDATE_CODES.offer(mobileValidateCode)) {
            return mobileValidateCode.getCode();
        } else {
            // 移除短信验证码
            session.removeAttribute(MOBILE_VALIDATE_CODE_KEY);
            return "";
        }
    }

    /**
     * 
     * 功能描述: 验证手机验证码<br>
     *
     * @param session 会话
     * @param code 输入手机验证码
     * @return 验证结果
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static final MobileValidateCodeCheckResult checkMobileValidateCode(HttpSession session, String code) {
        MobileValidateCode mobileValidateCode = (MobileValidateCode) session.getAttribute(MOBILE_VALIDATE_CODE_KEY);
        if (null == mobileValidateCode) {
            return MobileValidateCodeCheckResult.CODE_NULL;
        } else {
            MobileValidateCodeCheckResult checkResult = mobileValidateCode.check(code);
            // 如果验证通过，则手机验证码作废
            if (checkResult.isCheckStatus()) {
                session.removeAttribute(MOBILE_VALIDATE_CODE_KEY);
            }
            return checkResult;
        }
    }

    /**
     * 启动手机验证码超时线程
     */
    static {
        /**
         * 检查手机验证码超时线程
         */
        new Thread() {
            public void run() {
                while (true) {
                    try {
                        MobileValidateCode mobileValidateCode = MOBILE_VALIDATE_CODES.peek();
                        // 验证码存在且超时
                        while (null != mobileValidateCode && mobileValidateCode.checkTimeout()) {
                            // 移除该验证码
                            MOBILE_VALIDATE_CODES.poll();
                            // 验证下一验证码
                            mobileValidateCode = MOBILE_VALIDATE_CODES.peek();
                        }
                        Thread.sleep(1);
                    } catch (Throwable ex) {
                        LOGGER.error("检查手机验证码超时失败", ex);
                    }
                }
            };
        }.start();
    }
}
