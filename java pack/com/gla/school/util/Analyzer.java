package com.gla.school.util;



import com.gla.school.data.Studentt;

    public class Analyzer {

        // Calculate average marks
        public double calculateAverage(Studentt s) {
            return (s.getMarks1() + s.getMarks2() + s.getMarks3()) / 3.0;
        }

        // Determine grade based on average
        public String findGrade(double avg) {
            if (avg >= 90) return "A+";
            else if (avg >= 75) return "A";
            else if (avg >= 60) return "B";
            else if (avg >= 50) return "C";
            else return "Fail";
        }
    }

