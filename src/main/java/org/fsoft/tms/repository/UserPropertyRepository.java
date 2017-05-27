package org.fsoft.tms.repository;

import org.fsoft.tms.entity.UserProperty;
import org.fsoft.tms.entity.UserPropertyId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Isabella on 27-May-2017.
 */
public interface UserPropertyRepository extends JpaRepository <UserProperty,UserPropertyId>{

}
