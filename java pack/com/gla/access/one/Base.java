package com.gla.access.one;



    public class Base {

        public void publicMethod() {
            System.out.println("Public method accessed");
        }

        protected void protectedMethod() {
            System.out.println("Protected method accessed");
        }

        void defaultMethod() {
            System.out.println("Default method accessed");
        }

        private void privateMethod() {
            System.out.println("Private method accessed");
        }

        // Method to test access within same class
        public void accessWithinClass() {
            publicMethod();
            protectedMethod();
            defaultMethod();
            privateMethod(); // accessible here
        }
    }

