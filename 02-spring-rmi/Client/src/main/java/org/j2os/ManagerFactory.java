package org.j2os;

import java.rmi.Naming;

public class ManagerFactory {

    public Person getPerson() throws Exception{
        System.out.println("getPerson invoked...");

        PersonProviderRemote personProviderRemote =
                (PersonProviderRemote) Naming.lookup("//localhost/sap");
        return personProviderRemote.getPersonFromServer();
    }
}
