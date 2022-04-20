package com.ani.safetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="expense")
public class Expense{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 200, message="must have expense")
    private String it;
    @NotNull
    @Size(min = 5, max = 200, message="must have description")
    private String description;
    @NotNull
	@Size(min = 3, max = 40, message="must have vendor")
    private String vendor;
    @Min(value=1, message="must have amount")
    private Integer amount;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Expense() {
    }
    public Expense(String it, String description, String vendor, int amount) {
        this.it = it;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }
    public Long getId() {
  		return id;
  	}
  	public void setId(Long id) {
  		this.id = id;
  	}
  	public String getIt() {
  		return it;
  	}
  	public void setIt(String it) {
  		this.it = it;
  	}
  	public String getDescription() {
  		return description;
  	}
  	public void setDescription(String description) {
  		this.description = description;
  	}
  	public String getVendor() {
  		return vendor;
  	}
  	public void setVendor(String vendor) {
  		this.vendor = vendor;
  	}
  	public Integer getAmount() {
  		return amount;
  	}
  	public void setAmount(Integer amount) {
  		this.amount = amount;
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
    
    // other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
