package co.lucjay.newInterface;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CountryDao {
	public Connection conn;

	private String driver;
	private String url;
	private String user;
	private String password;

	private void configuProperties() throws IOException {
		Properties properties = new Properties();
		Reader reader = new FileReader("config/db.properties");
		properties.load(reader);
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
	}

	public CountryDao() { // 여기서 트라이캐치하는게 좋음
		try {
			configuProperties();
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
