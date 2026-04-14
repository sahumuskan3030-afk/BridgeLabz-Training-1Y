package com.gla.generics;

import java.util.*;

// Base class
class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println(name + " makes a sound");
    }
}

// Subclasses
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(name + " barks");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(name + " meows");
    }
}

public class Class {

    // Method using wildcard
    public static void printAnimals(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            animal.speak();
        }
    }

    public static void main(String[] args) {

        List<Dog> dogs = Arrays.asList(
                new Dog("Buddy"),
                new Dog("Rocky")
        );

        List<Cat> cats = Arrays.asList(
                new Cat("Kitty"),
                new Cat("Luna")
        );

        System.out.println("Dogs:");
        printAnimals(dogs);

        System.out.println("\nCats:");
        printAnimals(cats);
    }
}
