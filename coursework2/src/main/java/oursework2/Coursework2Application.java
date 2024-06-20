package oursework2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import oursework2.model.Question;
import oursework2.service.ExaminerServiceImpl;
import oursework2.service.JavaQuestionService;

import java.util.Arrays;

@SpringBootApplication
public class Coursework2Application {

	public static void main(String[] args) {
		SpringApplication.run(Coursework2Application.class, args);
		
	}

}
