package org.j2os;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Singleton Bean ===");

        ManagerIX manager1 =
                (ManagerIX) SpringContext.getBean("humanManager1");

        ManagerIX manager2 =
                (ManagerIX) SpringContext.getBean("humanManager1");

        System.out.println("Same instance: " + (manager1 == manager2));


        System.out.println("\n=== Prototype Bean ===");

        ManagerIX prototype1 =
                (ManagerIX) SpringContext.getBean("humanManager2");

        ManagerIX prototype2 =
                (ManagerIX) SpringContext.getBean("humanManager2");

        System.out.println("Same instance: " + (prototype1 == prototype2));

        System.out.println("\n=== Lazy Initialization ===");

        ManagerIX lazyManager =
                (ManagerIX) SpringContext.getBean("humanManager4");

        lazyManager.execute();

        System.out.println("\n=== Constructor Injection ===");

        ManagerIX manager3 =
                (ManagerIX) SpringContext.getBean("humanManager5");

        manager3.execute();

    }
}