package com.env.web.tags;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

/**
 * 下拉列表标签父类
 * 
 */
public abstract class AbstractSelectTag<T> extends RequestContextAwareTag {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static final String SLASH_STR = "\"";
    private String name;
    private String span = "span6";
    private String placeHolderMessageCode;
    private boolean useChosen = true;
    private boolean showAllOption = false;
    private String style;
    private boolean required = false;
    private String value;
    /**
     * 空或全部时使用值
     */
    private String defaultValue;
    private String clazz;
    private boolean multiple = false;
    private boolean disabled = false;
    private String parentCode;
    /**
     * 级联操作时存放下级级联操作的元素的name
     */
    private String cascadeName;
    /**
     * 重载url，该URL不含项目根，且只允许一个参数，该参数为调用方的value
     */
    private String reloadUrl;

    /**
     * 下拉列表属性映射
     */
    private final Map<String, String> selectAttributeMap = new HashMap<String, String>();

    protected String getName() {
        if (name == null) {
            return getDefaultName();
        }
        return name;
    }

    protected String getSpan() {
        return span;
    }

    protected String getPlaceHolderMessageCode() {
        if (placeHolderMessageCode == null) {
            return getDefaultPlaceHolderMessageCode();
        }
        return placeHolderMessageCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpan(String span) {
        this.span = span;
    }

    public void setPlaceHolderMessageCode(String placeHolderMessageCode) {
        this.placeHolderMessageCode = placeHolderMessageCode;
    }

    public boolean isUseChosen() {
        return useChosen;
    }

    public void setUseChosen(boolean useChosen) {
        this.useChosen = useChosen;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isShowAllOption() {
        return showAllOption;
    }

    public void setShowAllOption(boolean showAllOption) {
        this.showAllOption = showAllOption;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public boolean isMultiple() {
        return multiple;
    }

    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }

    protected abstract String getDefaultName();

    protected String getDefaultPlaceHolderMessageCode() {
        return "common.pleaseSelect";
    }

    protected WebApplicationContext getApplicationContext() {
        return getRequestContext().getWebApplicationContext();
    }

    protected MessageSource getMessageSource() {
        return getRequestContext().getMessageSource();
    }

    protected String getPlaceHoldMessage() {
        Locale locale = LocaleContextHolder.getLocale();
        try {
            return getMessageSource().getMessage(getPlaceHolderMessageCode(), null, locale);
        } catch (Exception ex) {
            return getPlaceHolderMessageCode();
        }
    }

    /**
     * @return the cascadeName
     */
    public String getCascadeName() {
        return cascadeName;
    }

    /**
     * @param cascadeName the cascadeName to set
     */
    public void setCascadeName(String cascadeName) {
        this.cascadeName = cascadeName;
    }

    @Override
    protected int doStartTagInternal() throws IOException {

        StringBuilder builder = new StringBuilder();
        builder.append("<select ");

        addDefaultAttributeMap();
        appendExtAttribute();
        bindAttributeToSelect(builder);

        builder.append(">");
        builder.append("<option value=\"");
        // 如果设置了默认值，则第一个选项(空白或ALL)的value用默认值填充
        builder.append(SLASH_STR + appendExtra(null) + ">");
        if (null != defaultValue) {
            builder.append(defaultValue);
        }
        // 如果显示全部，那么就不会出现第一个是空白的情况
        if (isShowAllOption()) {
            builder.append(getMessageSource().getMessage("common.option.all", null, LocaleContextHolder.getLocale()));
        }
        builder.append("</option>");

        try{
            if (isMultiple()) {
                String[] values = StringUtils.split(getValue(), ",");
                for (T obj : getList()) {
                    String optionValue = getOptionValue(obj).toString();
                    String optionLabel = getOptionLabel(obj);
                    buildOption(builder, optionLabel, optionValue, ArrayUtils.contains(values, optionValue), obj);
                }
            } else {
                for (T obj : getList()) {
                    String optionValue = getOptionValue(obj).toString();
                    String optionLabel = getOptionLabel(obj);
                    buildOption(builder, optionLabel, optionValue, optionValue.equals(getValue()), obj);
                }
            }
        }catch(Exception ex){
            LoggerFactory.getLogger(this.getClass()).error(ex.getMessage(), ex);
        }

        builder.append("</select>");
        pageContext.getOut().write(builder.toString());

        return SKIP_BODY;
    }

    /**
     * 
     * 功能描述: 绑定属性到select<br>
     * 遍历属性列表，将每项属性都绑定到select中
     *
     * @author 
     * @param builder 需要绑定的字符串
     */
    private void bindAttributeToSelect(StringBuilder builder) {
        for (Entry<String, String> entry : selectAttributeMap.entrySet()) {
            builder.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
    }

    private void buildOption(StringBuilder builder, String optionLabel, String optionValue, boolean selected, T obj) {
        builder.append("<option value=\"").append(optionValue).append("\"");
        builder.append(appendExtra(obj));
        if (selected) {
            builder.append(" selected=\"selected\" ");
        }

        builder.append(">").append(optionLabel).append("</option>");
    }

    protected abstract List<T> getList();

    protected abstract Object getOptionValue(T obj);

    protected abstract String getOptionLabel(T obj);

    /**
     * 
     * 功能描述: 追加扩展属性<br>
     *
     * @author 
     * @return 扩展属性字符串
     */
    protected void appendExtAttribute() {
    }

    /**
     * 设置option的附加属性
     * 
     * @param obj 记录对象
     * @return 附加属性语句
     */
    protected String appendExtra(T obj) {
        return "";
    }

    /**
     * @return the disabled
     */
    public boolean isDisabled() {
        return disabled;
    }

    /**
     * @param disabled the disabled to set
     */
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * @return the reloadUrl
     */
    public String getReloadUrl() {
        return reloadUrl;
    }

    /**
     * @param reloadUrl the reloadUrl to set
     */
    public void setReloadUrl(String reloadUrl) {
        this.reloadUrl = reloadUrl;
    }

    /**
     * @return the parentCode
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * @param parentCode the parentCode to set
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    /**
     * @return the defaultValue
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * @param defaultValue the defaultValue to set
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * 获取下拉列表属性映射
     * 
     * @return 下拉列表属性映射
     */
    public Map<String, String> getSelectAttributeMap() {
        return selectAttributeMap;
    }

    /**
     * 
     * 功能描述: 设置默认属性集合<br>
     *
     * @author 
     */
    private void addDefaultAttributeMap() {
        Map<String, String> defaultAttributeMap = new HashMap<String, String>();
        defaultAttributeMap.put("name", getName());
        defaultAttributeMap.put("id", getName());
        StringBuilder finalClazz = new StringBuilder();
        if (isUseChosen()) {
            finalClazz.append("chosen-with-diselect");
        }

        if (StringUtils.isNotEmpty(getSpan())) {
            finalClazz.append("  ").append(getSpan()).append(" ");
        }

        if (StringUtils.isNotEmpty(getClazz())) {
            finalClazz.append("  ").append(getClazz()).append(" ");
        }
        if (isRequired()) {
            finalClazz.append(" required ");
        }
        defaultAttributeMap.put("class", finalClazz.toString());
        defaultAttributeMap.put("data-placeholder", getPlaceHoldMessage());
        if (StringUtils.isNotBlank(getStyle())) {
            defaultAttributeMap.put("style", getStyle());
        }
        if (StringUtils.isNotBlank(getCascadeName())) {
            defaultAttributeMap.put("cascade", getCascadeName());
        }
        if (StringUtils.isNotBlank(getReloadUrl())) {
            defaultAttributeMap.put("reloadUrl", getReloadUrl());
        }
        if (isRequired()) {
            defaultAttributeMap.put("required", "required");
        }
        if (isMultiple()) {
            defaultAttributeMap.put("multiple", "multiple");
        }
        if (isDisabled()) {
            defaultAttributeMap.put("disabled", "true");
        }
        addSelectAttributeMap(defaultAttributeMap);
    }

    /**
     * 
     * 功能描述: 增加下拉列表属性集合<br>
     *
     * @param selectAtts 增加的下拉列表属性集合
     */
    protected void addSelectAttributeMap(Map<String, String> selectAtts) {
        this.selectAttributeMap.putAll(selectAtts);
    }
}
