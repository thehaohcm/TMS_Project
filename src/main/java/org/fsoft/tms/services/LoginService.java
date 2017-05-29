package org.fsoft.tms.services;

import org.fsoft.tms.entity.Role;
import org.fsoft.tms.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Isabella on 29-May-2017.
 */
public interface LoginService {

    UserDetails loadUserByUsername(String s);

    Role getRoleByUser(String str);
}
