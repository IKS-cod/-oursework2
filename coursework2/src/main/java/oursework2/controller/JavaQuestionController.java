package oursework2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import oursework2.model.Question;
import oursework2.service.JavaQuestionService;
import oursework2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService javaQuestionService;

    public JavaQuestionController(QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question,
                        @RequestParam String answer) {
        return javaQuestionService.add(question,answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question,
                           @RequestParam String answer) {
        return javaQuestionService.remove(question,answer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }


}
