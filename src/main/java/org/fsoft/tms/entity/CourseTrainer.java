package org.fsoft.tms.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by thehaohcm on 5/22/17.
 */
@Entity
@Table(name="COURSE_TRAINERS")
public class CourseTrainer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    @OneToMany(mappedBy = "topiccoursetrainer",cascade = CascadeType.REMOVE)
    private Set<Topic> topics;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COURSEID",insertable = false,updatable = false)
    private Course coursetrainercouse;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="TRAINERID",insertable = false,updatable=false)
    private User coursetraineruser;

    public CourseTrainer(){

    }

    public User getCoursetraineruser() {
        return coursetraineruser;
    }

    public void setCoursetraineruser(User coursetraineruser) {
        this.coursetraineruser = coursetraineruser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course getCoursetrainercouse() {
        return coursetrainercouse;
    }

    public void setCoursetrainercouse(Course coursetrainercouse) {
        this.coursetrainercouse = coursetrainercouse;
    }
}
