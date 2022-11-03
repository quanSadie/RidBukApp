package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AccountDAO;
import DBConnect.DBUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("loginUn");
		String password = request.getParameter("loginPw");
		AccountDAO dao = new AccountDAO();
		Boolean check = dao.login(username, password);
		String current_name = "";
		String current_id = "";
		String current_mail = "";
		String current_username = "";
		int current_vipAcc = -1;
		int current_role = -1;
		DBUtils db = DBUtils.getInstance();
		String sql = "select * from users";
		Connection con = null;
		if (check) {
			try {
				con = db.getConnection();
				PreparedStatement statement = con.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					if (rs.getString("username").equals(username)) {

						current_name = rs.getString("fullname");
						current_id = rs.getString("user_id");
						current_mail = rs.getString("userEmail");
						current_username = rs.getString("username");
						current_role = rs.getInt("role");
						current_vipAcc = rs.getInt("statusAcc");
					}
				}
			} catch (Exception e) {
				Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
			} finally {
				try {
					DBUtils.closeConnection(con);
				} catch (SQLException e) {
					Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
				}
			}

			HttpSession session = request.getSession();
			session.setAttribute("this_name", current_name);
			session.setAttribute("this_email", current_mail);
			session.setAttribute("this_id", current_id);
			session.setAttribute("this_username", current_username);
			session.setAttribute("this_role", current_role + "");
			session.setAttribute("this_vip", current_vipAcc);
			if (current_role == 2) {
				response.sendRedirect("admin-page.jsp");
				// neu ten dang nhap va mat khau dung va la admin -> chuyen den trang admin
			} else if (current_role == 0) {
				response.sendRedirect("index.jsp");
			} else if (current_role == 1) {
				response.sendRedirect("StaffBookServlet");
			}

		} else {
			// dang nhap that bai(sai mk hoac username)
			HttpSession session = request.getSession();
			session.setAttribute("error", "Login failed!");
			response.sendRedirect("login.jsp");
		}
	}

}
