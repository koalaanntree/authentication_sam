package com.sam.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: huangxin
 * @Date: Created in 下午3:20 2018/2/26
 * @Description: 局限性，不知道哪个类哪个方法触发的，只有请求和响应信息
 */
//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("time filter start");
        long start = System.currentTimeMillis();


        chain.doFilter(request,response);

        System.out.println("time filter 耗时: " +(System.currentTimeMillis()-start));
        System.out.println("time filter finish");

    }

    @Override
    public void destroy() {
        System.out.println("time filter destroy");

    }
}
