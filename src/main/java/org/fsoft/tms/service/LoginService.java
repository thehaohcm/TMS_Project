package org.fsoft.tms.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fsoft.tms.entity.Role;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.repository.RoleRepository;
import org.fsoft.tms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Isabella on 26-May-2017.
 */
@Service
public class LoginService implements UserDetailsService{

    private final Logger logger = LogManager.getLogger();

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        logger.debug("username nhận được:" + s);
        User user = userRepository.findUserByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        Role role = user.getRole();

        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), grantedAuthorities);

    }

    public Role getRoleByUser(String str){
        User user=userRepository.findUserByUsername(str);
        return user.getRole();
    }
}