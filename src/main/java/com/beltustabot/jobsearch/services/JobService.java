package com.beltustabot.jobsearch.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beltustabot.jobsearch.models.Job;
import com.beltustabot.jobsearch.repositories.JobRepository;

@Service
public class JobService {
	@Autowired
	private JobRepository jobRepo;

	
	//create
	public Job createJob(Job job) {
		return jobRepo.save(job);
	}
	
	
	// all jobs
	 public List<Job> allJobs(){
		 return jobRepo.findAll();
		 
		 
	 }
	
	
	// find one job
	 public Job oneJob(Long id) {
		 Optional<Job> optionalJob = jobRepo.findById(id);
		 if(optionalJob.isPresent()) {
		 return optionalJob.get();
		 }else {
			 return null;
		 }
	 }
	 //edit
	 public Job editJob(Job job) {
		 return jobRepo.save(job);
	 }
	
	//delete
	 public void deleteJob(Long id){
		 jobRepo.deleteById(id);
	 }
	


}
