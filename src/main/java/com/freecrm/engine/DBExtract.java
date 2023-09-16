package com.freecrm.engine;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DBExtract {

	private static Connection conn;
	private static CachedRowSet cachedRowset;
	private static Statement stmt;
	
	@SuppressWarnings("finally")
	public static CachedRowSet extractRecords(String group) {
		ResultSet resultSet = null;
		ResultSetMetaData rsmd = null;
		Properties prop = new Properties();
		InputStream iStream = null;
		
		String dbURL = null;
		String dbUName = null;
		String dbPwd = null;
		
		System.out.println("Group is: " + group);
		
		/***Create Connection, Statement and Resulset objects and execute SQL Query and fetch metadata***/
		
		try {
			iStream = DBExtract.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			prop.load(iStream);
			
			dbURL = prop.getProperty("DB_URL");
			dbUName = prop.getProperty("DB_UNAME");
			dbPwd = prop.getProperty("DB_PASSWORD");
			
			conn = DriverManager.getConnection(dbURL, dbUName, dbPwd);
			stmt = conn.createStatement();
			
			resultSet = stmt.executeQuery("select A.TestCaseID, A.TestStepID, A.ActionKey, A.Expected, B.Xpath, C.DataKey from testcases A left outer join object_repository B on A.ORID=B.ORID left outer join testdata C on A.TestCaseID=C.TestCaseID and A.TestStepID=C.TestStepID left outer join object_repository D on A.ORID=D.ORID where A.TestCaseID in (select TestCaseID from testconfig TC where TC.Execute='Y' and TC.Group='"+group+"') order by A.TestStepID asc");
			
			rsmd = resultSet.getMetaData();
			
			RowSetFactory rsFactory = RowSetProvider.newFactory();
			cachedRowset = rsFactory.createCachedRowSet();
			cachedRowset.populate(resultSet);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				System.out.println("Closing Connection");
				
				stmt.close();
				resultSet.close();
				conn.close();
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return cachedRowset;
		}
	}

}
