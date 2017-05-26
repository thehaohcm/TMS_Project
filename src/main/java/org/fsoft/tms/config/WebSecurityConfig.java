package org.fsoft.tms.config;

import org.fsoft.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by thehaohcm on 5/26/17.
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userSErvice;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/").permitAll()
                    .antMatchers("/admin").hasRole("Admin")
                    .antMatchers("/trainingstaff").hasRole("Training Staff")
                    .antMatchers("/trainer").hasRole("Trainer")
                    .antMatchers("/trainee").hasRole("Trainee")
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/login")
                    .failureUrl("/login?error")
                    .and()
                .exceptionHandling()
                    .accessDeniedPage("/403");
    }
}
