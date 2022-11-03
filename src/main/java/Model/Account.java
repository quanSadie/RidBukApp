package Model;

public class Account {
	private String userID;
	private String userEmail;
	private String userName;
	private String password;
	private int roleID;
	private String fullName;
	private int statusAcc;

	public Account() {

	}

	public Account(String userID, String userEmail, String userName, String password, int roleID, String fullName,
			int statusAcc) {
		this.userID = userID;
		this.userEmail = userEmail;
		this.userName = userName;
		this.password = password;
		this.roleID = roleID;
		this.fullName = fullName;
		this.statusAcc = statusAcc;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getStatusAcc() {
		return statusAcc;
	}

	public void setStatusAcc(int statusAcc) {
		this.statusAcc = statusAcc;
	}

	@Override
	public String toString() {
		return "Name: " + fullName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
