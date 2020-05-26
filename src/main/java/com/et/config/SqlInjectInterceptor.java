package com.et.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class SqlInjectInterceptor implements HandlerInterceptor {
    /*
    Credit: https://blog.csdn.net/lj1548259095/article/details/53405088
     */
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
        // TODO Auto-generated method stub
        if(arg0.getRequestURI().contains("CheckAcc")){
            Enumeration<String> names = arg0.getParameterNames();
            while(names.hasMoreElements()){
                String name = names.nextElement();
                String[] values = arg0.getParameterValues(name);
                for(String value: values){
                    if(judgeXSS(value.toLowerCase())){
                        arg1.setContentType("text/html;charset=UTF-8");
                        arg1.getWriter().print("参数含有非法攻击字符,已禁止继续访问！");
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean judgeXSS(String value){
        if(value == null || "".equals(value)){
            return false;
        }
        String xssStr = "and|or|select|update|delete|drop|truncate|%20|=|-|--|;|'|%|#|+|,|//|/| |\\|!=|(|)";
        String[] xssArr = xssStr.split("\\|");
        for (String s : xssArr) {
            if (value.contains(s)) {
                return true;
            }
        }
        return false;

    }

}
