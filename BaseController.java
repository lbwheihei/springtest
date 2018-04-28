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
