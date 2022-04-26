package coursework.controllers;

import coursework.services.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    public ExaminerService examinerService;

    public ExamController ( ExaminerService examinerService ) {
        this.examinerService = examinerService;
    }

    @GetMapping
    public Collection<Question> getQuestions ( @RequestParam("amount") int amount ) {
        return examinerService.getQuestions(amount);
    }

}
