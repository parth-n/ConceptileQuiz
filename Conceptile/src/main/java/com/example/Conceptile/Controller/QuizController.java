package com.example.Conceptile.Controller;

import com.example.Conceptile.DTO.QuizResultDTO;
import com.example.Conceptile.Entity.Question;
import com.example.Conceptile.Entity.QuizSession;
import com.example.Conceptile.Exception.QuestionNotFoundException;
import com.example.Conceptile.Service.QuizService ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService ;

    @GetMapping("/question") // get random question api
    public ResponseEntity<Question> getRandomQuestion() {
       return ResponseEntity.ok(quizService.getRandomQuestion()) ;
    }

    @GetMapping("/result/{userId}")
    public QuizResultDTO getQuizResult(@PathVariable Long userId){
        return quizService.getQuizResultDTO(userId) ;
    }

    @PostMapping("/submit/{userId}/{questionId}")
    public ResponseEntity<QuizSession> submitAnswer(@PathVariable Long userId, @PathVariable Long questionId, @RequestParam String answer){
        return ResponseEntity.ok(quizService.submitAnswer(userId,questionId,answer)) ;
    }

    @PostMapping("/start/{userId}")
    public ResponseEntity<QuizSession> startSession(@PathVariable Long userId){
        return ResponseEntity.ok(quizService.startSession(userId)) ;
    }

}
