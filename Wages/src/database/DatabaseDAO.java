package database;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.wages.beans.WageSlip;

/*Below code needs to be pasted in the Tomcat context.xml file.
  <Resource name="jdbc/web_apps" global="jdbc/web_apps"
  auth="Container" type="javax.sql.DataSource" username="root" password="study"
  driverClassName="com.mysql.jdbc.Driver"
  url="jdbc:mysql://localhost:3306/web_apps"
  maxActive="100" maxIdle="30" maxWait="10000" /> 
 */

/**
 * Connects to the database.
 * Used to check for valid users.
 * Uses a datasource pool to connect.
 * @return Connection
 * @author Justin Alderson
 */

public class DatabaseDAO implements AutoCloseable {

	protected Connection con;
	private Context init;
	private DataSource datasource;
	protected ResultSet resultSet;
	private PreparedStatement preparedStatement;

	public Connection getConnection() throws SQLException, NamingException {

		init = new InitialContext();
		datasource = (DataSource) init.lookup("java:comp/env/jdbc/web_apps");
		con = datasource.getConnection();

		return con;
	}

	
	/**
	 * Find the user in database, confirm user is valid.
	 */
	public boolean checkUserPassword(String name, String password) throws SQLException {
		
		resultSet = con.createStatement().executeQuery("select * from my_workers");
		while (resultSet.next()) {
			String user = resultSet.getString(2);
			System.out.println(user);
			String userPassword = resultSet.getString(3);;
			System.out.println(userPassword);
			if(user.equals(name) & userPassword.equals(password)) {
				return true;
			}
		}
		return false;

	}
	
	/**
	 * Find the user and month wage slip.
	 * @param User name
	 * @param Month of requested wage slip.
	 * @return WageSlip object.
	 */
	public WageSlip findWages(String name, String month) throws SQLException {
		
		resultSet = con.createStatement().executeQuery("select * from wages");
		while (resultSet.next()) {
			String user = resultSet.getString(2);
			String monthFound = resultSet.getString(3);;
			
			if(user.equals(name) & monthFound.equals(month)) {
				int health = resultSet.getInt(4);
				int tax = resultSet.getInt(5);
				int overtime = resultSet.getInt(6);
				int hw = resultSet.getInt(7);
				int ow = resultSet.getInt(8);
				int shift = resultSet.getInt(9);
				int reg = resultSet.getInt(10);
				int base = resultSet.getInt(11);
				int total = resultSet.getInt(12);
				int actual = resultSet.getInt(13);
				return new WageSlip(user,monthFound,health,tax,overtime,hw,ow,shift,reg,base,total,actual);
			}
		}
		return null;

	}


	/**
	 * Gets the size of the database.
	 * 
	 * @return integer
	 * @throws SQLException
	 */
	public int getDBsize() throws SQLException {
		int num = 0;
		resultSet = con.createStatement().executeQuery("select * from my_workers");
		while (resultSet.next()) {

			num++;
		}
		return num;

	}

	/**
	 * Close database connection.
	 */
	@Override
	public void close() throws Exception {
		if (preparedStatement != null) {
			preparedStatement.close();
		}

		if (resultSet != null) {
			resultSet.close();
		}

		if (con != null) {
			con.close();
		}

	}

}
