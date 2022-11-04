package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AccountDAO;

/**
 * Servlet implementation class ChangePass
 */
@WebServlet("/changePass")
public class ChangePass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountDAO dao = new AccountDAO();
		String pid = request.getParameter("person_idd");
		String newPass = request.getParameter("newPassword");
		dao.updPass(pid, newPass);
		HttpSession session = request.getSession();
		response.sendRedirect("userPage.jsp");
	}

}
