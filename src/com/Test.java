package com;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","password");
				DatabaseMetaData dbmd=con.getMetaData();
				if(dbmd.supportsResultSetHoldability(1))
				{
				System.out.println("HOLD_CURSORS_OVER_COMMIT");
				}
				if(dbmd.supportsResultSetHoldability(2))
				{
				 System.out.println("CLOSE_CURSORS_AT_COMMIT");
				}

	}

}
