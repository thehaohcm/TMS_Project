package org.fsoft.tms.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by thehaohcm on 5/19/17.
 */
@Entity(name="USERS")
public class User {

    private Integer id;

    private String username;

    private String password;

    private Integer managerID;

    private Boolean active;

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    private Integer roleID;

    //forgein key
    //User-User
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="MANAGERID",insertable = false,updatable = false)
    private User manager;

    //User-User
    @OneToMany(mappedBy = "manager")
    private Set<User> users;

    //User-Role
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ROLEID",insertable = false,updatable = false)
    private Role role;

    //User-Course
    @OneToMany(mappedBy = "user_course",cascade = CascadeType.REMOVE)
    private Set<Course> courses;

    //User-UserProperties
    @OneToMany(mappedBy = "user")
    private Set<UserProperty> userProperties;


    //20h37 - 22-5-2017
    //User-Couser_Trainees
    private Set<Course> usercourses;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="COURSE_TRAINEES", joinColumns = {@JoinColumn(name="TRAINEEID",referencedColumnName = "ID")},inverseJoinColumns = {@JoinColumn(name="COURSEID",referencedColumnName = "ID")})
    public Set<Course> getUsercourses() {
        return usercourses;
    }

    public void setUsercourses(Set<Course> usercourses) {
        this.usercourses = usercourses;
    }

    //User-CourseTrainer
    @OneToMany(mappedBy = "coursetraineruser",cascade = CascadeType.REMOVE)
    private Set<CourseTrainer> courseTrainers;

    public User(){

    }

//    public User(String username, String password, Integer managerID, Boolean active, Set<User> users, User manager, Role role){//, Set<Course> courses) {
//        this.username = username;
//        this.password = password;
//        this.managerID = managerID;
//        this.active = active;
//        this.users = users;
//        this.manager = manager;
//        this.role = role;
//        //this.courses = courses;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID",nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="USERNAME",nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name="PASS",nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="MANAGERID")
    public Integer getManagerID() {
        return managerID;
    }

    public void setManagerID(Integer managerID) {
        this.managerID = managerID;
    }

    @Column(name="ACTIVE", nullable = true)
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

//    public Set<UserProperty> getUserProperties() {
//        return userProperties;
//    }
//
//    public void setUserProperties(Set<UserProperty> userProperties) {
//        this.userProperties = userProperties;
//    }

    //    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }

//    public User getManager() {
//        return manager;
//    }
//
//    public void setManager(User manager) {
//        this.manager = manager;
//    }

//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }

//    public Set<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(Set<Course> courses) {
//        this.courses = courses;
//    }
}
