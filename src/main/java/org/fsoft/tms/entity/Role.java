package org.fsoft.tms.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by thehaohcm on 5/18/17.
 */
@Entity
@Table(name="ROLES")
public class Role {

    private Integer id;


    private String name;

    private Set<Permission> permissions;

    //forgein key
    @OneToMany(mappedBy = "userrole",cascade = CascadeType.REMOVE)
    private Set<User> users;

    public Role(){

    }

//    public Role(String name) {
//        this.name = name;
//
//    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)//CascadeType.MERGE)
    @JoinTable(name = "ROLE_PERMISSIONS", joinColumns = { @JoinColumn(name = "ROLEID", referencedColumnName = "ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "PERMISSIONID", referencedColumnName = "ID", nullable = false, updatable = false) })
    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }


//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUser(Set<User> users) {
//        this.users = users;
//    }
}
