package org.j2os;

import org.springframework.stereotype.Service;

@Service("bmw")
public class Bmw implements Car {

    @Override
    public void start(){
        System.out.println("BMW started");
    }
}
