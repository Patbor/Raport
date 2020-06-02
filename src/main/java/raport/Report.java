package raport;

import java.util.*;

public class Report {
    private double finalGrade;
   private Map<Subject,SubjectStatistic> statistic = new HashMap<>();

    public double getFinalGrade() {
        return finalGrade;
    }
    public void setFinalGrade(double finalGrade) {
       this.finalGrade = finalGrade;
    }

    public void setStatistic(Map<Subject, SubjectStatistic> statistic) {
        this.statistic = statistic;
    }

    public Map<Subject, SubjectStatistic> getStatistic() {
        return statistic;
    }

}
