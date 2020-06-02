package raport;

import java.util.List;

public class Subject {
    private String nameOfSubject;
   private List<Student> groupOfStudent;

    public Subject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    public String toString() {

        return nameOfSubject;
    }

   public List<Student> getGroupOfStudent() {
        return groupOfStudent;
    }

    public void setGroupOfStudent(List<Student> groupOfStudent) {
        this.groupOfStudent = groupOfStudent;
    }
}
