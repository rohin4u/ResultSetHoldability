package com;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test2 {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","password");
				Statement st =con.createStatement();
				System.out.println("Type :"+st.getResultSetType());
				System.out.println("Concurrency :"+st.getResultSetConcurrency());
				System.out.println("Holdability:"+st.getResultSetHoldability());

	}

}
