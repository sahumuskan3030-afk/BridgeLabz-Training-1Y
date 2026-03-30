package com.gla.access.two;




import com.gla.access.one.Base;

public class Derived extends Base {

    public void testAccess() {

        System.out.println("Accessing methods from subclass in different package:\n");

        publicMethod();
        protectedMethod();


    }

    public static void main(String[] args) {
        Derived d = new Derived();
        d.testAccess();
    }
}
