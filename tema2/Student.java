package tema2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Student {

    String name;
    double grade;

    static  Map<Integer, TreeSet<Student>> studentMap;

    static void initStudents() {

        studentMap = new HashMap<>();

        for (int i = 0; i <= 10; i++) {
            studentMap.put(i, new TreeSet<>(Comparator.comparing(Student::getGrade).reversed()));
        }
    }

    static void add(Student student) {

        Integer grade = Math.toIntExact(Math.round(student.getGrade()));

        TreeSet<Student> students = studentMap.get(grade);
        students.add(student);

        studentMap.put(grade, students);
    }
    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    static void print() {

        for (int i = 0; i <= 10; i++) {

            System.out.println(i + ": ");
            for(Student st: studentMap.get(i)) {

                System.out.print(st.getName() + " " + st.getGrade() + " ");
            }
            System.out.println();
        }
    }


    public double getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        Student st1 = new Student("Ionel", 2.3);
        Student st2 = new Student("Ioane", 1.7);
        Student st3 = new Student("Marcus", 2.49);
        Student st4 = new Student("Mircea", 5.5);
        Student st5 = new Student("Mihnea", 6.3);
        Student st6 = new Student("Coco", 5.4);


        Student.initStudents();

        add(st1);
        add(st2);
        add(st3);
        add(st4);
        add(st5);
        add(st6);

        print();

    }
}
