package org.fsoft.tms.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by thehaohcm on 5/19/17.
 */
@Entity(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID",nullable = false)
    private Integer id;

    @Column(name="USERNAME",nullable = false)
    private String username;

    @Column(name="PASS",nullable = false)
    private String password;

    @Column(name="MANAGERID")
    private Integer managerID;

    @Column(name="ACTIVE", nullable = true)
    private Boolean active;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getManagerID() {
        return managerID;
    }

    public void setManagerID(Integer managerID) {
        this.managerID = managerID;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<UserProperty> getUserProperties() {
        return userProperties;
    }

    public void setUserProperties(Set<UserProperty> userProperties) {
        this.userProperties = userProperties;
    }

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
