package com.example.Conceptile.Service;
import com.example.Conceptile.DTO.QuizResultDTO;
import com.example.Conceptile.Entity.Question;
import com.example.Conceptile.Entity.QuizSession;
import com.example.Conceptile.Repository.questionRepo ;
import com.example.Conceptile.Repository.quizSessionRepo ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service //contains business logic
public class QuizService {
    @Autowired
    private questionRepo questionRepo ;

    @Autowired
    private quizSessionRepo quizSessionRepo ;

    public Question getRandomQuestion()  {
        Random random = new Random() ;
        long id = random.nextInt((int) questionRepo.count()) + 1 ;
        Question question = questionRepo.findById(id).get() ;
        return question ;
    }


    public QuizResultDTO getQuizResultDTO(Long userid){
        QuizSession session = quizSessionRepo.findById(userid).orElseThrow(()-> new RuntimeException("Session not available")) ;
        int totalQues = session.getAnsweredQuestions().size() ;
        int correctAns = session.getCorrectAnsCount() ;
        int incorrectAns = totalQues-correctAns ;
        return new QuizResultDTO(userid,totalQues,correctAns, incorrectAns) ;
    }

    public QuizSession startSession(Long userId){
        System.out.println("Received userId: " + userId);
        Optional<QuizSession> existingSession = quizSessionRepo.findById(userId) ;
        if(existingSession.isPresent()){
            return existingSession.get() ;
        }
        QuizSession quizSession = QuizSession.builder()
                .userId(userId)
                .answeredQuestions(new ArrayList<>())
                .correctAnsCount(0)
                .build() ;

        return quizSessionRepo.save(quizSession);
    }

    public QuizSession submitAnswer(Long userId, Long questionId, String answer){
        QuizSession quizSession = quizSessionRepo.findById(userId).orElseThrow(()->new RuntimeException("No quiz session found for this userId " + userId)) ;

        Question question  = questionRepo.findById(questionId).orElseThrow(()-> new RuntimeException("No question found with this id " + questionId)) ;
        if(quizSession.getAnsweredQuestions().contains(questionId)){
            throw new RuntimeException("Question has already been submitted") ;
        }

        quizSession.getAnsweredQuestions().add(questionId);

        if(question.getCorrectAnswer().equals(answer)){
            quizSession.setCorrectAnsCount(quizSession.getCorrectAnsCount()+1);
        }

        return quizSessionRepo.save(quizSession) ;
    }

}


