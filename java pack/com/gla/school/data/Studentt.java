package com.gla.school.data;


    public class Studentt {
        private String name;
        private int marks1;
        private int marks2;
        private int marks3;

        // Constructor
        public Studentt(String name, int marks1, int marks2, int marks3) {
            this.name = name;
            this.marks1 = marks1;
            this.marks2 = marks2;
            this.marks3 = marks3;
        }

        // Getters
        public String getName() {
            return name;
        }

        public int getMarks1() {
            return marks1;
        }

        public int getMarks2() {
            return marks2;
        }

        public int getMarks3() {
            return marks3;
        }

        // toString() method
        @Override
        public String toString() {
            return "Student Name: " + name +
                    "\nMarks 1: " + marks1 +
                    "\nMarks 2: " + marks2 +
                    "\nMarks 3: " + marks3;
        }
    }

