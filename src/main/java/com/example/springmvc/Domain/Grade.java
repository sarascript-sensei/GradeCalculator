package com.example.springmvc.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Grade {
    @Id @GeneratedValue
    private long id;

    private String lecture;
    private String grade;

    public Grade(){

    }
    public Grade(String lecture, String grade){
        this.lecture = lecture;
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    public String getLecture() {
        return lecture;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Grade)) {
            return false;
        }
        Grade grade = (Grade) o;
        return Objects.equals(this.id, grade.id) && Objects.equals(this.lecture, grade.lecture) && Objects.equals(this.grade, grade.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.lecture, this.grade);
    }


    @Override
    public String toString() {
        return "Grade{" + "id=" + this.id + ", lecture='" + this.lecture + '\'' + ", grade='" + this.grade + '\'' + '}';
    }
}

