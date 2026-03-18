package com.gla.instance.level2;



    public class Course {

        private String courseName;
        private int duration;
        private double fee;

        private static String instituteName = "ABC Institute";

        public Course(String courseName, int duration, double fee) {
            this.courseName = courseName;
            this.duration = duration;
            this.fee = fee;
        }

        public void displayCourseDetails() {
            System.out.println("Institute Name: " + instituteName);
            System.out.println("Course Name: " + courseName);
            System.out.println("Duration: " + duration + " months");
            System.out.println("Fee: $" + fee);
            System.out.println("---------------------------");
        }

        public static void updateInstituteName(String newName) {
            instituteName = newName;
        }

        public static void main(String[] args) {
            Course c1 = new Course("Java Programming", 6, 500.0);
            Course c2 = new Course("Data Science", 8, 800.0);

            c1.displayCourseDetails();
            c2.displayCourseDetails();

            Course.updateInstituteName("XYZ Academy");

            c1.displayCourseDetails();
            c2.displayCourseDetails();
        }
    }

