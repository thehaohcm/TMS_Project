package org.fsoft.tms.entity;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Set;

/**
 * Created by thehaohcm on 5/22/17.
 */
@Entity
@Table(name="PROPERTIES")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="DESCRIPTION",nullable = true)
    private String description;

    @OneToMany(mappedBy = "property")
    private Set<UserProperty> userProperties;

    public Property(){

    }

    public Property(String name, String description) {
        this.name = name;
        this.description = description;
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

//    public Set<UserProperty> getUserProperties() {
//        return userProperties;
//    }
//
//    public void setUserProperties(Set<UserProperty> userProperties) {
//        this.userProperties = userProperties;
//    }
}
