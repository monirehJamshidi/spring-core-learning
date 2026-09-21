package org.j2os;

import java.rmi.server.UnicastRemoteObject;

public class PersonProviderUnicast extends UnicastRemoteObject implements PersonProviderRemote {

    public PersonProviderUnicast() throws Exception {

    }
    @Override
    public Person getPersonFromServer() throws Exception {
        Person person = new Person();
        person.setName("Monireh");
        person.setFamily("Jamshidi");
        return person;
    }
}
