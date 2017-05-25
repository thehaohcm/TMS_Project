package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by thehaohcm on 5/19/17.
 */
@Entity
@Table(name="COURSES")
public class Course {

    private Integer id;

    private String name;

    private String description;

    private Boolean active;

    private Category category_course;

    private User staff;

    private Set<User> trainees;

    private Set<Topic> topics;

    public Course(){

    }

    public Course(String name, String description, Boolean active, Category category_course) {
        this.name = name;
        this.description = description;
        this.active = active;
        this.category_course = category_course;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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

    @ManyToOne
    @JoinColumn(name = "CAT_ID")
    public Category getCategory_course() {
        return category_course;
    }

    public void setCategory_course(Category category_course) {
        this.category_course = category_course;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @ManyToOne
    @JoinColumn(name = "STAFF_ID")
    public User getStaff() {
        return staff;
    }

    public void setStaff(User staff) {
        this.staff = staff;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "COURSES_TRAINEES", joinColumns = {@JoinColumn(name = "COURSE_ID", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "TRAINEE_ID", updatable = false, nullable = false)})
    public Set<User> getTrainees() {
        return trainees;
    }

    public void setTrainees(Set<User> trainees) {
        this.trainees = trainees;
    }

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }
}
