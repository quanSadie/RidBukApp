package Controller;

import java.io.IOException;

import org.json.JSONException;

import DAO.AccountDAO;

public class run {

	public static void main(String[] args) throws JSONException, IOException {
		AccountDAO dao = new AccountDAO();
		System.out.println(dao.displayOneUser("1"));
	}

}
