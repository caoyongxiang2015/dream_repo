package com.env.util.bean;


import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;

/**
 * 手机验证码对象<br>
 *
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MobileValidateCode implements Serializable, Comparable<MobileValidateCode> {

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * 验证码长度
     */
    public static final int CODE_LENGTH = 6;

    /**
     * 验证码前缀
     */
    private static final String PREFIX_CODE = "00000";

    /**
     * 验证码
     */
    private final String code;

    /**
     * 超时状态
     */
    private boolean timeout = false;

    /**
     * 超时时刻
     */
    private long lastTime;

    /**
     * 无参构造方法，生成code
     */
    public MobileValidateCode() {
        final String baseNumber = (PREFIX_CODE + Math.abs(RandomUtils.nextLong()));
        code = baseNumber.substring(baseNumber.length() - CODE_LENGTH);
        System.out.println("短信验证码"+code);
    }

    /**
     * 
     * 功能描述: 获取验证码<br>
     *
     * @return 验证码
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     * 功能描述: 验证验证码是否正确<br>
     *
     * @param code 输入验证码
     * @return 验证结果
     */
    public MobileValidateCodeCheckResult check(final String code) {
        if (StringUtils.isEmpty(code)) {
            return MobileValidateCodeCheckResult.INPUT_NULL;
        } else if (StringUtils.isEmpty(this.code)) {
            return MobileValidateCodeCheckResult.CODE_NULL;
        } else if (timeout) {
            return MobileValidateCodeCheckResult.CODE_TIMEOUT;
        } else if (StringUtils.equals(code, this.code)) {
            return MobileValidateCodeCheckResult.OK;
        }
        return MobileValidateCodeCheckResult.NOT_EQUALS;
    }

    /**
     * 检查超时
     * 
     * @return 是否超时
     */
    public boolean checkTimeout() {
        if (lastTime < System.currentTimeMillis()) {
            this.timeout = true;
        }
        return this.timeout;
    }

    /**
     * 设置超时时刻
     * 
     * @param lastTime 超时时刻
     */
    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    @Override
    public int compareTo(MobileValidateCode mobileValidateCode) {
        long compareValue = this.lastTime - mobileValidateCode.lastTime;
        if (0 == compareValue) {
            return 0;
        } else {
            return (int) (compareValue / Math.abs(compareValue));
        }
    }
}
