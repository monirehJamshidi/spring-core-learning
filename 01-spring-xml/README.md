# Spring XML Configuration

This module demonstrates basic Spring Core concepts using XML-based configuration.

## Concepts

* Spring IoC Container
* ApplicationContext
* Spring Beans
* Singleton Scope
* Prototype Scope
* Eager Initialization
* Lazy Initialization
* Setter Injection
* Constructor Injection

## Examples

### Singleton

By default, Spring beans use singleton scope.

```xml
<bean id="humanManager1"
      class="org.j2os.Manager1"/>
```

Multiple calls to `getBean()` return the same instance.

### Prototype

A prototype bean creates a new instance for each `getBean()` request.

```xml
<bean id="humanManager2"
      class="org.j2os.Manager1"
      scope="prototype"/>
```

### Lazy Initialization

A lazy bean is created when it is first requested.

```xml
<bean id="humanManager4"
      class="org.j2os.Manager1"
      lazy-init="true"/>
```

### Setter Injection

Spring injects the property through the setter method.

```xml
<property name="dataBaseName"
          value="DB2"/>
```

### Constructor Injection

Spring provides constructor arguments when creating the bean.

```xml
<constructor-arg index="0"
                 value="My SQL"/>
```

## Purpose

This module is part of my Spring learning journey and focuses on understanding how the Spring container creates, configures, and manages objects.
