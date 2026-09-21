package org.j2os;

import java.io.Serializable;

public class Person implements Serializable {

    public Person(){
        System.out.println("create new instance from person class");
    }

    private String name;
    private String family;

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setName(String name) {
        this.name = name;
    }
}
