# Spring Setter Dependency Injection

This module demonstrates **Dependency Injection using Spring XML configuration**, with a focus on **Setter-based Dependency Injection**.

## Concepts

* Spring IoC Container
* Dependency Injection (DI)
* Setter Injection
* Spring Beans
* Bean References using `ref`
* XML-based configuration
* `ApplicationContext`

## Project Structure

The project contains two main classes:

* `Manager` — the class that depends on `Car`
* `Car` — the dependency injected into `Manager`

Spring creates and manages both objects.

## Dependency Injection

`Manager` has a dependency on `Car`:

```java
private Car carManager;
```

Instead of creating the `Car` object inside `Manager`, the dependency is provided by Spring through the setter method:

```java
public void setCarManager(Car carManager) {
    this.carManager = carManager;
}
```

This is called **Setter-based Dependency Injection**.

## Spring XML Configuration

The dependency is configured using the `ref` attribute:

```xml
<bean id="manager" class="org.j2os.Manager">
    <property name="carManager" ref="x1"/>
</bean>

<bean id="x1" class="org.j2os.Car"/>
```

Here:

* `x1` is the Spring bean representing `Car`.
* `ref="x1"` tells Spring to inject that bean into `Manager`.
* Spring calls `setCarManager(...)` during bean configuration.

### Object Flow

```text
Spring ApplicationContext
        ↓
    creates Car
        ↓
    creates Manager
        ↓
injects Car into Manager
        ↓
    manager.execute()
        ↓
      car.start()
```

## IoC vs DI

**IoC (Inversion of Control)** means that object creation and management are handled by the Spring container instead of the application code.

**DI (Dependency Injection)** is a way of implementing IoC by providing an object's dependencies from outside the object.

In this example:

```text
Spring → manages Manager
Spring → manages Car
Spring → injects Car into Manager
```

## Why Dependency Injection?

Without Dependency Injection, `Manager` could create its dependency directly:

```java
private Car carManager = new Car();
```

With Spring DI:

```java
private Car carManager;
```

and Spring provides the dependency.

This reduces direct coupling between `Manager` and the creation of `Car`.

## Key Interview Point

> **Setter Injection** means that Spring injects a dependency through a setter method after creating the bean.

In XML configuration, the dependency is commonly specified with:

```xml
<property name="carManager" ref="x1"/>
```

The `ref` attribute refers to another Spring bean.

## Purpose

This module is part of my **Spring Core learning journey** and focuses on understanding how Spring performs **Dependency Injection using XML configuration and setter methods**.
