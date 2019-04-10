package springcloud;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class TokenFilter extends ZuulFilter {
    private final Logger logger=LoggerFactory.getLogger(TokenFilter.class);
    @Override
    public String filterType(){
        /*过滤器的类型*/
        return  "pre";
            }
     @Override
    public int filterOrder(){
        /*数字越大 优先级越低*/
        return 0;
     }
     @Override
    public boolean shouldFilter(){
//是否执行该过滤器
        return true;
     }
     @Override
    public Object run(){
         RequestContext ctx = RequestContext.getCurrentContext();
         HttpServletRequest request = ctx.getRequest();

         logger.info("--->>> TokenFilter {},{}", request.getMethod(), request.getRequestURL().toString());

         String token = request.getParameter("token");

         if (StringUtils.isNotBlank(token)) {
             ctx.setSendZuulResponse(true); //对请求进行路由
             ctx.setResponseStatusCode(200);
             ctx.set("isSuccess", true);
             return null;
         } else {
             ctx.setSendZuulResponse(false); //不对其进行路由
             ctx.setResponseStatusCode(400);
             ctx.setResponseBody("token is empty");
             ctx.set("isSuccess", false);
             return null;
         }

     }
}
