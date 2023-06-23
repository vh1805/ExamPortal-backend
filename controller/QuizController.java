package com.Sprinhboot.ExamPortal.controller;

import com.Sprinhboot.ExamPortal.entity.Quiz;
import com.Sprinhboot.ExamPortal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(quizService.addQuiz(quiz));
    }
    @GetMapping("/{quizId}")
    public ResponseEntity<?> getQuiz(@PathVariable("quizId") Long quizId){
        return ResponseEntity.ok(quizService.getQuiz(quizId));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllQuiz(){
        return ResponseEntity.ok(quizService.getAllQuiz());
    }
    @DeleteMapping("/{quizId}")
    public String deleteQuiz(@PathVariable("quizId") Long quizId){
        quizService.deleteQuiz(quizId);
        return "Quiz Deleted Successfully";
    }
    @PutMapping("/")
    public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz){
        return  ResponseEntity.ok(quizService.updateQuiz(quiz));
    }

}
