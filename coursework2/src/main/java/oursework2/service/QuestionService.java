package oursework2.service;

import org.springframework.stereotype.Service;
import oursework2.model.Question;

import java.util.Collection;
import java.util.Collections;
@Service
public interface QuestionService {
    public Question add(String question,String answer);

    public Question remove(String question,String answer);

    public Collection<Question> getAll();

    public int getRandomQuestion();
}
