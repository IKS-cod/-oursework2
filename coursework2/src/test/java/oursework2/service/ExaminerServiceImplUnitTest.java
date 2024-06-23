package oursework2.service;

import org.junit.jupiter.api.Test;
import oursework2.exception.RequestLimitExceededException;
import oursework2.exception.RequiredNumberOfQuestionsIsMissing;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ExaminerServiceImplUnitTest {
    private final ExaminerServiceImpl examinerService = new ExaminerServiceImpl(new JavaQuestionService());

    @Test
    void getQuestions_Negative_RequiredNumberOfQuestionsIsMissing_Test() {
        assertThatExceptionOfType(RequiredNumberOfQuestionsIsMissing.class).isThrownBy(() -> examinerService.getQuestions(5));
    }
}
