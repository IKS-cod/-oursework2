package oursework2.service;

import org.assertj.core.api.ClassBasedNavigableIterableAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import oursework2.exception.RequestLimitExceededException;
import oursework2.exception.RequiredNumberOfQuestionsIsMissing;
import oursework2.model.Question;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService javaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private Set<Question> questionSetList = Set.of(
            new Question("Что такое переменная?",
                    "Область в памяти компьютера для хранения данных, которой можно присвоить имя"),
            new Question("Какая команда позволяет вывести результат написанного кода в консоль?",
                    "System.out.println ()"),
            new Question("Что такое инициализация переменной?",
                    "Присвоение какого-то значения переменной"),
            new Question("Если нам нужно напечатать дробную цифру, которая содержит в себе 9 знаков после запятой, какой лучше всего использовать тип переменной?",
                    "double")
    );
    private final Question question = new Question("Что такое переменная?", "Область в памяти компьютера для хранения данных, которой можно присвоить имя");

    @BeforeEach
    public void beforeEach() {
        when(javaQuestionService.getAll()).thenReturn(questionSetList);
        when(javaQuestionService.getRandomQuestion()).thenReturn(question);
    }

    @Test
    void getQuestionsTest() {
        Set<Question> expected = new HashSet<>();
        Question question1 = new Question("Что такое переменная?",
                "Область в памяти компьютера для хранения данных, которой можно присвоить имя");
       /* Question question2 = new Question("Какая команда позволяет вывести результат написанного кода в консоль?",
                "System.out.println ()");
        Question question3 = new Question("Что такое инициализация переменной?",
                "Присвоение какого-то значения переменной");
        Question question4 = new Question("Если нам нужно напечатать дробную цифру, которая содержит в " +
                "себе 9 знаков после запятой, какой лучше всего использовать тип переменной?",
                "double");*/
        expected.add(question1);
        /*expected.add(question2);
        expected.add(question3);
        expected.add(question4);*/
        Set<Question> actual = new HashSet<>(examinerService.getQuestions(1));
        assertEquals(expected, actual);
    }

}