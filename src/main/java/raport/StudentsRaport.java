package raport;

import com.sun.source.tree.Tree;

import java.io.IOException;


import java.util.*;

public class StudentsRaport {
    public static void main(String[] args) {
        Subject project1 = new Subject("Geografia");
        Subject project2 = new Subject("Fizyka");
        Subject project3 = new Subject("Matematyka");
        Subject project4 = new Subject("WF");
        Subject project5 = new Subject("Historia");
        List<Subject> subjects = new ArrayList<>(Arrays.asList(project1, project2, project3, project4, project5));
        Student s1 = new Student("Jan Kasza", 1213323878);
        s1.getHm().put(project1, 3);
        s1.getHm().put(project2, 2);
        s1.getHm().put(project3, 4);
        s1.getHm().put(project4, 6);
        s1.getHm().put(project5, 2);
        Student s2 = new Student("Kasia Cichopek", 1213445888);
        s2.getHm().put(project1, 4);
        s2.getHm().put(project2, 5);
        s2.getHm().put(project3, 4);
        s2.getHm().put(project4, 5);
        s2.getHm().put(project5, 4);
        Student s3 = new Student("Karolina Skiba", 97101002189L);
        s3.getHm().put(project1, 6);
        s3.getHm().put(project2, 6);
        s3.getHm().put(project3, 6);
        s3.getHm().put(project4, 6);
        s3.getHm().put(project5, 6);
        Student s4 = new Student("Maciek Kartt", 1213323345);
        s4.getHm().put(project1, 2);
        s4.getHm().put(project2, 1);
        s4.getHm().put(project3, 3);
        s4.getHm().put(project4, 5);
        s4.getHm().put(project5, 2);
        Student s5 = new Student("Jan Kaaass", 1213323325);
        s5.getHm().put(project1, 3);
        s5.getHm().put(project2, 3);
        s5.getHm().put(project3, 2);
        s5.getHm().put(project4, 2);
        s5.getHm().put(project5, 2);
        Student s6 = new Student("Zbysiu Potok", 1213323131);
        s6.getHm().put(project1, 6);
        s6.getHm().put(project2, 5);
        s6.getHm().put(project3, 5);
        s6.getHm().put(project4, 5);
        s6.getHm().put(project5, 5);
        Student s7 = new Student("Józek Dupa", 1213323257);
        s7.getHm().put(project1, 1);
        s7.getHm().put(project2, 3);
        s7.getHm().put(project3, 2);
        s7.getHm().put(project4, 6);
        s7.getHm().put(project5, 5);
        Student s8 = new Student("Kacper Kasza", 1213323234);
        s8.getHm().put(project1, 2);
        s8.getHm().put(project2, 1);
        s8.getHm().put(project3, 6);
        s8.getHm().put(project4, 2);
        s8.getHm().put(project5, 3);
        List<Student> group1 = new ArrayList<>(Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8));
        printArray(group1,subjects);
        printResult(group1,subjects);
        System.out.println();


    }



    public static void printArray(List<Student> students, List<Subject> subjects) {

        for (int i = 0; i < students.size(); ++i) {
            Student allStudent = students.get(i);
            System.out.println(allStudent);

            for (Map.Entry<Subject, Integer> entry : allStudent.getHm().entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
            System.out.println("Srednia koncowa to: " + finalAvr(allStudent, subjects));
            System.out.println();

        }
    }

    public static void printResult(List<Student> students, List<Subject> subjects) {
        System.out.println();
        Report stat = generateReport(students.get(0), subjects, students);
        for (Subject nameOfSubject : subjects) {
            double avr = stat.getStatistic().get(nameOfSubject).getAvrGroup();
            List<Student> theBest = stat.getStatistic().get(nameOfSubject).getBestStudents();
            List<Student> theWorst = stat.getStatistic().get(nameOfSubject).getWorstStudents();
            System.out.println("Srednia grupy z " + nameOfSubject + " to: " + avr);
            System.out.println();
            System.out.println("Najlepszy uczeń w tej grupie z " + nameOfSubject + " to: " + theBest);
            System.out.println("Najsłabszy uczeń w tej grupie z " + nameOfSubject + " to: " + theWorst);
            System.out.println();
        }
    }

    public static Report generateReport(Student student, List<Subject> subjects, List<Student> students) {
        Report report = new Report();
        report.setFinalGrade(finalAvr(student, subjects));
        for (Subject nameOfSubject : subjects) {
            SubjectStatistic statistic = new SubjectStatistic();
            statistic.setAvrGroup(printAvrGroup(students, nameOfSubject));
            statistic.setBestStudents(printMax(students, nameOfSubject));
            statistic.setWorstStudents(printMin(students, nameOfSubject));
            report.getStatistic().put(nameOfSubject, statistic);
        }
        return report;
    }

    public static double finalAvr(Student students, List<Subject> subjects) {
        double avr = 0.0;
        double finalAvr;
        double size = subjects.size();
        for (Subject subject : subjects) {
            if (!students.getHm().containsKey(subject)) {
                size -= 1;
                continue;
            }
            avr += students.getHm().get(subject);
        }
        finalAvr = avr / size;

        return finalAvr;
    }

    public static double printAvrGroup(List<Student> students, Subject nameOfSubjects) {

        double avr = 0.0;
        double avarage;
        List<Student> studentWithSubject = new ArrayList<>();
        for (Student student : students) {
            if (student.getHm().containsKey(nameOfSubjects)) {
                studentWithSubject.add(student);
            }
        }
        for (Student student : studentWithSubject) {
            avr += student.getHm().get(nameOfSubjects);
        }
        avarage = avr / studentWithSubject.size();

        return avarage;
    }

    public static List<Student> printMin(List<Student> students, Subject nameOfSubject) {


        List<Student> worstStudents = new ArrayList<>();
        int min = students.get(0).getHm().get(nameOfSubject);
        for (Student nameOfStudent : students) {
            Integer gradeOfStudent = nameOfStudent.getHm().get(nameOfSubject);

            if (gradeOfStudent != null && min > gradeOfStudent) {
                min = gradeOfStudent;
            }
        }
        for (Student nameOfStudent : students) {
            Integer gradeOfStudent = nameOfStudent.getHm().get(nameOfSubject);
            if (gradeOfStudent != null && gradeOfStudent == min) {
                worstStudents.add(nameOfStudent);
            }
        }
        return worstStudents;
    }

    public static List<Student> printMax(List<Student> students, Subject nameOfSubject) {
        Map<Integer, List<Student>> maxx = new TreeMap<>(Collections.reverseOrder());
        maxx.put(1, new ArrayList<>());
        maxx.put(2, new ArrayList<>());
        maxx.put(3, new ArrayList<>());
        maxx.put(4, new ArrayList<>());
        maxx.put(5, new ArrayList<>());
        maxx.put(6, new ArrayList<>());
        for (Student nameOfStudent : students) {
            Integer gradeOfStudent = nameOfStudent.getHm().get(nameOfSubject);
            if (gradeOfStudent == null) {
                continue;
            }
            maxx.get(gradeOfStudent).add(nameOfStudent);
        }
        for (Map.Entry<Integer, List<Student>> entry : maxx.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                return entry.getValue();
            }
        }
        return new ArrayList<>();
    }
}
