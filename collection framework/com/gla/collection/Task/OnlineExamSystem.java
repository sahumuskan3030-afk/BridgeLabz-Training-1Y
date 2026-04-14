package com.gla.collection.Task;
import java.util.*;

class Question {
    int id;
    String text;

    public Question(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Q" + id + ": " + text;
    }
}
class Student {
    String studentId;
    String name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " (" + studentId + ")";
    }
}


public class OnlineExamSystem {

    public static void main(String[] args) {

        // 1. Enroll students (Set for uniqueness)
        Set<String> studentIds = new HashSet<>();
        Queue<Student> studentQueue = new LinkedList<>();

        enrollStudent(studentIds, studentQueue, new Student("S1", "Alice"));
        enrollStudent(studentIds, studentQueue, new Student("S2", "Bob"));
        enrollStudent(studentIds, studentQueue, new Student("S1", "Alice Duplicate")); // duplicate

        // 2. Add and randomize questions
        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question(1, "What is Java?"));
        questionList.add(new Question(2, "Explain OOP concepts."));
        questionList.add(new Question(3, "What is a Queue?"));

        Collections.shuffle(questionList);
        System.out.println("Randomized Questions: " + questionList);

        // 3. Serve students from queue
        while (!studentQueue.isEmpty()) {
            Student student = studentQueue.poll();
            System.out.println("\nServing student: " + student);

            // 4. Question navigation using Stack
            takeExam(student, questionList);
        }
    }

    // Enroll student with duplicate check
    public static void enrollStudent(Set<String> studentIds, Queue<Student> queue, Student student) {
        if (studentIds.add(student.studentId)) {
            queue.offer(student);
            System.out.println("Enrolled: " + student);
        } else {
            System.out.println("Duplicate ID! Enrollment rejected for: " + student);
        }
    }

    // Simulate exam navigation
    public static void takeExam(Student student, List<Question> questions) {
        Stack<Question> history = new Stack<>();

        for (Question q : questions) {
            System.out.println("Showing: " + q);

            // Push to stack for back navigation
            history.push(q);

            // Simulate "back" action randomly
            if (history.size() > 1 && new Random().nextBoolean()) {
                history.pop(); // current
                Question previous = history.peek();
                System.out.println("Going back to: " + previous);
            }
        }
    }
}
