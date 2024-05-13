package com.Questions.Services;

import com.Questions.Entities.Question;
import com.Questions.Repo.QuestionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepo questionRepo;

    public QuestionService(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    public Question Create(Question question) {
        return questionRepo.save(question);
    }

    public List<Question> FindAll() {
        return questionRepo.findAll();
    }

    public Question FindById(Long id) {
        return questionRepo.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    public List<Question> findByQuiz(Long quizId) {
        return questionRepo.findByQuizId(quizId);
    }
}
