package org.j2os;

public class Manager {

    private Car carManager;

    public Car getCarManager() {
        return carManager;
    }

    public void setCarManager(Car carManager) {
        this.carManager = carManager;
    }

    public void execute(){
        System.out.println("manager 1 execute invoked...   ");

        carManager.start();
    }
}
