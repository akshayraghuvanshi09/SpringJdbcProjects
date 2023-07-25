package com.jdbc_hurix.Demo;

import java.util.*;
import java.util.stream.Collectors;

public class First {
    public static void main(String[] args) {
        List<Student> lt=new ArrayList<>();

        lt.add(new Student(1, "Geeks"));
        lt.add(new Student(2, "For"));
        lt.add(new Student(3, "Geeks"));


        LinkedHashMap<Integer, String> collect = lt.stream().collect(Collectors.
                toMap(Student::getId, Student::getName, (x, y) -> x + "," + y, LinkedHashMap::new));

        Set<String> st=new HashSet<>();
       lt.stream().filter(student -> !st.add(student.getName())).forEach(System.out::println);

    }
}
