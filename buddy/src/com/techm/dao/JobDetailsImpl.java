package com.techm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.techm.beans.Job;
import com.techm.beans.budy;
import com.techm.util.JdbcConnection;

public class JobDetailsImpl implements JobDetails{

	public boolean addjob(Job job) {
		Connection con = JdbcConnection.getConnection();
		try {

			PreparedStatement pst=con.prepareStatement("insert into job_details values(?,?,?,?,?,?)");
			pst.setInt(1, job.getJcode());
			pst.setString(2, job.getSkill());
			pst.setString(3, job.getYoe());
			pst.setString(4, job.getLocation());
			pst.setString(5, job.getSname());
			pst.setString(6, job.getSmail());

			int rec=pst.executeUpdate();
			if(rec==1){
				return true;
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

		return false;
	}

	public boolean modifyJob(Job job) {
		Connection con = JdbcConnection.getConnection();

		try {
			PreparedStatement pst=con.prepareStatement("update job_details set skill=?,experience=?,location=?,sname=?,smail=? where j_code=?");

			pst.setString(1, job.getSkill());
			pst.setString(2, job.getYoe());
			pst.setString(3, job.getLocation());
			pst.setString(4, job.getSname());
			pst.setString(5, job.getSmail());
			pst.setInt(6, job.getJcode());
			int rs = pst.executeUpdate();
			if(rs==1){
				return true;	
			}
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
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
		}
		return false;
	}

	public boolean deleteJob(int jcode) {
		Connection con=JdbcConnection.getConnection();
		String query="delete from job_details where j_code=?";
		int rs= 0;
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1, jcode);
			rs = pst.executeUpdate();
			if(rs==1){
				return true;
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
		return false;
	}



	public Job getJob(int jcode) {
		Connection con=JdbcConnection.getConnection();
		String query="select * from job_details where j_code=?";
		ResultSet rs= null;
		Job j=null;
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,jcode);
			rs=pst.executeQuery();

			while(rs.next()){
				int j_code=rs.getInt(1);
				String skill=rs.getString(2);
				String yoe=rs.getString(3);
				String loc=rs.getString(4);
				String sname=rs.getString(5);
				String smail=rs.getString(6);
				j=new Job(j_code, skill, yoe, loc, sname, smail);

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
		return j;
	}
	public boolean refbuddy( budy b)
	{
		Connection con=JdbcConnection.getConnection();
		try {
			PreparedStatement pst=con.prepareStatement("insert into buddy values(?,?,?,?,?,?,?)");
			pst.setInt(1, b.getJ_code());
			pst.setString(2, b.getName());
			pst.setString(3, b.getSkill());
			pst.setInt(4, b.getYoe());
			pst.setString(5, b.getLocation());
			pst.setString(6, b.getStatus());
			pst.setString(7, b.getMail());
			System.out.println(b.getJ_code()+b.getName()+b.getSkill()+b.getYoe()+b.getStatus()+b.getLocation()+b.getMail());
			int rec=pst.executeUpdate();
			if(rec==1){
				return true;
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
		
	}
	
	public List<Job> display() {
		Connection con=JdbcConnection.getConnection();
		String query="select * from job_details";
		ArrayList<Job> aList=new ArrayList<Job>();

		try {
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();


			while(rs.next()){
				int j_code=rs.getInt(1);
				String skill=rs.getString(2);
				String yoe=rs.getString(3);
				String loc=rs.getString(4);
				String sname=rs.getString(5);
				String smail=rs.getString(6);
				Job j = new Job(j_code, skill, yoe, loc, sname, smail);

				aList.add(j);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aList;
	}


}
