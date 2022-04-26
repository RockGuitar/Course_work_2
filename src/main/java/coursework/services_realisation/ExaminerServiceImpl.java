package coursework.services_realisation;

import coursework.controllers.Question;
import coursework.exceptions.TooManyQuestionsException;
import coursework.services.ExaminerService;
import coursework.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    public QuestionService questionService;

    public ExaminerServiceImpl ( QuestionService questionService ) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestions ( int amount ) {
        if (amount > questionService.getAll().size()) {
            throw new TooManyQuestionsException();
        }
        Set<Question> requestedQuestions = new HashSet<>();
        while (requestedQuestions.size() != amount) {
            requestedQuestions.add(questionService.getRandomQuestion());
        }
        return requestedQuestions;
    }
}
