package org.j2os;

public class Main {
    public static void main(String[] args) {

        Manager manager = (Manager) Spring.getBean("manager");
        manager.execute();

    }
}