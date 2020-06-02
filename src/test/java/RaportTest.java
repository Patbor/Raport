import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import raport.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RaportTest {

    @Test
    void printMaxTest() {
        // given
        StudentsRaport test = new StudentsRaport();
        Subject project1 = new Subject("Geografia");
        List<Student> Student = exampleStudent();
        Student.get(0).getHm().put(project1, 2);
        Student.get(1).getHm().put(project1, 4);
        Student.get(2).getHm().put(project1, 6);
        Student.get(3).getHm().put(project1, 6);
        // when
        List<Student> expectedTheBestStudents = new ArrayList<>(Arrays.asList(Student.get(2), Student.get(3)));
        // then
        Assertions.assertEquals(expectedTheBestStudents, test.printMax(Student, project1));
    }

    @Test
    void printMinTest() {
        // given
        StudentsRaport test = new StudentsRaport();
        Subject project1 = new Subject("Geografia");
        List<Student> Student = exampleStudent();
        Student.get(0).getHm().put(project1, 2);
        Student.get(1).getHm().put(project1, 4);
        Student.get(2).getHm().put(project1, 2);
        Student.get(3).getHm().put(project1, 6);
        // when
        List<Student> expectedTheWorstStudents = new ArrayList<>(Arrays.asList(Student.get(0), Student.get(2)));
        // then
        Assertions.assertEquals(expectedTheWorstStudents, test.printMin(Student, project1));
    }

    @Test
    void printAvrGroupTest() {
        // given
        StudentsRaport test = new StudentsRaport();
        Subject project1 = new Subject("Geografia");
        List<Student> student = exampleStudent();
        student.get(0).getHm().put(project1, 3);
        student.get(1).getHm().put(project1, 4);
        student.get(2).getHm().put(project1, 6);
        student.get(3).getHm().put(project1, 3);
        // then
        int expectedValue = 4;
        // when
        Assertions.assertEquals(expectedValue, test.printAvrGroup(student, project1));
    }

    @Test
    void printFinalAvrTest() {
        // given
        StudentsRaport test = new StudentsRaport();
        List<Subject> nameOfSubject = exampleSubject();
        Student student = exampleStudent().get(0);
        student.getHm().put(nameOfSubject.get(0), 4);
        student.getHm().put(nameOfSubject.get(1), 3);
        student.getHm().put(nameOfSubject.get(2), 4);
        student.getHm().put(nameOfSubject.get(3), 6);
        student.getHm().put(nameOfSubject.get(4), 3);
        // when
        int expectedValue = 4;
        // then
        Assertions.assertEquals(expectedValue, test.finalAvr(student, nameOfSubject));
    }

    @Test
    void generatedReportTest() {
        // given
        StudentsRaport test = new StudentsRaport();
        List<Student> students = exampleStudent();
        List<Subject> subject = exampleSubject();
        students.get(0).getHm().put(subject.get(0), 3);
        students.get(0).getHm().put(subject.get(1), 4);
        students.get(0).getHm().put(subject.get(2), 2);
        students.get(0).getHm().put(subject.get(3), 4);
        students.get(0).getHm().put(subject.get(4), 2);
        students.get(1).getHm().put(subject.get(0), 5);
        students.get(2).getHm().put(subject.get(0), 6);
        students.get(3).getHm().put(subject.get(0), 4);
        Report stat = test.generateReport(students.get(1), subject, students);
        // when
        double exceptedValueOfFinalGrade = 5;
        double exceptedValueOfAvrGroup = 4.0d;
        List<Student> exceptedTheBestStudents = new ArrayList<>(Arrays.asList(students.get(2)));
        List<Student> exceptedTheWorstStudents = new ArrayList<>(Arrays.asList(students.get(0)));
        // then
        Assertions.assertEquals(exceptedValueOfFinalGrade, stat.getFinalGrade());
        Assertions.assertEquals(exceptedValueOfAvrGroup, stat.getStatistic().get(subject.get(3)).getAvrGroup());
        Assertions.assertEquals(exceptedTheBestStudents, stat.getStatistic().get(subject.get(0)).getBestStudents());
        Assertions.assertEquals(exceptedTheWorstStudents, stat.getStatistic().get(subject.get(0)).getWorstStudents());
    }

    static List<Student> exampleStudent() {
        Student s1 = new Student("Jan Kasza", 1213323878);
        Student s2 = new Student("Kasia Cichopek", 1213445888);
        Student s3 = new Student("Karolina Skiba", 97101002189L);
        Student s4 = new Student("Maciek Kartt", 1213323345);

        return new ArrayList<>(Arrays.asList(s1, s2, s3, s4));
    }

    static List<Subject> exampleSubject() {
        Subject project1 = new Subject("Geografia");
        Subject project2 = new Subject("Fizyka");
        Subject project3 = new Subject("Matematyka");
        Subject project4 = new Subject("WF");
        Subject project5 = new Subject("Historia");

        return new ArrayList<>(Arrays.asList(project1, project2, project3, project4, project5));
    }
}
