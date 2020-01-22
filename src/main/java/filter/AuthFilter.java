//package filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebFilter(urlPatterns = {"/*"})
//public class AuthFilter implements Filter {
//    private List<String> adminUrls = new ArrayList<>();
//    private List<String> userUrls = new ArrayList<>();
//    private List<String> freeUrls = new ArrayList<>();
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        adminUrls.add("/admin");
//        freeUrls.add("/");
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//        String requestURI = req.getRequestURI();
//        if (freeUrls.contains(requestURI)) {
//            chain.doFilter(request, response);
//        } else {
//            boolean checkAuth = false;
//            if (adminUrls.contains(requestURI)) {
//                checkAuth..getUserType() != UserType.ADMIN;
//            } else if (userUrls.contains(requestURI)) {
//                checkAuth = user == null;
//            }
//            if (checkAuth) {
//                resp.sendRedirect("login.jsp");
//            } else {
//                chain.doFilter(request, response);
//            }
//        }
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
