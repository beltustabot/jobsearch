package com.beltustabot.jobsearch.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="jobs")
public class Job {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @NotNull
    @Size(min = 2, message= "name  must not be null")
    private String title;
    
    
    @NotNull
    @Size(min = 2 ,message= "description must not be null")
    private String description;
    
    @NotNull
    @Size(min = 2 ,message= "location must not be null")
    private String location;
    
    @NotNull
    @Size(min = 2 ,message= "salary must not be null")
    private Long salary;  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "user_id")
    private User user ;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	public Job() {

	}
	


	public Job(Long id, @NotNull @Size(min = 2, message = "name  must not be null") String title,
			@NotNull @Size(min = 2, message = "description must not be null") String description,
			@NotNull @Size(min = 2, message = "location must not be null") String location,
			@NotNull @Size(min = 2, message = "salary must not be null") Long salary, User user, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
		this.salary = salary;
		this.user = user;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	@PreUpdate
    protected void onUpdate(){
        this.setUpdatedAt(new Date());
    }
	@PrePersist
	protected void onCreate(){
		this.setCreatedAt(new Date());
	}
    /// //////Getters and setters////////


	public Long getId() {
		return id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public Long getSalary() {
		return salary;
	}



	public void setSalary(Long salary) {
		this.salary = salary;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public void setId(Long id) {
		this.id = id;
	}
	
}


	