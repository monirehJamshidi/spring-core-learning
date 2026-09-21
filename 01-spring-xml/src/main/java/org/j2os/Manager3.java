package org.j2os;

public class Manager3 implements ManagerIX {

    private String name;

    public Manager3(String name){
        this.name = name;
        System.out.println("Manager3 constructor called: " + name);
    }

    @Override
    public void execute(){
        System.out.println("manager 3 execute invoked...   " + name
        );
    }
}
