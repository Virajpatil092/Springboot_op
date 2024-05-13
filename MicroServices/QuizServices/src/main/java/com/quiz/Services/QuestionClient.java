package com.quiz.Services;

import com.quiz.Entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:5002", value = "Question-Client")
@FeignClient(name = "QuestionServices")
public interface QuestionClient {

    @GetMapping("/questions/quiz/{quizId}")
    public List<Question> getQuestionOfQuiz(@PathVariable Long quizId);
}
