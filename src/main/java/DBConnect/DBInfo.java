package DBConnect;

// For security and my privacy, I will not provide database credentials here, you can create your own database
public interface DBInfo {
	public static String driverName = "org.postgresql.Driver";
	public static String url = "jdbc:postgresql://"
			+ "ec2-44-209-57-4.compute-1.amazonaws.com:5432/de7o4n2v5uc074?sslmode=require";
	public static String user = "ssehzzhfgdqxco";
	public static String pass = "faa289c438352b202945a781a1a266e04e95724ae85288a1a5841cdcc8339175";
}
