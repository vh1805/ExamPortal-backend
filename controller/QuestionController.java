package com.Sprinhboot.ExamPortal.controller;

import com.Sprinhboot.ExamPortal.entity.Question;
import com.Sprinhboot.ExamPortal.entity.Quiz;
import com.Sprinhboot.ExamPortal.service.QuestionService;
import com.Sprinhboot.ExamPortal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<?> addQuiz(@RequestBody Question question){
        return ResponseEntity.ok(questionService.addQuestion(question));
    }
    @GetMapping("/{questionId}")
    public ResponseEntity<?> getQuestion(@PathVariable("questionId") Long questionId){
        return ResponseEntity.ok(questionService.getQuestion(questionId));
    }
    @GetMapping("/")
    public ResponseEntity<?> getAllQuestion(){
        return ResponseEntity.ok(questionService.getAllQuestion());
    }
    @DeleteMapping("/questionId")
    public String deleteQuestion(@PathVariable("questionId") Long questionId){
        questionService.deleteQuestion(questionId);
        return "Question Deleted Successfully";
    }
    @PutMapping("/")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question){
        return ResponseEntity.ok(questionService.updateQuestion(question));
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("quizId") Long quizId){
        Quiz quiz = quizService.getQuiz(quizId);

        Set<Question> questionSet = quiz.getQuestions();
        List list = new ArrayList(questionSet);

        if(questionSet.size() > Integer.parseInt(quiz.getNumberOfQuestions())){
            list = list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }
}
