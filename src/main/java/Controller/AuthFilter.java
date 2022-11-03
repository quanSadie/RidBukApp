//package Controller;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.jsp" })
//
//public class AuthFilter implements Filter {
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		// TODO Auto-generated method stub
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpSession session = req.getSession();
//		String userid = null;
//		String user_role = null;
//
//		if (session != null) {
//			userid = (String) session.getAttribute("this_id");
//			user_role = (String) session.getAttribute("this_role");
//		}
//
//		boolean isLoggedIn = (userid != null);
//
//		// Check if the user is accessing login page
//		if (req.getRequestURI().equals(req.getContextPath() + "/login.jsp")) {
//			if (isLoggedIn) {
//				HttpServletResponse res = (HttpServletResponse) response;
//				res.sendRedirect(req.getContextPath() + "/index.jsp");
//			} else {
//				chain.doFilter(request, response);
//			}
//
//		} else if (req.getRequestURI().equals(req.getContextPath() + "/admin-page.jsp")) {
//			if (isLoggedIn && user_role.equals("2")) {
//				chain.doFilter(request, response);
//			} else {
//				HttpServletResponse res = (HttpServletResponse) response;
//				res.sendRedirect(req.getContextPath() + "/index.jsp");
//			}
//		} else if (req.getRequestURI().equals(req.getContextPath() + "/staff.jsp")) {
//			if (isLoggedIn && user_role.equals("1")) {
//				chain.doFilter(request, response);
//			} else {
//				HttpServletResponse res = (HttpServletResponse) response;
//				res.sendRedirect(req.getContextPath() + "/index.jsp");
//			}
//		} else if (req.getRequestURI().equals(req.getContextPath() + "/addbook.jsp")) {
//			if (isLoggedIn && user_role.equals("1")) {
//				chain.doFilter(request, response);
//			} else {
//				HttpServletResponse res = (HttpServletResponse) response;
//				res.sendRedirect(req.getContextPath() + "/index.jsp");
//			}
//		} else {
//			chain.doFilter(request, response);
//		}
//
//	}
//
//	@Override
//	public void init(FilterConfig arg0) throws ServletException {
//		// TODO Auto-generated method stub
//
//	}
//
//}
