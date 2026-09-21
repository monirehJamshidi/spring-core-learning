package org.j2os;

import org.springframework.stereotype.Service;

@Service("kia")
public class Kia implements Car{
    @Override
    public void start() {
        System.out.println("KIA started");

    }
}
