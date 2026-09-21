package org.j2os;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Singleton Bean ===");

        ManagerIX manager1 =
                (ManagerIX) Spring.getBean("humanManager1");

        ManagerIX manager2 =
                (ManagerIX) Spring.getBean("humanManager1");

        System.out.println(manager1 == manager2);


        System.out.println("\n=== Prototype Bean ===");

        ManagerIX prototype1 =
                (ManagerIX) Spring.getBean("humanManager2");

        ManagerIX prototype2 =
                (ManagerIX) Spring.getBean("humanManager2");

        System.out.println(prototype1 == prototype2);

        System.out.println("\n=== Lazy Initialization ===");

        ManagerIX lazyManager =
                (ManagerIX) Spring.getBean("humanManager4");

        lazyManager.execute();

        System.out.println("\n=== Constructor Injection ===");

        ManagerIX manager3 =
                (ManagerIX) Spring.getBean("humanManager5");

        manager3.execute();

    }
}