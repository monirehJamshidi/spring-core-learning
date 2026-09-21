# Spring Annotation-based Dependency Injection

This module demonstrates **Dependency Injection using Spring annotations** instead of defining application beans explicitly in XML.

The project focuses on:

* Component Scanning
* `@Component`
* `@Service`
* `@Autowired`
* `@Qualifier`
* Constructor Injection
* Prototype Scope
* Dependency Injection with interfaces

## Concepts

* Spring IoC Container
* Dependency Injection (DI)
* Annotation-based configuration
* Component Scanning
* Constructor Injection
* `@Component`
* `@Service`
* `@Qualifier`
* Bean Scope
* Prototype Scope

## Project Structure

The project contains:

* `Car` — interface representing the dependency
* `Bmw` — implementation of `Car`
* `Kia` — another implementation of `Car`
* `Manager` — class that depends on `Car`
* `SpringContext` — provides access to the Spring `ApplicationContext`
* `spring.xml` — enables component scanning

## Component Scanning

Spring scans the package specified in the XML configuration:

```xml
<context:component-scan base-package="org.j2os"/>
```

This allows Spring to automatically detect classes annotated with Spring stereotype annotations such as:

```java
@Component
@Service
@Repository
@Controller
```

and register them as Spring Beans.

## `@Service`

Both `Bmw` and `Kia` are registered as Spring Beans using `@Service`:

```java
@Service("bmw")
public class Bmw implements Car {
    ...
}
```

and:

```java
@Service("kia")
public class Kia implements Car {
    ...
}
```

Therefore, Spring creates two beans that implement the same `Car` interface:

```text
bmw → Bmw
kia → Kia
```

## Constructor Injection

`Manager` receives its dependency through its constructor:

```java
private final Car car;

public Manager(@Qualifier("kia") Car car) {
    this.car = car;
}
```

This is called **Constructor-based Dependency Injection**.

The dependency is provided when Spring creates the `Manager` bean.

### Why Constructor Injection?

Constructor injection makes the dependency explicit:

```text
Manager requires Car
        ↓
Car must be provided when Manager is created
```

It also allows the dependency to be stored in a `final` field.

For modern Spring applications, **constructor injection is generally preferred over field injection**.

## `@Qualifier`

There are two Spring Beans implementing the same interface:

```text
Car
├── Bmw
└── Kia
```

If Spring only sees:

```java
public Manager(Car car) {
    this.car = car;
}
```

there are multiple candidates for the `Car` dependency.

`@Qualifier` tells Spring which bean should be injected:

```java
public Manager(@Qualifier("kia") Car car) {
    this.car = car;
}
```

Therefore:

```text
Manager
   ↓
@Qualifier("kia")
   ↓
Kia bean
```

and `Kia.start()` is executed.

## Prototype Scope

`Manager` is configured with:

```java
@Component
@Scope("prototype")
public class Manager {
    ...
}
```

This means Spring creates a new `Manager` instance each time the `Manager` bean is requested from the container.

The default scope in Spring is **singleton**.

Common scopes include:

* `singleton`
* `prototype`
* `request`
* `session`
* `application`
* `websocket`

`singleton` and `prototype` are the main scopes demonstrated in this learning repository.

## `@Component` vs `@Service`

Both can register a class as a Spring Bean.

In this project:

```java
@Component
public class Manager {
    ...
}
```

is used for a general Spring-managed component.

```java
@Service("kia")
public class Kia implements Car {
    ...
}
```

is used for a service-layer component.

`@Service` is a specialization of `@Component`.

## Application Flow

```text
spring.xml
    ↓
component-scan
    ↓
Spring discovers @Component and @Service
    ↓
Bmw Bean
Kia Bean
Manager Bean
    ↓
Spring creates Manager
    ↓
@Qualifier("kia")
    ↓
Kia is injected into Manager
    ↓
manager.execute()
    ↓
kia.start()
```

## Annotation-based DI vs XML Setter DI

In the previous module, the dependency was configured explicitly in XML:

```xml
<property name="carManager" ref="x1"/>
```

In this module, Spring discovers the components automatically and performs constructor injection:

```java
public Manager(@Qualifier("kia") Car car) {
    this.car = car;
}
```

### Previous module

```text
XML configuration
      ↓
Setter Injection
      ↓
<property ... ref="...">
```

### This module

```text
Annotations
      ↓
Component Scanning
      ↓
Constructor Injection
      ↓
@Qualifier
```

## Interview Notes

### What does `@Component` do?

It marks a class as a Spring-managed component so that it can be discovered through component scanning.

### What does `@Service` do?

`@Service` is a specialization of `@Component`, commonly used for service-layer classes.

### Why is `@Qualifier` needed?

When multiple Spring Beans match the same dependency type, `@Qualifier` identifies the specific bean that should be injected.

### What is Constructor Injection?

Constructor Injection means that a dependency is provided through the class constructor by the Spring container.

### What is Component Scanning?

Component Scanning allows Spring to automatically discover classes annotated with stereotype annotations and register them as Beans.

### What is the default Spring Bean scope?

The default scope is **singleton**.

### What is prototype scope?

With prototype scope, Spring creates a new Bean instance each time the Bean is requested from the container.

## Purpose

This module is part of my **Spring Core learning journey** and focuses on understanding modern annotation-based Dependency Injection, Component Scanning, Constructor Injection, `@Qualifier`, and Bean Scopes.
