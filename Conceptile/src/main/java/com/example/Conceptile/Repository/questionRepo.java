package com.example.Conceptile.Repository;

import com.example.Conceptile.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface questionRepo extends JpaRepository<Question, Long> {
   public Optional<Question> findById(Long id) ;
}
