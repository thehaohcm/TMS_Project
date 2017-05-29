package org.fsoft.tms.services;

import org.fsoft.tms.entity.User;
import org.fsoft.tms.entity.UserProperty;

import java.util.List;

/**
 * Created by Isabella on 29-May-2017.
 */
public interface UserPropertyService {

    List<UserProperty> getListUserProperty(User user);

}
