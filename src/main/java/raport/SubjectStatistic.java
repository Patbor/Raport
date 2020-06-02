package raport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubjectStatistic {
    private double avrGroup;
    private List<Student> bestStudents;
    private List<Student> worstStudents;


    public double getAvrGroup() {
        return avrGroup;
    }

    public void setAvrGroup(double avrGroup) {
        this.avrGroup = avrGroup;
    }

    public List<Student> getBestStudents() {
        return bestStudents;
    }

    public void setBestStudents(List<Student> bestStudents) {
        this.bestStudents = bestStudents;
    }

    public List<Student> getWorstStudents() {
        return worstStudents;
    }

    public void setWorstStudents(List<Student> worstStudents) {
        this.worstStudents = worstStudents;
    }
public String toString(){
        return avrGroup + " " + bestStudents +" " + worstStudents;
}
}
