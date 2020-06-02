package raport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private long pesel;
    private Map<Subject, Integer> hm = new HashMap<Subject, Integer>();


    public Student(String name, long pesel) {
        this.name = name;
        this.pesel = pesel;

    }

    public String toString() {

        return name + "  " + "Pesel: " + pesel + "  ";
    }


    public Map<Subject, Integer> getHm() {
        return hm;
    }
}