package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")

public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		// xoa het cac gia tri dc truyen di trong session va ket thuc session
		session.removeAttribute("this_name");
		session.removeAttribute("this_email");
		session.removeAttribute("this_id");
		session.removeAttribute("this_username");
		session.removeAttribute("this_role");
		session.removeAttribute("this_vip");
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
}
