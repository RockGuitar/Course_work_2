package coursework.controllers;

import coursework.services.QuestionService;
import coursework.services_realisation.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController ( QuestionService questionService ) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion ( @RequestParam("question") String question, @RequestParam("answer") String answer ) {
        Question newQuestion = new Question(question, answer);
        questionService.add(newQuestion);
        return newQuestion;
    }

    @GetMapping("/remove")
    public Question removeQuestion ( @RequestParam("question") String question, @RequestParam("answer") String answer ) {
        Question deletedQuestion = new Question(question, answer);
        questionService.remove(deletedQuestion);
        return deletedQuestion;
    }

    @GetMapping
    public Collection<Question> getQuestions () {
        return questionService.getAll();
    }

    @GetMapping("/random")
    public Question getRandomQuestion(){
        return questionService.getRandomQuestion();
    }
}
