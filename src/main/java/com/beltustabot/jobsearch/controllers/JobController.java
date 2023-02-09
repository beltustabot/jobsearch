package com.beltustabot.jobsearch.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.beltustabot.jobsearch.models.Job;
import com.beltustabot.jobsearch.services.JobService;

@Controller
public class JobController {
	@Autowired
	private  JobService jobService;
	
	
	
	//Create job
		//display the form
		@GetMapping("/jobs/new")
		public String displayNewJobform(@ModelAttribute("job") Job job) {
			return "createJob.jsp";
		}
		
		//process form
	    @PostMapping("/jobs/new")
	    public String processJobForm(@Valid @ModelAttribute("job") Job  job, BindingResult result,Model model){
	    	if(result.hasErrors()) {
	    		return "createJob.jsp";
	    		}else
				jobService.createJob( job);
				return "redirect:/home";
	    }
	    //edit job : 1.get id from path variable 2. get donation from service 3. form
	    //display the form
	    @GetMapping("jobs/edit/{id}")
	    public String displayEditJobForm( @PathVariable("id")Long id, Model model ,HttpSession session) {
	    	Job job = jobService.oneJob(id);
	    	model.addAttribute("job", job);
	    	return "editJob.jsp";
	    }
	    
	    //process
	    @PutMapping("/jobs/edit/{id}")
		public String processUpdate(
				@PathVariable("id") Long id, 
				Model model, 
				@Valid @ModelAttribute("job") Job job, 
				BindingResult result) {
			if(result.hasErrors()) {
				model.addAttribute("job", job);
				return "editJob.jsp";
			}else {
				jobService.editJob(job);
				return "redirect:/home";
			}
			
	    }
	    
		  @DeleteMapping("/jobs/delete/{id}")
		    public String destroy(@PathVariable("id") Long id) {
		        jobService.deleteJob(id);
		        return "redirect:/home";
		    }
		  @GetMapping("/jobs/show/{id}")
		  public String show(@PathVariable("id") Long id, Model model) {
			  Job job = jobService.oneJob(id);
			  model.addAttribute("job", job);
			  return "jobDetails.jsp";
			  
		  }
		


}
