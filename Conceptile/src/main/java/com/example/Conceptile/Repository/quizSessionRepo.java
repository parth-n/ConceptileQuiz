package com.example.Conceptile.Repository;

import com.example.Conceptile.Entity.QuizSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface quizSessionRepo extends JpaRepository<QuizSession, Long> {
    Optional<QuizSession> findById(Long userId);
}
