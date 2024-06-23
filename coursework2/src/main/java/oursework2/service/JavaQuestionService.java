package oursework2.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import oursework2.exception.IncorrectDataException;
import oursework2.model.Question;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random=new Random();

    @PostConstruct
    private void init() {
        add("Что такое переменная?",
                "Область в памяти компьютера для хранения данных, которой можно присвоить имя");
        add("Какая команда позволяет вывести результат написанного кода в консоль?",
                "System.out.println ()");
        add("Что такое инициализация переменной?",
                "Присвоение какого-то значения переменной");
        add("Если нам нужно напечатать дробную цифру, которая содержит в себе 9 знаков после запятой, " +
                        "какой лучше всего использовать тип переменной?",
                "double");
        add("Конструкция else — это",
                "Операция, которая показывает программе, что нужно сделать, если условие в скобках " +
                        "условного оператора не выполнено");
        add("Что обозначает знак != ?",
                "Это знак неравенства");
        add("Какой из символов ниже обозначает операцию «И»?",
                "&&");
        add("Каким может быть условие продолжения цикла?",
                "Условие обязано возвращать true для запуска итерации");
        add("Продолжите фразу. Если в цикле for первое и последнее условие пустые, то ...",
                "Такой цикл можно заменить на цикл while");
        add("Что такое массив?",
                "Структура данных, которая позволяет хранить несколько значений одного типа");
    }
    @Override
    public Question add(String question,String answer) {
        Question questionModel =new Question(question, answer);
        questions.add(questionModel);
        return questionModel;
    }
    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question,String answer) {
        Question questionModel =new Question(question, answer);
        questions.remove(questionModel);
        return questionModel;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> elements = new ArrayList<>(getAll());
        return elements.get(random.nextInt(questions.size()));
    }


}
