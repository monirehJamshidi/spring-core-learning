# Spring + Java RMI

This module demonstrates how Spring can work with a Java RMI client/server application and create a bean using a factory method.

## Concepts

* Java RMI
* Remote Interface
* RMI Registry
* `UnicastRemoteObject`
* `Serializable`
* Spring `ApplicationContext`
* Spring Factory Bean
* Factory Method configuration

## Architecture

The project contains two parts:

```text
Client
   │
   │ RMI call
   ↓
Server
   │
   ↓
PersonProviderUnicast
   │
   ↓
Person
```

The client does not create the `Person` object directly.

Instead, Spring uses `ManagerFactory` to obtain the object:

```xml
<bean id="person"
      factory-bean="managerFactory"
      factory-method="getPerson"/>

<bean id="managerFactory"
      class="org.j2os.ManagerFactory"/>
```

## Server

The server starts an RMI registry on port `1099`:

```java
LocateRegistry.createRegistry(1099);
Naming.rebind("sap", new PersonProviderUnicast());
```

`PersonProviderUnicast` implements the remote interface and provides the `Person` object:

```java
@Override
public Person getPersonFromServer() throws Exception {
    Person person = new Person();
    person.setName("Monireh");
    person.setFamily("Jamshidi");
    return person;
}
```

## Client

The client retrieves the `Person` bean from Spring:

```java
Person person =
        (Person) SpringContext.getBean("person");
```

Spring invokes:

```text
managerFactory
      ↓
getPerson()
      ↓
RMI lookup
      ↓
Remote server
      ↓
Person
```

## Key Learning Point

The main Spring concept demonstrated here is **Factory Method configuration**.

Instead of allowing Spring to create the `Person` object directly using its constructor, Spring delegates object creation to a factory method:

```xml
factory-bean="managerFactory"
factory-method="getPerson"
```

## Note

This project is a learning example combining Spring Core concepts with Java RMI. The RMI part is used to demonstrate how a Spring-managed factory can obtain an object from a remote service.
