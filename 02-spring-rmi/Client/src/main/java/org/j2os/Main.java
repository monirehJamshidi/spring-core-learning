package org.j2os;

public class Main {

    public static void main(String[] args) {
        Person person = (Person) SpringContext.getBean("person");
        System.out.println(person.getName() + " " + person.getFamily());
    }
}
