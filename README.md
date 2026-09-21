# Spring Core Learning

A hands-on Java project for learning and practicing core Spring Framework concepts.

This repository follows my learning path from XML-based Spring configuration to annotation-based Dependency Injection.

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
* Factory Method

### Annotation-Based Configuration

* `@Component`
* `@Service`
* `@Autowired`
* `@Qualifier`
* `@Scope`
* Constructor Injection

### Remote Integration

* Java RMI
* Factory Method integration with Spring

## Project Structure

```text
01-spring-xml
    Spring XML configuration
    Bean scopes
    Lazy/Eager initialization
    Constructor and Setter Injection

02-spring-rmi
    Java RMI client/server example

03-factory-method
    Spring Factory Method example

04-annotation-di
    Annotation-based Dependency Injection
    @Component
    @Service
    @Autowired
    @Qualifier
    Constructor Injection
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

This repository is part of my ongoing journey to strengthen my Java and Spring skills and prepare for professional Java/Spring development.
