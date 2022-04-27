package com.ani.exam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="names")
public class BabyName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 5, max = 200, message = "Baby must have a name")
    private String name;
    
    @NotNull
    @Size(min = 5, max = 200, message = "Name must have a meaning!")
    private String meaning;
    
    @NotNull
    @Size(min = 1, max = 200, message = "Name must have a typical gender")
    private String gender;
	
    @NotNull
    @Size(min = 5, max = 200, message = "Name must have an origin")
    private String origin;
    //    M : 1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User owner;
//  ==== DON'T FORGET GETTER AND SETTERS ====
   

//    ---- M : 1 ----
//    @OneToMany(mappedBy = "collection", fetch = FetchType.LAZY)
//    private List<BabyName> things;
//    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="collection")
//    private Collection collection;
    //  ==== DON'T FORGET GETTER AND SETTERS ====
    
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

//    -----------------------
//    CONSTRUCTOR
    public BabyName() {}
//    -----------------------
    
    // other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
//    ---- GETTERS AND SETTERS -----
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

//	public Upvotes getCollection() {
//		return collection;
//	}
//
//	public void setCollection(Upvotes collection) {
//		this.collection = collection;
//	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
    
}
