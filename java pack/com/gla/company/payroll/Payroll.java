package com.gla.company.payroll;



import com.gla.company.hr.Employee.Employee;

    public class Payroll {

        public void calculateBonus(Employee e) {
            double bonus = e.getSalary() * 0.10;
            double newSalary = e.getSalary() + bonus;
            e.setSalary(newSalary);

            System.out.println("Bonus added: " + bonus);
        }
    }

