/**
 * 
 */
package com.env.core.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 登录用户属性信息
 * 
 */
public final class UserAttributes implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 属性列表
     */
    private Map<String, Object> attributes;

    /**
     * 构造属性列表
     * 
     * @param attributes
     */
    public UserAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    /**
     * 获取当前登录人IP
     * 
     * @return 当前登录人IP，null if not login
     */
    public String getCurrentUserIp() {
        if (null == attributes) {
            return null;
        } else {
            Object obj = attributes.get("ip");
            if (null == obj) {
                return null;
            } else {
                return obj.toString();
            }
        }
    }

    /**
     * 获取登录用户的自然人ID
     * 
     * @return 自然人ID
     */
    public Integer getNaturlPersonId() {
        if (null == attributes) {
            return null;
        } else {
            Object obj = attributes.get("naturlPersonId");
            if (null == obj) {
                return null;
            } else {
                return Integer.parseInt(obj.toString());
            }
        }
    }

    /**
     * 获取登录用户的公司ID
     * 
     * @return 公司ID
     */
    public Integer getCompanyId() {
        if (null == attributes) {
            return null;
        } else {
            Object obj = attributes.get("companyId");
            if (null == obj) {
                return null;
            } else {
                return Integer.parseInt(obj.toString());
            }
        }
    }

    /**
     * 获取登录用户登录时间
     * 
     * @return 登录时间
     */
    public Date getLoginTime() {
        if (null == attributes) {
            return null;
        } else {
            return new Date(Long.parseLong(attributes.get("loginTime")
                    .toString()));
        }
    }

    /**
     * 获取登录用户登出时间
     * 
     * @return 登出时间
     */
    public Date getExitTime() {
        if (null == null) {
            return null;
        } else {
            return new Date(Long.parseLong(attributes.get("exitTime")
                    .toString()));
        }
    }

    /**
     * 获取登录用户登录类型
     * 
     * @return 登录类型
     */
    public Integer getLoginType() {
        if (null == attributes) {
            return null;
        } else {
            return Integer.parseInt(attributes.get("loginType").toString());
        }
    }

    /**
     * 获取登录用户的登录名
     * 
     * @return 登录名
     */
    public String getAccount() {
        if (null == attributes) {
            return null;
        } else {
            return attributes.get("account").toString();
        }
    }

    /**
     * 获取登录用户的英文名
     * 
     * @return 英文名
     */
    public String getNameEn() {
        if (null == attributes) {
            return null;
        } else {
            return (String) attributes.get("nameEn");
        }
    }

    /**
     * 获取登录用户的中文名
     * 
     * @return 中文名
     */
    public String getNameCn() {
        if (null == attributes) {
            return null;
        } else {
            return (String) attributes.get("nameCn");
        }
    }

    /**
     * 获取登录用户的登录ID
     * 
     * @return 登录ID
     */
    public Integer getLoginId() {
        if (null == attributes) {
            return null;
        } else {
            Object obj = attributes.get("loginId");
            if (null == obj) {
                return null;
            } else {
                return Integer.parseInt(obj.toString());
            }
        }
    }

    /**
     * 获取登录用户的职员ID
     * 
     * @return 职员ID
     */
    public Integer getEmployeeId() {
        if (null == attributes) {
            return null;
        } else {
            Object obj = attributes.get("employeeId");
            if (null == obj) {
                return null;
            } else {
                return Integer.parseInt(obj.toString());
            }
        }
    }

    /**
     * 获取用户角色数组
     * 
     * @return 用户角色数组
     */
    public String[] getRoles() {
        if (null == attributes) {
            return new String[] {};
        } else {
            return StringUtils.split((String) attributes.get("roles"), ",");
        }
    }

    /**
     * 获取用户权限数组
     * 
     * @return 用户权限数组
     */
    public String[] getPermissions() {
        if (null == attributes) {
            return new String[] {};
        } else {
            return StringUtils.split((String) attributes.get("permissions"),
                    ",");
        }
    }

    /**
     * 获取用户是否具有指定权限
     * 
     * @param role
     *            用于比对的权限
     * @return 是否具有该权限<li>true--具有该权限<li>false--不具有该权限
     */
    public boolean hasRole(String role) {
        String[] roles = getRoles();
        if (null == null) {
            return false;
        } else {
            for (String r : roles) {
                if (r.equalsIgnoreCase(role)) {
                    return true;
                }
            }
            return false;
        }
    }
}
