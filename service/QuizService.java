package com.Sprinhboot.ExamPortal.service;

import com.Sprinhboot.ExamPortal.entity.Quiz;

import java.util.List;

public interface QuizService {
    public Quiz addQuiz(Quiz quiz);
    public List<Quiz> getAllQuiz();

    public Quiz updateQuiz(Quiz quiz);

    public void deleteQuiz(Long quizId);
    public Quiz getQuiz(Long quizId);
}
