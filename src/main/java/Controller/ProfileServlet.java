package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AccountDAO;
import DAO.BookDAO;
import Model.Account;
import Model.Book;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String thisRole = request.getParameter("role");
		if (thisRole.equals("0")) {
			HttpSession session = request.getSession();
			AccountDAO dao = new AccountDAO();
			BookDAO bdao = new BookDAO();
			Account a = dao.displayOneUser((String) request.getSession().getAttribute("this_id"));
			ArrayList<String> isbnList = bdao.getUsersBooks((String) request.getSession().getAttribute("this_id"));
			ArrayList<Book> blist = new ArrayList<Book>();
			for (String i : isbnList) {
				Book b = (Book) bdao.showBookDetail(i);
				blist.add(b);
			}
			session.setAttribute("ownedBooks", blist);
			session.setAttribute("person", a);
			response.sendRedirect("userPage.jsp");
		} else if (thisRole.equals("1")) {
			HttpSession session = request.getSession();
			response.sendRedirect("StaffBookServlet");
		}
	}

}
