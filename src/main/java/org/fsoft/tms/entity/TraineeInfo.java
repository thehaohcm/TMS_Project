package org.fsoft.tms.entity;

import java.sql.Date;

/**
 * Created by thehaohcm on 5/30/17.
 */
public class TraineeInfo {

    private User user;

    private String name;

    private Date birthDate;

    private String education;

    private String programingLanguage;

    private String toeicScore;

    private String experienceDetail;

    private String department;

    private String location;

    public TraineeInfo(){

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProgramingLanguage() {
        return programingLanguage;
    }

    public void setProgramingLanguage(String programingLanguage) {
        this.programingLanguage = programingLanguage;
    }

    public String getToeicScore() {
        return toeicScore;
    }

    public void setToeicScore(String toeicScore) {
        this.toeicScore = toeicScore;
    }

    public String getExperienceDetail() {
        return experienceDetail;
    }

    public void setExperienceDetail(String experienceDetail) {
        this.experienceDetail = experienceDetail;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
