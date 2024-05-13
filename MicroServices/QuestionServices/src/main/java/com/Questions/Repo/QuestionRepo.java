package com.Questions.Repo;

import com.Questions.Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {
    @Query("select q from Question q where q.QuizId = :quizId")
    List<Question> findByQuizId(Long quizId);
}
