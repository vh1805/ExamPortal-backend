package com.Sprinhboot.ExamPortal.repository;

import com.Sprinhboot.ExamPortal.entity.Question;
import com.Sprinhboot.ExamPortal.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    public Set<Question> findByQuiz(Quiz quiz);

}
