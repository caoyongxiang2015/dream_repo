package com.env.web.servlet;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 自定义DispatcherServlet
 * 
 * @author caoyongxiang
 * @version [版本号, 2014-11-11]
 * @see DispatcherServlet（可选）
 */
public class EnvDispatcherServlet extends DispatcherServlet {
    /**
     * 自定义DispathcerServlet，解决乱码
     */
    private static final long serialVersionUID = 1L;
    private String encoding;

    public void init(ServletConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
        super.init(config);
    }

    protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            request.setCharacterEncoding(encoding);
            super.doService(request, response);
        } catch (Exception ex) {

        }
    }

    private static List<ModelAndView> modeAndViews = new ArrayList<ModelAndView>(100);

    static {
        for (int i = 0; i < 100; i++) { // 缓存量为100
            modeAndViews.add(new ModelAndView());
        }
    }

    public void render(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            super.render(mv, request, response);
            releaseModelAndView(mv);
        } catch (Exception e) {

        }

    }

    /**
     * 回收ModelAndView
     * 
     * @param
     * @param
     */
    private void releaseModelAndView(ModelAndView mv) {
        mv.clear();
        mv.getModelMap().clear();
        synchronized (modeAndViews) {
            modeAndViews.add(mv);
        }
    }

    /**
     * 获得ModelAndView
     * 
     * @param
     * @param
     */
    public static ModelAndView getModeAndView() {
        synchronized (modeAndViews) {
            if (modeAndViews.size() > 0)
                return modeAndViews.remove(0);
            else
                return new ModelAndView();
        }
    }

}
