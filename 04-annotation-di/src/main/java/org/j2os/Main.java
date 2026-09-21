package org.j2os;

public class Main {
    public static void main(String[] args)throws ClassNotFoundException {

        Manager manager1 = (Manager) SpringContext.getBean("manager");
        manager1.execute();
    }
}
