package com.Gowfy.Dao;

import java.util.List;

import com.Gowfy.model.Job;

public interface JobDao {
	void saveJob(Job job);
	List<Job> getAllJobs();
	void deleteJob(int id);
	void updateJob(Job job);
	Job getJob(int id);
}
