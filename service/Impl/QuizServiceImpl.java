package com.Sprinhboot.ExamPortal.service.Impl;

import com.Sprinhboot.ExamPortal.entity.Quiz;
import com.Sprinhboot.ExamPortal.repository.QuizRepository;
import com.Sprinhboot.ExamPortal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public void deleteQuiz(Long quizId) {
        Quiz quiz = new Quiz();
        quiz.setQid(quizId);
        quizRepository.delete(quiz);
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return quizRepository.findById(quizId).get();
    }
}
