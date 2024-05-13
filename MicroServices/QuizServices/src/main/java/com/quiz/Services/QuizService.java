package com.quiz.Services;

import com.quiz.Entities.Quiz;
import com.quiz.Repo.QuizRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {
    private final QuizRepo quizRepo;
    private final QuestionClient questionClient;

    public QuizService(QuizRepo quizRepo, QuestionClient questionClient) {
        this.quizRepo = quizRepo;
        this.questionClient = questionClient;
    }

    public Quiz addQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        List<Quiz> quizzes = quizRepo.findAll();

        List<Quiz> quizList = quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());

        return quizList;
    }

    public Quiz getQuizById(Long id) {
        Quiz quiz = quizRepo.findById(id).orElse(null);
        if (quiz != null) {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        }
        return quiz;
    }
}
