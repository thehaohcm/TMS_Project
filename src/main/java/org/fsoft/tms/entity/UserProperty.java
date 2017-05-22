package org.fsoft.tms.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by thehaohcm on 5/22/17.
 */
@Entity
@Table(name="USER_PROPERTIES")
public class UserProperty implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name="USERID",nullable = false)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name="PROPERTYID",nullable = false)
    private Property property;

    @Column(name="VALUE",nullable = false)
    private String value;

    public UserProperty(){

    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

//    public Property getProperty() {
//        return property;
//    }
//
//    public void setProperty(Property property) {
//        this.property = property;
//    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
