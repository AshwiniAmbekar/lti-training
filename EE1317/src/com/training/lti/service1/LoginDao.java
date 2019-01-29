package com.training.lti.service1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDao{ 
	
/*public  boolean isValid(String username,String password)  {
	
			Connection con=null;
			PreparedStatement pst=null; //precompiled sql statement
			ResultSet rs=null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
				
				String sql="select active from login where uname=? and pwd=?";
				pst=con.prepareStatement(sql);
				pst.setString(1, username);
				pst.setString(2, password);
				rs=pst.executeQuery();
				
				if(rs.next()) {
					String active=rs.getString("active");
					if(active.equals("y"))
						return true;
				}
				return false;
			}
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return false;
			}
			finally {
				 try {rs.close();} catch(Exception e) { }
				try {pst.close();} catch(Exception e) { }
				try {con.close();} catch(Exception e) { }
			
			}
}
*/

public  boolean newUser(String name,String address,String email)  {
	
	Connection con=null;
	PreparedStatement pst=null; //precompiled sql statement
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		
		String sql="insert into reg values(?,?,?)";
		pst=con.prepareStatement(sql);
		pst.setString(1, name);
		pst.setString(2, address);
		pst.setString(3,email);
		pst.execute();
		return true;
	}
	catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		return false;
	}
	finally {
		
		try {pst.close();} catch(Exception e) { }
		try {con.close();} catch(Exception e) { }
	
	}

}
}