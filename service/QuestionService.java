package com.Sprinhboot.ExamPortal.service;

import com.Sprinhboot.ExamPortal.entity.Question;
import com.Sprinhboot.ExamPortal.entity.Quiz;

import java.util.List;
import java.util.Set;

public interface QuestionService {
    public Question addQuestion(Question question);
    public Question getQuestion(Long questionId);

    public List<Question> getAllQuestion();

    public void deleteQuestion(Long questionId);
    public Question updateQuestion(Question question);

    public Set<Question> getQuestionOfQuiz(Quiz quiz);
}
