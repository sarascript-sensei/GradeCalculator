package com.example.springmvc.Controller;

import com.example.springmvc.Domain.Grade;
import com.example.springmvc.Service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class GradeController {


    @Autowired
    private GradeService gradeService;

    //display list of grades
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewHomePage(Model model) {

        model.addAttribute("listGrades", gradeService.listAllGrades());
        double average = gradeService.calculateAverage();
        model.addAttribute("calculateAverage",average);
        return "index";
    }

/*    @RequestMapping(value="/",method=RequestMethod.POST)
    public String calculateAverage(Model model){
        model.addAttribute("calculateAverage", gradeService.calculateAverage());
        return "index";
    }*/

    // save grade to database
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addGrade(@RequestParam String lecture, @RequestParam String grade, ModelMap model) {
        Grade newGrade = new Grade(lecture, grade);

        newGrade.setLecture(lecture);
        newGrade.setGrade(grade);


        model.addAttribute("lecture", newGrade);
        model.addAttribute("grade", newGrade);

        gradeService.addGrade(lecture, grade);

        return "redirect:/";
    }
}
