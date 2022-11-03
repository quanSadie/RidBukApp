package DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import DBConnect.DBUtils;
import Model.Book;

public class BookDAO {

	// -------------------------- Doc du lieu JSON tu URL --------------------------
	public static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}
	// ----------------------------------------------------------------------------

	// ---------------- Lay thong tin sach cua nguoi dung ----------------
	public ArrayList<String> getUsersBooks(String id) {
		ArrayList<String> list = new ArrayList<String>();
		DBUtils db = DBUtils.getInstance();
		String sql = "select * from users inner join users_books on users.user_id = users_books.user_id where users.user_id=?";
		Connection con = null;
		try {
			con = db.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("book_isbn"));
			}
		} catch (Exception e) {
			Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		return list;
	}

	// -------------------------- Tim sach theo tu khoa --------------------------
	public ArrayList<Book> searchBooks(String searchKey) throws JSONException, IOException {
		ArrayList<Book> list = new ArrayList<Book>();
		Random rd = new Random();
		String url = "https://www.googleapis.com/books/v1/volumes?q=";
		JSONObject json = readJsonFromUrl(url + searchKey);
		JSONArray arr = json.getJSONArray("items");
		try {
			for (int i = 0; i < arr.length(); i++) {
				int pr = rd.nextInt(100 - 10 + 1) + 10;
				Book b = new Book(arr.getJSONObject(i).getJSONObject("volumeInfo").getString("title"),
						arr.getJSONObject(i).getJSONObject("volumeInfo").getJSONObject("imageLinks")
								.getString("thumbnail"),
						(String) arr.getJSONObject(i).getJSONObject("volumeInfo").getJSONArray("authors").get(0), "",
						pr + "$", arr.getJSONObject(i).getJSONObject("volumeInfo").getString("description"),
						arr.getJSONObject(i).getJSONObject("volumeInfo").getJSONArray("industryIdentifiers")
								.getJSONObject(0).getString("identifier"),
						arr.getJSONObject(i).getJSONObject("volumeInfo").getString("previewLink"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	// --------------------------------------------------------------------------------

	// ----------------------- Hien thi chi tiet sach ---------------------------
	public Book showBookDetail(String isbn_13) throws JSONException, IOException {
		Random rd = new Random();
		Book b = new Book();
		String url = "https://www.googleapis.com/books/v1/volumes?q=isbn:";
		JSONObject json = readJsonFromUrl(url + isbn_13);
		JSONArray arr = json.getJSONArray("items");
		for (int i = 0; i < arr.length(); i++) {
			int pr = rd.nextInt(100 - 10 + 1) + 10;
			b.setTitle(arr.getJSONObject(i).getJSONObject("volumeInfo").getString("title"));
			b.setDescription(arr.getJSONObject(i).getJSONObject("volumeInfo").getString("description"));
			b.setImageUrl(arr.getJSONObject(i).getJSONObject("volumeInfo").getJSONObject("imageLinks")
					.getString("thumbnail"));
			b.setIsbn(isbn_13);
			b.setPrice(pr + "");
			b.setReadLink(arr.getJSONObject(i).getJSONObject("volumeInfo").getString("previewLink"));
		}
		return b;
	}

	// ---------------- Them user,book vao database ----------------
	public void addUser_Book(int user_id, String isbn) {
		DBUtils db = DBUtils.getInstance();
		String sql = "insert into users_books(user_id, book_isbn) values(?,?);";
		Connection con = null;
		try {
			con = db.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, user_id);
			statement.setString(2, isbn);
			statement.executeUpdate();
		} catch (Exception e) {
			Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}

	// kiem tra xem nguoi dung co sach hay khong

	public boolean owned(String id, String isbn) throws JSONException, IOException {
		ArrayList<String> list = new ArrayList<String>();
		DBUtils db = DBUtils.getInstance();
		String sql = "select * from users inner join users_books on users.user_id = users_books.user_id where users.user_id=?";
		Connection con = null;
		try {
			con = db.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("book_isbn"));
			}
		} catch (Exception e) {
			Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		for (String i : list) {
			if (i.equals(isbn)) {
				return true;
			}
		}
		return false;
	}

}
