package com.env.shiro;

import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractFilter;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;

import com.env.dto.PtPermission;
import com.env.service.intf.IPtPermissionService;

/**
 * 自定义Shiro过滤器
 * 
 */
public class EnvShiroFilterFactoryBean extends ShiroFilterFactoryBean {
    private static transient final Logger LOGGER = LoggerFactory
            .getLogger(EnvShiroFilterFactoryBean.class);
    /**
     * 应用编码(预留)
     */
    private String appCode;

    // 依赖于 env-service
    /**
     * 权限service
     */
    @Autowired
    private IPtPermissionService<PtPermission> ptPermissionService;
    
    /**
     * 过滤器分析器
     */
    private PathMatchingFilterChainResolver chainResolver = new PathMatchingFilterChainResolver();

    @Override
    public Map<String, String> getFilterChainDefinitionMap() {
    	LOGGER.debug("EnvShiroFilterFactoryBean.getFilterChainDefinitionMap()，待获取perms list,appCode:"+appCode);
        Map<String, String> result = ptPermissionService.listPerms(appCode);//account.listPerms(appCode);
        result.putAll(super.getFilterChainDefinitionMap());
        LOGGER.debug("EnvShiroFilterFactoryBean.getFilterChainDefinitionMap()，获取perms list,result:"+result);
        return result;
    }

    @Override
    protected AbstractShiroFilter createInstance() throws Exception {
        LOGGER.debug("Creating Shiro Filter instance.");

        org.apache.shiro.mgt.SecurityManager securityManager = getSecurityManager();
        if (securityManager == null) {
            String msg = "SecurityManager property must be set.";
            throw new BeanInitializationException(msg);
        }

        if (!(securityManager instanceof WebSecurityManager)) {
            String msg = "The security manager does not implement the WebSecurityManager interface.";
            throw new BeanInitializationException(msg);
        }

        FilterChainManager manager = createFilterChainManager();

        chainResolver.setFilterChainManager(manager);

        return new SpringShiroFilter((WebSecurityManager) securityManager,
                chainResolver);
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    /**
     * @return the chainResolver
     */
    public PathMatchingFilterChainResolver getChainResolver() {
        return chainResolver;
    }

    /**
     * @param chainResolver
     *            the chainResolver to set
     */
    public void setChainResolver(PathMatchingFilterChainResolver chainResolver) {
        this.chainResolver = chainResolver;
    }

    /**
     * Ordinarily the {@code AbstractShiroFilter} must be subclassed to
     * additionally perform configuration and initialization behavior. Because
     * this {@code FactoryBean} implementation manually builds the
     * {@link AbstractShiroFilter}'s
     * {@link AbstractShiroFilter#setSecurityManager(org.apache.shiro.web.mgt.WebSecurityManager)
     * securityManager} and
     * {@link AbstractShiroFilter#setFilterChainResolver(org.apache.shiro.web.filter.mgt.FilterChainResolver)
     * filterChainResolver} properties, the only thing left to do is set those
     * properties explicitly. We do that in a simple concrete subclass in the
     * constructor.
     */
    private static final class SpringShiroFilter extends AbstractShiroFilter {
        protected SpringShiroFilter(WebSecurityManager webSecurityManager,
                FilterChainResolver resolver) {
            super();
            if (webSecurityManager == null) {
                throw new IllegalArgumentException(
                        "WebSecurityManager property cannot be null.");
            }
            setSecurityManager(webSecurityManager);
            if (resolver != null) {
                setFilterChainResolver(resolver);
            }
        }

        @Override
        public void setFilterConfig(FilterConfig filterConfig) {
            // 给每个filter设置servlet context, Shiro中并没有给每中类型
            // 的filter设置servletContext, 那些Filter只是利用了Filter的接口而已
            super.setFilterConfig(filterConfig);
            PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) this
                    .getFilterChainResolver();
            Map<String, Filter> filterMap = filterChainResolver
                    .getFilterChainManager().getFilters();
            Collection<Filter> filters = filterMap.values();
            for (Filter filter : filters) {
                if (filter instanceof AbstractFilter) {
                    ((AbstractFilter) filter).setServletContext(filterConfig
                            .getServletContext());
                }
            }
        }
    }
}