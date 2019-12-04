package com.hank.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @auther 李先涛
 * @create 2019-12-04 16:11
 */
public class LoginFilter extends  ZuulFilter {
    /**
     *
     * pre
     * routing
     * post
     * error
     * @return
     */
    @Override
    public String filterType() {

        return "pre";
    }

    /**
     *数值越小，执行顺序越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     *true 有效
     * false 无效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *
     * @return
     * @throws ZuulException
     * 过滤器的业务处理
     */
    @Override
    public Object run() throws ZuulException {
       //zuul 提供获取当前上下文对象
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        if (token==null||token==""){
            //未鉴权进行拦截
          ctx.setSendZuulResponse(false);
          ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        //验证通过，放行
        return null;
    }
}
