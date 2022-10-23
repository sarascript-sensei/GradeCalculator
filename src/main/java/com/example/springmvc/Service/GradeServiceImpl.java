package com.example.springmvc.Service;

import com.example.springmvc.Domain.Grade;
import com.example.springmvc.Repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeRepository gradeRepository;


    @Override
    public List<Grade> listAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public void addGrade(String lectures, String grade) {
        Grade grade_maker = new Grade(lectures, grade);
        gradeRepository.save(grade_maker);

    }

/*    @Override
    public double calculateAverage() {
        return 0;
    }*/

    @Override
    public double calculateAverage() {
        return gradeRepository.findAll().stream()
                .mapToDouble(i->Double.parseDouble(i.getGrade()))
                .average().orElse(0);
    }
}
