package com.gla.instance.level2;

    public class Student {

        public int rollNumber;
        protected String name;
        private double CGPA;

        public Student(int rollNumber, String name, double CGPA) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.CGPA = CGPA;
        }

        public double getCGPA() {
            return CGPA;
        }

        public void setCGPA(double CGPA) {
            this.CGPA = CGPA;
        }

        public void displayStudentDetails() {
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("CGPA: " + CGPA);
            System.out.println("---------------------");
        }

        public static void main(String[] args) {
            Student s1 = new Student(101, "Alice", 9.2);
            s1.displayStudentDetails();
            s1.setCGPA(9.5);
            System.out.println("Updated CGPA: " + s1.getCGPA());
        }
    }

