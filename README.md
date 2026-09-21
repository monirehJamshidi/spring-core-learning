# Spring Core Learning

A hands-on Java project for learning and practicing core Spring Framework concepts.

This repository follows my learning path from **XML-based Spring configuration** to **annotation-based Dependency Injection**.

## Topics Covered

### Spring XML Configuration

* Spring Beans
* `ApplicationContext`
* Setter Injection
* Constructor Injection
* Singleton Scope
* Prototype Scope
* Lazy Initialization
* Eager Initialization

### Spring RMI & Factory Method

* Java RMI
* RMI Registry
* Remote Interfaces
* `UnicastRemoteObject`
* `Serializable`
* Spring `factory-bean`
* Spring `factory-method`
* Client/Server communication

### Dependency Injection

* Dependency Injection (DI)
* Setter-based Dependency Injection
* `ref` in XML configuration
* Constructor Injection
* Interface-based Dependency Injection

### Annotation-Based Configuration

* Component Scanning
* `@Component`
* `@Service`
* `@Autowired`
* `@Qualifier`
* `@Scope`
* Constructor Injection
* Prototype Scope

## Project Structure

```text
spring-core-learning/
│
├── 01-spring-xml/
│   ├── README.md
│   └── Spring XML configuration
│
├── 02-spring-rmi/
│   ├── README.md
│   ├── client/
│   └── server/
│
├── 03-spring-setter-di/
│   ├── README.md
│   └── Setter-based Dependency Injection
│
└── 04-annotation-di/
    ├── README.md
    └── Annotation-based Dependency Injection
```

## Learning Path

The examples are organized to gradually introduce Spring Core concepts:

```text
Spring XML Configuration
        ↓
Bean Management & Scopes
        ↓
Spring RMI & Factory Method
        ↓
Setter-based Dependency Injection
        ↓
Annotation-based Dependency Injection
        ↓
Constructor Injection
        ↓
@Qualifier & Component Scanning
```

## Key Concept

The main goal of this project is to understand **Inversion of Control (IoC)** and **Dependency Injection (DI)** through practical examples.

Instead of creating and wiring objects manually:

```java
Car car = new Kia();
Manager manager = new Manager(car);
```

Spring manages the objects and injects their dependencies:

```java
@Component
public class Manager {

    private final Car car;

    public Manager(@Qualifier("kia") Car car) {
        this.car = car;
    }
}
```

## Technologies

* Java
* Spring Framework
* Spring Core
* XML Configuration
* Annotation-based Configuration
* Java RMI

## Learning Status

This repository is part of my ongoing journey to strengthen my **Java and Spring skills** and prepare for professional Java/Spring development.
