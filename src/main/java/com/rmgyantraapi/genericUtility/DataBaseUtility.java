package com.rmgyantraapi.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
/**
 * 
 * @author ARIJIT
 *
 */
public class DataBaseUtility {
	static Connection con;
	static ResultSet result;
	static Driver driver;
	
	/**
	 * Connection with database is established
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {
		try{
			driver=new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection(IConstants.db_path,IConstants.username, IConstants.password);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * DB connection is Closed
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		con.close();
	}
	
	/**
	 * This method returns the data wrt to column Index
	 * @param query
	 * @param Columnindex
	 * @return
	 * @throws SQLException
	 */
	public String getDataFromDb(String query,int Columnindex) throws SQLException {
		String value=null;
		result=con.createStatement().executeQuery(query);
		while(result.next()) {
			value=result.getString(Columnindex);
		}
		return value;
		
	}
	
	public String executeQueryAndGetDataFromDB(String query,int columnName,String expectedData) throws Throwable {
		boolean flag=false;
		result=con.createStatement().executeQuery(query);
		while(result.next()) {
			if(result.getString(columnName).equalsIgnoreCase(expectedData)) {
				flag=true;
				break;
			}
		}
			if(flag) {
				System.out.println(expectedData+"-->data verified in database");
				return expectedData;
			}else {
				System.out.println(expectedData+"-->data is not verified in the database");
				return expectedData;
			}
		
		
	}
}
