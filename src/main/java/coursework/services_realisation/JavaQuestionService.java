package coursework.services_realisation;

import coursework.controllers.Question;
import coursework.exceptions.QuestionAlreadyExistsException;
import coursework.exceptions.QuestionDoesNotExistException;
import coursework.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    Set<Question> questionList = new HashSet<>();

    public Question add ( String question, String answer ) {
        Question newQuestion = new Question(question, answer);
        if (questionList.contains(newQuestion)) {
            throw new QuestionAlreadyExistsException();
        }
        questionList.add(newQuestion);
        return newQuestion;
    }

    public Question add ( Question fullQuestion ) {
        if (questionList.contains(fullQuestion)) {
            throw new QuestionAlreadyExistsException();
        }
        questionList.add(fullQuestion);
        return fullQuestion;
    }

    public Question remove ( Question deletedQuestion ) {
        if (!questionList.contains(deletedQuestion)) {
            throw new QuestionDoesNotExistException();
        }
        questionList.remove(deletedQuestion);
        return deletedQuestion;
    }

    public Question getRandomQuestion () {
        Random indexGenerator = new Random();
        List<Question> fullQuestionList = new ArrayList<>(questionList);
        return fullQuestionList.get(indexGenerator.nextInt(questionList.size()));
    }

    public Collection<Question> getAll () {
        return questionList;
    }
}
