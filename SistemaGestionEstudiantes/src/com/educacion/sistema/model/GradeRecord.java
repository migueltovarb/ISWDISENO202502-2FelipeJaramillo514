package com.educacion.sistema.model;

import java.time.LocalDate;

public class GradeRecord {
    private final String assessmentName;
    private final double score;
    private final double maxScore;
    private final LocalDate date;

    public GradeRecord(String assessmentName, double score, double maxScore, LocalDate date) {
        this.assessmentName = assessmentName;
        this.score = score;
        this.maxScore = maxScore;
        this.date = date;
    }

    public String getAssessmentName() { return assessmentName; }
    public double getScore() { return score; }
    public double getMaxScore() { return maxScore; }
    public LocalDate getDate() { return date; }
    public double getPercentage() { return (score / maxScore) * 100.0; }
}
