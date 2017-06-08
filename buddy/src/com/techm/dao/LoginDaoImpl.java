package com.techm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.techm.beans.Login;
import com.techm.util.JdbcConnection;

public class LoginDaoImpl implements LoginDao {

	public String validate(Login login){
		Connection con = null;
		con = JdbcConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs =null;
		
		try {
			pst = con.prepareStatement("select * from login_details where username=? and password=?");
			pst.setString(1,login.getUsername());
			pst.setString(2, login.getPassword());
			rs = pst.executeQuery();
			if(rs.next()){
				String role=rs.getString(4);
				return role;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "invalid" ;	
	}

}
