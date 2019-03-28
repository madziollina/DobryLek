package pl.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"})
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req; //bo u gory typ bardziej ogolny
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();
        String uri = request.getRequestURI();

        if(session.getAttribute("user") == null && !uri.equals("/user/login") && !uri.equals("/user/form") &&
                !uri.equals("/css/sb-admin-2.min.css") && !uri.startsWith("/resources/") && !uri.startsWith("/home/")){
            response.sendRedirect(request.getContextPath()+"/home/home");
            return;
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
