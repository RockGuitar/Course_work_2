package coursework;

import coursework.controllers.Question;
import coursework.services.QuestionService;
import coursework.services_realisation.ExaminerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    public static Question defaultQuestionOne = new Question("question1", "answer1");
    public static Question defaultQuestionTwo = new Question("question2", "answer2");
    public static Question defaultQuestionThree = new Question("question3", "answer2");
    public static Question defaultQuestionFour = new Question("question4", "answer2");
    public static Set<Question> defaultQuestionSet = new HashSet<>(Set.of(
            defaultQuestionOne,
            defaultQuestionTwo,
            defaultQuestionThree,
            defaultQuestionFour
    ));

    @Mock
    public QuestionService questionService;
    @InjectMocks
    public ExaminerServiceImpl out;

    @Test
    void shouldThrowExceptionWhenAmountIsHigherThanNumberOfQuestionsInList () {
        Mockito.when(questionService.getAll()).thenReturn(defaultQuestionSet);
        Assertions.assertThrows(RuntimeException.class, () -> out.getQuestions(5));
    }
}
