package com.Sprinhboot.ExamPortal.service.Impl;

import com.Sprinhboot.ExamPortal.entity.Question;
import com.Sprinhboot.ExamPortal.entity.Quiz;
import com.Sprinhboot.ExamPortal.repository.QuestionRepository;
import com.Sprinhboot.ExamPortal.repository.QuizRepository;
import com.Sprinhboot.ExamPortal.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question getQuestion(Long questionId) {
        return questionRepository.findById(questionId).get();
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public void deleteQuestion(Long questionId) {
    Question question = new Question();
    question.setQuesId(questionId);
    questionRepository.delete(question);

    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestionOfQuiz(Quiz quiz) {
        return questionRepository.findByQuiz(quiz);
    }
}
