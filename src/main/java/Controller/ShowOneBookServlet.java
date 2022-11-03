package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BookDAO;
import Model.Book;

@WebServlet("/ShowOneBookServlet")
public class ShowOneBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String this_isbn13 = request.getParameter("currentISBN13");
		BookDAO dao = new BookDAO();
		Book b = dao.showBookDetail(this_isbn13);
		HttpSession session = request.getSession();
		if (request.getSession().getAttribute("this_id") != null) {
			boolean own = dao.owned((String) request.getSession().getAttribute("this_id"), this_isbn13);
			session.setAttribute("bookOwned", own);
		}
		session.setAttribute("thisBookDetail", b);
		response.sendRedirect("bookdetail.jsp");
	}

}
