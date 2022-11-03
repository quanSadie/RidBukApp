package Model;

public class Logs {
	private String log_userID;
	private String log_bookisbn;
	private String log_price;
	private String log_time;

	public Logs() {

	}

	public Logs(String log_userID, String log_bookisbn, String log_price, String log_time) {
		super();
		this.log_userID = log_userID;
		this.log_bookisbn = log_bookisbn;
		this.log_price = log_price;
		this.log_time = log_time;
	}

	@Override
	public String toString() {
		return "Logs [log_userID=" + log_userID + ", log_bookisbn=" + log_bookisbn + ", log_price=" + log_price
				+ ", log_time=" + log_time + "]";
	}

	public String getLog_userID() {
		return log_userID;
	}

	public void setLog_userID(String log_userID) {
		this.log_userID = log_userID;
	}

	public String getLog_bookisbn() {
		return log_bookisbn;
	}

	public void setLog_bookisbn(String log_bookisbn) {
		this.log_bookisbn = log_bookisbn;
	}

	public String getLog_price() {
		return log_price;
	}

	public void setLog_price(String log_price) {
		this.log_price = log_price;
	}

	public String getLog_time() {
		return log_time;
	}

	public void setLog_time(String log_time) {
		this.log_time = log_time;
	}
}
