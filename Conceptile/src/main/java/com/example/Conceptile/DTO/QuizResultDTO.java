package com.example.Conceptile.DTO;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizResultDTO {
    private Long userid ;
    private int totalQuesAnswered ;
    private int correctAns ;
    private int wrongAns ;

}
