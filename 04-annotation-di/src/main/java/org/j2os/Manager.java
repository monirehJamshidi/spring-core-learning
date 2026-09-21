package org.j2os;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Manager {

//    @Autowired
//    @Qualifier("kia")
//    private Car car;

    private final Car car;

    public Manager(@Qualifier("kia")Car car){
        this.car = car;
    }


    public void execute() {
        System.out.println("manager 1: execute invoked....");
        car.start();
    }
}
