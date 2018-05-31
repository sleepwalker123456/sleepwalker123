package com.example.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义路由过滤器
 */
@Component
public class PreFilter extends ZuulFilter{

    private static Logger logger = LoggerFactory.getLogger(PreFilter.class);

    /**
     * 返回一个字符串代表路由器的类型，Zuul定义了四种不同生命周期的过滤器类型：
     *      pre：可以在请求被路由之前被调用
     *      route：在路由请求时被调用
     *      post：在route和error过滤器之后被调用
     *      error：处理请求发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器优先级，数字越大，优先级越低
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行该过滤器，此处为true，说明需要执行该过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     */
    @Override
    public Object run() {
        logger.info("========================PreFilter=======================");
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        logger.info(String.format("%s >>> %s",request.getMethod(),request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");//获取请求的参数
        if(accessToken == null){
            logger.warn("token is empty!!!");
            requestContext.setSendZuulResponse(false);//过滤请求
            requestContext.setResponseStatusCode(8888);//设置返回的错误码
            try {
                requestContext.getResponse().getWriter().write("token is empty!!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.info("ok!!!");
        return null;
    }
}
