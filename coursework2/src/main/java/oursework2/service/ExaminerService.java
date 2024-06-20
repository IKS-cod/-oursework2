package oursework2.service;

import org.springframework.stereotype.Service;
import oursework2.model.Question;

import java.util.Collection;

@Service
public interface ExaminerService {
     Collection<Question> getQuestions(int amount);
}
