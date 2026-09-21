package org.j2os;

public class Main {
    public static void main(String[] args) {

        Manager manager = (Manager) SpringContext.getBean("manager");
        manager.execute();

    }
}