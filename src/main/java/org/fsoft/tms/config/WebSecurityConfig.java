package org.fsoft.tms.config;

import org.fsoft.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by thehaohcm on 5/26/17.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                //Disable CSRF for enable POST method in EmailController.java
                .csrf().disable()
                .authorizeRequests()
                //Login - Admin, Training Staff, Trainer
                .antMatchers("/").hasRole("Login")

                //Admin
                .antMatchers("/admin").hasRole("AccessAdminPage")
                    //Trainer
                .antMatchers("/admin/trainer/").hasRole("ViewSearchTrainerAccount")
                .antMatchers("/admin/trainer/add").hasRole("CreateTrainerAccount")
                .antMatchers("/admin/trainer/addTrainer").hasRole("CreateTrainerAccount")
                .antMatchers("/admin/trainer/update/**").hasRole("UpdateTrainerAccount")
                .antMatchers("/admin/trainer/updateTrainer").hasRole("UpdateTrainerAccount")
                .antMatchers("/admin/trainer/delete/**").hasRole("DeleteTrainerAccount")
                .antMatchers("/admin/trainer/deleteTrainer").hasRole("DeleteTrainerAccount")
                    //Training Staff
                .antMatchers("/admin/staff/").hasRole("ViewSearchTrainingStaffAccount")
                .antMatchers("/admin/staff/add").hasRole("CreateTrainingStaffAccount")
                .antMatchers("/admin/staff/addStaff").hasRole("CreateTrainingStaffAccount")
                .antMatchers("/admin/staff/update/**").hasRole("UpdateTrainingStaffAccount")
                .antMatchers("/admin/staff/updateStaff").hasRole("UpdateTrainingStaffAccount")
                .antMatchers("/admin/staff/delete/**").hasRole("DeleteTrainingStaffAccount")
                .antMatchers("/admin/staff/deleteStaff").hasRole("DeleteTrainingStaffAccount")
                .antMatchers("/admin/trainer/addCourse").hasRole("AddTrainerToCourse")

                //Training Staff
                .antMatchers("/staff").hasRole("AccessStaffPage")
                .antMatchers("staff/updateProfile").hasRole("EditTrainingStaffProfile")
                    //Trainee
                .antMatchers("/staff/trainee/").hasRole("ViewSearchTraineeAccount")
                .antMatchers("/staff/trainee/add").hasRole("CreateTraineeAccount")
                .antMatchers("/staff/trainee/addTrainee").hasRole("CreateTraineeAccount")
                .antMatchers("/staff/trainee/update/**").hasRole("UpdateTraineeAccount")
                .antMatchers("/staff/trainee/updateTrainee").hasRole("UpdateTraineeAccount")
                .antMatchers("/staff/trainee/delete/**").hasRole("DeleteTraineeAccount")
                .antMatchers("/staff/trainee/deleteTrainee").hasRole("DeleteTraineeAccount")
                .antMatchers("/staff/trainee/updateProfile").hasRole("EditTraineeProfile")
                    //Course
                .antMatchers("/staff/course/").hasRole("ViewSearchCourse")
                .antMatchers("/staff/course/add").hasRole("AddCourse")
                .antMatchers("/staff/course/addCourse").hasRole("AddCourse")
                .antMatchers("/staff/course/update/**").hasRole("UpdateCourse")
                .antMatchers("/staff/course/updateCourse").hasRole("UpdateCourse")
                .antMatchers("/staff/course/delete/**").hasRole("DeleteCourse")
                .antMatchers("/staff/course/deleteCourse").hasRole("DeleteCourse")
                    //Category
                .antMatchers("/staff/category/").hasRole("ViewSearchCourseCategory")
                .antMatchers("/staff/category/add").hasRole("AddCourseCategory")
                .antMatchers("/staff/category/addCategory").hasRole("AddCourseCategory")
                .antMatchers("/staff/category/update/**").hasRole("UpdateCourseCategory")
                .antMatchers("/staff/category/updateCategory").hasRole("UpdateCourseCategory")
                .antMatchers("/staff/category/delete/**").hasRole("DeleteCourseCategory")
                .antMatchers("/staff/category/deleteCategory").hasRole("DeleteCourseCategory")
                    //Topic
                .antMatchers("/staff/topic/").hasRole("ViewSearchCourseTopic")
                .antMatchers("/staff/topic/add").hasRole("AddCourseTopic")
                .antMatchers("/staff/topic/addTopic").hasRole("AddCourseTopic")
                .antMatchers("/staff/topic/update/**").hasRole("UpdateCourseTopic")
                .antMatchers("/staff/topic/updateTopic").hasRole("UpdateCourseTopic")
                .antMatchers("/staff/topic/delete/**").hasRole("DeleteCourseTopic")
                .antMatchers("/staff/topic/deleteTopic").hasRole("DeleteCourseTopic")
                    //Trainer
                .antMatchers("/staff/trainer/addCourse").hasRole("AssignTraineeToCouse")
                .antMatchers("/staff/trainer/addTopic").hasRole("AssignTraineeToTopic")
                .antMatchers("/staff/trainer/editProfile").hasRole("EditTrainerProfile")

                //Trainer
                .antMatchers("/trainer").hasRole("AccessTrainerPage")
                    //course
                .antMatchers("/trainer/course").hasRole("ViewTrainerListOfCourse")

                .and()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/")
                    .failureUrl("/login?error")
                    .and()
                .exceptionHandling()
                    .accessDeniedPage("/403");
    }
}
