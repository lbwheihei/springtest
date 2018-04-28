public class BaseController {
    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();
    }

    protected HttpServletResponse getResponse() {
        return new ServletWebRequest(((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest()).getResponse();
    }

    protected HttpSession getHttpSession() {
        return getRequest().getSession();
    }

    protected void writeJSON(Object obj) throws IOException {
        getResponse().setContentType("application/json;charset=utf-8");
        getResponse().getWriter().write(JSON.toJSONString(obj));
    }

}

web.xml
      <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <!-- Spring -->
    <listener>
        <listener-class>
            org.springframework.web.context.request.RequestContextListener
        </listener-class>
    </listener>
    
            
            
   <!-- 数据库druid连接池 启用 Web 监控统计功能 start -->
    <filter>
        <filter-name>DruidWebStatFilter</filter-name>
        <filter-class>com.alibaba.druid.support.http.WebStatFilter</filter-class>
        <init-param>
            <param-name>exclusions</param-name>
            <param-value>*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>DruidWebStatFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    <servlet>
        <servlet-name>DruidStatView</servlet-name>
        <servlet-class>com.alibaba.druid.support.http.StatViewServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>DruidStatView</servlet-name>
        <url-pattern>/druid/*</url-pattern>
    </servlet-mapping>
    <!-- 数据库druid连接池 启用 Web 监控统计功能  end -->
