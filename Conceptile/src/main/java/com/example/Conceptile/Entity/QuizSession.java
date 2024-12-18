package com.example.Conceptile.Entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizSession {
    @Id
    @Column(nullable = false)
    private Long userId ;

    @ElementCollection
    private List<Long> answeredQuestions ;

    private int correctAnsCount ;
}
