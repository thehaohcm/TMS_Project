package org.fsoft.tms.entity;

import org.bouncycastle.asn1.cms.TimeStampAndCRL;

import javax.persistence.*;
import java.security.AllPermission;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

/**
 * Created by thehaohcm on 5/19/17.
 */
@Entity
@Table(name="COURSES")
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID", nullable = false)
    private Integer id;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="DESCRIPTION")//,  nullable = true)
    private String description;

    @Column(name="CREATEDDATE", columnDefinition = "DATE",nullable = false)
    private java.sql.Date createdDate;

    //forgein key
    //Couse-User
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="TRAININGSTAFFID",insertable = false,updatable = false)
    private User user_course;

    //Course-Category
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATID",insertable = false,updatable = false)
    private Category category_course;

    @OneToMany(mappedBy = "course",cascade = CascadeType.REMOVE)
    private Set<Topic> topics;

    public Course(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.sql.Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(java.sql.Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser_course() {
        return user_course;
    }

    public void setUser_course(User user_cousre) {
        this.user_course = user_course;
    }

    public Category getCategory_course() {
        return category_course;
    }

    public void setCategory_course(Category category_course) {
        this.category_course = category_course;
    }

//    public Set<Topic> getTopics() {
//        return topics;
//    }
//
//    public void setTopics(Set<Topic> topics) {
//        this.topics = topics;
//    }

}
