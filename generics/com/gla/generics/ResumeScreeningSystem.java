package com.gla.generics;

import java.util.*;


// 1. Abstract JobRole
abstract class JobRole {
    private String name;

    public JobRole(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return name;
    }

    public abstract int evaluateSkillScore();
}


// 2. Concrete Job Roles

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }

    @Override
    public int evaluateSkillScore() {
        return 90; // AI score simulation
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }

    @Override
    public int evaluateSkillScore() {
        return 88;
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }

    @Override
    public int evaluateSkillScore() {
        return 85;
    }
}


// 3. Generic Resume Class
class Resume<T extends JobRole> {
    private String candidateName;
    private T role;

    public Resume(String candidateName, T role) {
        this.candidateName = candidateName;
        this.role = role;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getRole() {
        return role;
    }

    public void displayResume() {
        System.out.println("Candidate: " + candidateName);
        System.out.println("Applied Role: " + role.getRoleName());
        System.out.println("AI Skill Score: " + role.evaluateSkillScore());
        System.out.println("--------------------------");
    }
}


// 4. AI Screening Engine (Generic + Wildcards)
class AIScreeningEngine {

    // Generic method: processes single resume
    public static <T extends JobRole> boolean screenResume(Resume<T> resume) {
        int score = resume.getRole().evaluateSkillScore();
        System.out.println("Screening " + resume.getCandidateName() +
                " for " + resume.getRole().getRoleName());

        return score >= 85; // threshold
    }

    // Wildcard method: processes multiple job roles
    public static void bulkScreen(List<? extends JobRole> roles) {
        System.out.println("\n=== Bulk AI Screening Report ===");

        for (JobRole role : roles) {
            System.out.println("Role: " + role.getRoleName());
            System.out.println("AI Score: " + role.evaluateSkillScore());
            System.out.println("Status: " + (role.evaluateSkillScore() >= 85 ? "Shortlisted" : "Rejected"));
            System.out.println("----------------------------");
        }
    }
}


// 5. Main System
public class ResumeScreeningSystem {
    public static void main(String[] args) {

        // Create job roles
        SoftwareEngineer se = new SoftwareEngineer();
        DataScientist ds = new DataScientist();
        ProductManager pm = new ProductManager();

        // Create resumes (Generic Class usage)
        Resume<SoftwareEngineer> r1 = new Resume<>("Alice", se);
        Resume<DataScientist> r2 = new Resume<>("Bob", ds);
        Resume<ProductManager> r3 = new Resume<>("Charlie", pm);

        // Display resumes
        r1.displayResume();
        r2.displayResume();
        r3.displayResume();

        // Generic method usage
        System.out.println("Alice shortlisted? " +
                AIScreeningEngine.screenResume(r1));

        System.out.println("Bob shortlisted? " +
                AIScreeningEngine.screenResume(r2));

        // Wildcard usage (mixed roles list)
        List<JobRole> rolePool = new ArrayList<>();
        rolePool.add(se);
        rolePool.add(ds);
        rolePool.add(pm);

        AIScreeningEngine.bulkScreen(rolePool);
    }
}
