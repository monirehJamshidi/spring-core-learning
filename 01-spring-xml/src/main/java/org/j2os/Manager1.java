package org.j2os;

public class Manager1 implements ManagerIX {
    private String dataBaseName;

    public Manager1()
    {
        System.out.println("Manager1");
    }

    public String getDataBaseName() {
        return dataBaseName;
    }

    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }

    public void execute(){
        System.out.println("manager 1 execute invoked...   ".concat(dataBaseName));
    }
}
