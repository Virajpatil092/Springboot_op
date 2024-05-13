package com.Questions.Controller;

import com.Questions.Entities.Question;
import com.Questions.Services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping()
    private Question addQuestion(@RequestBody Question question) {
        return questionService.Create(question);
    }

    @GetMapping()
    private List<Question> getQuestions() {
        return questionService.FindAll();
    }

    @GetMapping("/{id}")
    private Question getQuestion(@PathVariable Long id) {
        return questionService.FindById(id);
    }

    @GetMapping("/quiz/{quizId}")
    private List<Question> getQuestionsByQuiz(@PathVariable Long quizId) {
        return questionService.findByQuiz(quizId);
    }
}
