package org.fsoft.tms.entity;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by thehaohcm on 5/19/17.
 */
@Entity
@Table(name="Permissions")
public class Permission {

    private Integer id;

    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "permissions")
    private Set<Role> roles;

    public Permission(){

    }

    public Permission(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="DESCRIPTION", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //@ManyToMany(mappedBy = "permissions")
//    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "permissions")
//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
}
