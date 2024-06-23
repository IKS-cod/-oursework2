package oursework2.controller;

import org.springframework.web.bind.annotation.*;
import oursework2.model.Question;
import oursework2.service.ExaminerService;
import oursework2.service.ExaminerServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
