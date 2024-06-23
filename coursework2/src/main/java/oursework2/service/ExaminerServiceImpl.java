package oursework2.service;

import org.springframework.stereotype.Service;
import oursework2.exception.RequestLimitExceededException;
import oursework2.exception.RequiredNumberOfQuestionsIsMissing;
import oursework2.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionService;

    public ExaminerServiceImpl(QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questionsSet = new HashSet<>();
            if (javaQuestionService.getAll().size() >= amount) {
                while (questionsSet.size() < amount) {
                    questionsSet.add(javaQuestionService.getRandomQuestion());
                }
            } else {
                throw new RequiredNumberOfQuestionsIsMissing();
            }
        return Collections.unmodifiableSet(questionsSet);
    }

}
