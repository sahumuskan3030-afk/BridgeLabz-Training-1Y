package com.gla.school.main;



// On-demand imports (as required)
import com.gla.school.data.*;
import com.gla.school.util.*;

    public class MainApp {

        public static void main(String[] args) {

            // Create Student object
            Studentt s = new Studentt("Amit", 85, 78, 92);

            // Create Analyzer object
            Analyzer analyzer = new Analyzer();

            // Calculate average and grade
            double avg = analyzer.calculateAverage(s);
            String grade = analyzer.findGrade(avg);

            // Display results
            System.out.println(s); // calls toString()

            System.out.println("\nAverage: " + avg);
            System.out.println("Grade: " + grade);
        }
    }

