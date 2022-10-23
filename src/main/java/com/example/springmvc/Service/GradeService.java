package com.example.springmvc.Service;

import com.example.springmvc.Domain.Grade;

import java.util.List;

public interface GradeService {
    List<Grade> listAllGrades();
    void addGrade(String lectures, String grade);
    double calculateAverage();

}
