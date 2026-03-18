package com.gla.instance.level1;



    public class Person {

        private String name;
        private int age;

        // Default constructor
        public Person() {
            this.name = "Unknown";
            this.age = 0;
        }

        // Parameterized constructor
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Copy constructor
        public Person(Person other) {
            this.name = other.name;
            this.age = other.age;
        }

        // Getter methods
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        // Setter methods
        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        // Display method
        public void display() {
            System.out.println("Name: " + name + ", Age: " + age);
        }

        // Main method for testing
        public static void main(String[] args) {
            Person original = new Person("Alice", 25);
            Person copy = new Person(original); // Using copy constructor

            System.out.println("Original Person:");
            original.display();

            System.out.println("Copied Person:");
            copy.display();
        }
    }

