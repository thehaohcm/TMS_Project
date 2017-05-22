package org.fsoft.tms.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by thehaohcm on 5/22/17.
 */

@Embeddable
public class UserPropertyKey implements Serializable {


    private User user;

    private Property property;

    public UserPropertyKey() {
    }

    public UserPropertyKey(User user, Property property) {
        this.user = user;
        this.property = property;
    }
}
