package org.fsoft.tms.entity;

import javax.persistence.*;

/**
 * Created by thehaohcm on 5/21/17.
 */
@Entity
@Table(name="TOPICS")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID",nullable = false)
    private Integer id;

    @Column(name="TITLE",nullable = false)
    private String title;

    @Column(name="CONTENT",nullable = true)
    private String content;

    //forgein key
    //Course-Topic
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="COURSEID",nullable = false,updatable = false)
    private Course course;

    //Course_Trainer-Topic
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="COURSETRAINERID",nullable = false,updatable = false)
//    private CourseTrainer topic_coursetrainer;

    public Topic(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
