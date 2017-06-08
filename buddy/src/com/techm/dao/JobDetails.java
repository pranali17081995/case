package com.techm.dao;

import java.util.List;

import com.techm.beans.Job;
import com.techm.beans.budy;

public interface JobDetails {
	
	public boolean addjob(Job job);
	public boolean modifyJob(Job job);
	public boolean deleteJob(int jcode);
	public Job getJob(int jcode);
	public boolean refbuddy(budy b);
	List<Job>display();
	

}