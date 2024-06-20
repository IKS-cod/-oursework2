package oursework2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import oursework2.exception.IncorrectDataException;
import oursework2.model.Question;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    void addTest() {
        Question expected = new Question("Что такое переменная?", "Область в памяти компьютера для " +
                "хранения данных, которой можно присвоить имя");
        Question actual = javaQuestionService.add("Что такое переменная?", "Область в памяти компьютера для " +
                "хранения данных, которой можно присвоить имя");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void removeTest() {
        Question expected = new Question("Что такое переменная?", "Область в памяти компьютера для " +
                "хранения данных, которой можно присвоить имя");
        Question actual = javaQuestionService.remove("Что такое переменная?", "Область в памяти компьютера для " +
                "хранения данных, которой можно присвоить имя");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getAllTest() {
        Question question1 = new Question("Что такое переменная?",
                "Область в памяти компьютера для хранения данных, которой можно присвоить имя");
        Question question2 = new Question("Какая команда позволяет вывести результат написанного кода в консоль?",
                "System.out.println ()");
        Question question3 = new Question("Что такое инициализация переменной?",
                "Присвоение какого-то значения переменной");
        Set<Question> expected = new HashSet<>();
        expected.add(question1);
        expected.add(question2);
        expected.add(question3);
        javaQuestionService.add("Что такое переменная?",
                "Область в памяти компьютера для хранения данных, которой можно присвоить имя");
        javaQuestionService.add("Какая команда позволяет вывести результат написанного кода в консоль?",
                "System.out.println ()");
        javaQuestionService.add("Что такое инициализация переменной?",
                "Присвоение какого-то значения переменной");

        Set<Question> actual =new HashSet<> (javaQuestionService.getAll());
        Assertions.assertIterableEquals(expected, actual);
    }
}