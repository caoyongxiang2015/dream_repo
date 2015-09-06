package com.env.util.bean;


/**
 * 手机验证码验证结果<br>
 *
 * @author chengjianfang
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum MobileValidateCodeCheckResult {

    /**
     * 验证通过
     */
    OK(true, "验证通过"),
    /**
     * 输入的手机验证码为空
     */
    INPUT_NULL(false, "输入的手机验证码为空"),
    /**
     * 请获取手机验证码
     */
    CODE_NULL(false, "请获取手机验证码"),
    /**
     * 手机验证码已超时失效
     */
    CODE_TIMEOUT(false, "手机验证码已失效,请重新获取"),
    /**
     * 手机验证码错误
     */
    NOT_EQUALS(false, "手机验证码错误");

    /**
     * 构造方法
     * 
     * @param checkStatus 验证状态
     * @param checkMessage 验证信息
     */
    private MobileValidateCodeCheckResult(final boolean checkStatus, final String checkMessage) {
        this.checkStatus = checkStatus;
        this.checkMessage = checkMessage;
    }

    /**
     * 验证状态
     */
    private final boolean checkStatus;

    /**
     * 验证信息
     */
    private final String checkMessage;

    /**
     * 获取验证状态
     * 
     * @return 验证状态
     */
    public final boolean isCheckStatus() {
        return checkStatus;
    }

    /**
     * 获取验证信息
     * 
     * @return 验证信息
     */
    public final String getCheckMessage() {
        return checkMessage;
    }
}
