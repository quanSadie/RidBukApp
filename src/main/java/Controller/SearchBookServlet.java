package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BookDAO;
import Model.Book;

/**
 * Servlet implementation class SearchBookServlet
 */
@WebServlet("/SearchBookServlet")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookDAO dao = new BookDAO();
		ArrayList<Book> list = new ArrayList<Book>();

		list = dao.searchBooks(request.getParameter("searchinfo"));

		HttpSession session = request.getSession();
		request.setAttribute("searchKey", request.getParameter("searchinfo"));
		request.setAttribute("mylist", list);
		request.getRequestDispatcher("search-page.jsp").forward(request, response);
	}

}
