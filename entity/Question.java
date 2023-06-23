package com.Sprinhboot.ExamPortal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quesId;
    private String image;
    private String content;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;

}
