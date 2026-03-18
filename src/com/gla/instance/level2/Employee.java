package com.gla.instance.level2;



    class Employee {

        public String employeeID;
        protected String department;
        private double salary;

        public Employee(String employeeID, String department, double salary) {
            this.employeeID = employeeID;
            this.department = department;
            this.salary = salary;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public void displayEmployeeDetails() {
            System.out.println("Employee ID: " + employeeID);
            System.out.println("Department: " + department);
            System.out.println("Salary: $" + salary);
            System.out.println("----------------------");
        }
    }

    class Manager extends Employee {

        private int teamSize;

        public Manager(String employeeID, String department, double salary, int teamSize) {
            super(employeeID, department, salary);
            this.teamSize = teamSize;
        }

        public void displayManagerDetails() {
            System.out.println("Employee ID: " + employeeID);
            System.out.println("Department: " + department);
            System.out.println("Team Size: " + teamSize);
            System.out.println("Salary: $" + getSalary());
            System.out.println("----------------------");
        }

        public static void main(String[] args) {
            Manager mgr = new Manager("EMP101", "IT", 90000.0, 5);
            mgr.displayManagerDetails();
            mgr.setSalary(95000.0);
            System.out.println("Updated Salary: $" + mgr.getSalary());
        }
    }

