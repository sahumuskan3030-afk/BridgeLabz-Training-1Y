package com.gla.generics;

import java.util.*;

// 1. Abstract base class
abstract class CourseType {
    private String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public abstract String getEvaluationMethod();
}

// 2. Different course types

class ExamCourse extends CourseType {
    public ExamCourse(String name) {
        super(name);
    }

    @Override
    public String getEvaluationMethod() {
        return "Exam-Based Evaluation";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) {
        super(name);
    }

    @Override
    public String getEvaluationMethod() {
        return "Assignment-Based Evaluation";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String name) {
        super(name);
    }

    @Override
    public String getEvaluationMethod() {
        return "Research-Based Evaluation";
    }
}

// 3. Generic Course class
class Course<T extends CourseType> {
    private T courseType;

    public Course(T courseType) {
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseType.getCourseName());
        System.out.println("Type: " + courseType.getEvaluationMethod());
        System.out.println("---------------------------");
    }
}

// 4. University system using wildcards
class CourseManager {

    public static void printAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println("Course: " + course.getCourseName());
            System.out.println("Evaluation: " + course.getEvaluationMethod());
            System.out.println("-------------------");
        }
    }
}

// 5. Main class
public class UniversitySystem {
    public static void main(String[] args) {

        // Create different course types
        ExamCourse math = new ExamCourse("Mathematics");
        AssignmentCourse oop = new AssignmentCourse("Object Oriented Programming");
        ResearchCourse ai = new ResearchCourse("Artificial Intelligence Research");

        // Generic Course wrappers
        Course<ExamCourse> c1 = new Course<>(math);
        Course<AssignmentCourse> c2 = new Course<>(oop);
        Course<ResearchCourse> c3 = new Course<>(ai);

        // Display individually
        c1.displayCourseInfo();
        c2.displayCourseInfo();
        c3.displayCourseInfo();

        // Wildcard usage
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(math);
        allCourses.add(oop);
        allCourses.add(ai);

        System.out.println("\n=== All Courses (Wildcard Processing) ===");
        CourseManager.printAllCourses(allCourses);
    }
}
