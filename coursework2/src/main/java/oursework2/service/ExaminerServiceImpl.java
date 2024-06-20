package oursework2.service;

import org.springframework.stereotype.Service;
import oursework2.exception.RequestLimitExceededException;
import oursework2.exception.RequiredNumberOfQuestionsIsMissing;
import oursework2.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int maxSet = 5;
        Set<Question> questionsSet = new HashSet<>(maxSet);
        List<Question> elements = new ArrayList<>(javaQuestionService.getAll());
        if (amount <= maxSet) {
            if (javaQuestionService.getAll().size() >= amount) {
                while (questionsSet.size() < amount) {
                    questionsSet.add(elements.get(javaQuestionService.getRandomQuestion()));
                }
            } else {
                throw new RequiredNumberOfQuestionsIsMissing();
            }
        } else {
            throw new RequestLimitExceededException();
        }
        return Collections.unmodifiableSet(questionsSet);
    }

}
