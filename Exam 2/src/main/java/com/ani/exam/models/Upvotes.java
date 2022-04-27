//package com.ani.exam.models;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.PrePersist;
//import javax.persistence.PreUpdate;
//import javax.persistence.Table;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//@Entity
//@Table(name="collections")
//public class Upvotes {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    
//    @NotNull
//    @Min(value=0, message="Baby names need upvotes")
//    private Integer likes;
//
//    
//    
////    ---- 1 : M -----
////    needs to have the same var as the "many"
////    @OneToMany(mappedBy = "collection", fetch = FetchType.LAZY)
////    private List<BabyName> things;
//    
////  @ManyToOne(fetch = FetchType.LAZY)
////  @JoinColumn(name="babyname")
////  private BabyName babyname;
//    //  ==== DON'T FORGET GETTER AND SETTERS ====
//    
//    
//    // This will not allow the createdAt column to be updated after creation
//    @Column(updatable=false)
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private Date createdAt;
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private Date updatedAt;
//    
////    --- CONSTRUCTOR --
////    always have an empty constructor
//    public Upvotes() {}
////----------------    
//    // other getters and setters removed for brevity
//    @PrePersist
//    protected void onCreate(){
//        this.createdAt = new Date();
//    }
//    @PreUpdate
//    protected void onUpdate(){
//        this.updatedAt = new Date();
//    }
//    
////  --- GETTERS AND SETTERS
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Integer getLikes() {
//		return likes;
//	}
//
//	public void setLikes(Integer likes) {
//		this.likes = likes;
//	}
//
//	public List<BabyName> getThings() {
//		return things;
//	}
//
//	public void setThings(List<BabyName> things) {
//		this.things = things;
//	}
//    
//    
//}
