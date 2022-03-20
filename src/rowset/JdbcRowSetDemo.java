package rowset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetDemo {

	public static void main(String[] args) throws SQLException {
		
		RowSetFactory rsf=RowSetProvider.newFactory();
		JdbcRowSet rs=rsf.createJdbcRowSet();
	

		rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		rs.setUsername("system");
		rs.setPassword("password");
		rs.setCommand("select * from employee");
		rs.execute();
		System.out.println("Employee Details In Forward Direction");
		System.out.println("EMP\tEID\tEADDR");
		System.out.println("----------------------------------");
		while(rs.next()){
		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
		System.out.println("Employee Details In Backward Direction");
		System.out.println("EMP\tEID\tEADDR");
		System.out.println("----------------------------------");
		while(rs.previous()){
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
		System.out.println("Accessing Randomly...");
		rs.absolute(3);
		System.out.println(rs.getRow()+"--->"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		rs.first();
		System.out.println(rs.getRow()+"--->"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		rs.last();
		System.out.println(rs.getRow()+"--->"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		rs.close();		
	}

}
