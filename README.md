# Spring-all-program-


[Spring_DYP.pdf](https://github.com/user-attachments/files/20690977/Spring_DYP.pdf)


## Why Use Spring?
- **Dependency Injection**: Spring manages the creation and configuration of `MyBox` instances, decoupling object creation from usage.
- **Flexibility**: The three configuration styles (XML, Java, annotation) demonstrate different ways to achieve the same result, catering to various project needs.
- **Maintainability**: Spring's bean management makes it easier to modify configurations without changing code (especially in XML and Java-based approaches).
- **Scalability**: Annotation-based configuration is ideal for smaller projects, while XML and Java-based configurations suit larger, more complex applications.

# Spring Box Demo example

This repository contains a Java program that calculates the volume of a box, converted into a Spring-based application using Core Spring (not Spring Boot). The original program creates four `MyBox` instances with different configurations and calculates their volumes. This project demonstrates three different Spring configuration approaches:

1. **XML-Based Configuration**: Uses an XML file (`applicationContext.xml`) to define beans.
2. **Java-Based Configuration**: Uses a Java configuration class (`AppConfig`) with `@Bean` methods.
3. **Annotation-Based Configuration**: Uses `@Component` and `@Value` annotations with component scanning.

Each approach achieves the same functionality as the original program, leveraging Spring's dependency injection and bean management.

## Table of Contents
- [Original Program](#original-program)
- [Spring Implementations](#spring-implementations)
  - [XML-Based Configuration](#xml-based-configuration)
  - [Java-Based Configuration](#java-based-configuration)
  - [Annotation-Based Configuration](#annotation-based-configuration)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Setup and Running](#setup-and-running)
- [Output](#output)
- [Why Use Spring?](#why-use-spring)
- [License](#license)

## Original Program
The original Java program defines a `MyBox` class with fields for length (`len`), width (`wid`), and height (`hig`), along with constructors, setters, and a `volume()` method to calculate the box's volume. The `DemoObjects` class creates four `MyBox` instances:
- `b1`: Uses the default constructor (`len=1`, `wid=1`, `hig=1`).
- `b2`: Uses a single-parameter constructor (`len=wid=hig=5`).
- `b3`: Uses a three-parameter constructor (`len=3`, `wid=4`, `hig=5`).
- `b4`: Uses setters (`len=6`, `wid=3`, `hig=4`).

The program calls `volume()` on each instance to print the calculated volumes.

## Spring Implementations
The program is reimplemented in three ways using Core Spring, demonstrating different configuration styles. Each implementation creates the same four `MyBox` instances as beans and retrieves them from the Spring application context to calculate volumes.

### XML-Based Configuration
- **Overview**: Beans are defined in an XML file (`applicationContext.xml`) using `<bean>` elements. Constructor arguments and properties configure the beans.
- **Key Files**:
  - `MyBox.java`: Core class with constructors, getters, setters, and `volume()` method.
  - `applicationContext.xml`: Defines four beans (`box1`, `box2`, `box3`, `box4`) corresponding to the original instances.
  - `DemoObjects.java`: Uses `ClassPathXmlApplicationContext` to load the XML configuration and retrieve beans.
- **Configuration Details**:
  - `box1`: Uses the default constructor.
  - `box2`: Uses a single constructor argument (`5`).
  - `box3`: Uses three constructor arguments (`3`, `4`, `5`).
  - `box4`: Uses property setters (`len=6`, `wid=3`, `hig=4`).

### Java-Based Configuration
- **Overview**: Beans are defined in a Java configuration class (`AppConfig`) using `@Bean` methods, replacing the XML file.
- **Key Files**:
  - `MyBox.java`: Same as above.
  - `AppConfig.java`: Annotated with `@Configuration`, defines four `@Bean` methods for `box1`, `box2`, `box3`, and `box4`.
  - `DemoObjects.java`: Uses `AnnotationConfigApplicationContext` to load the `AppConfig` class and retrieve beans.
- **Configuration Details**:
  - Each `@Bean` method creates a `MyBox` instance, mirroring the original program's constructor and setter usage.
  - No XML file is needed, making the configuration programmatic.

### Annotation-Based Configuration
- **Overview**: Uses annotations like `@Component` and `@Value` to define and configure beans directly on classes, with `@ComponentScan` to detect them.
- **Key Files**:
  - `MyBox.java`: Same as above.
  - `Box1.java`, `Box2.java`, `Box3.java`: Subclasses of `MyBox` using `@Component` to define beans with constructor-based configurations.
  - `Box4.java`: Subclass using `@Value` annotations for setter-based configuration.
  - `DemoObjects.java`: Annotated with `@Configuration` and `@ComponentScan` to enable component scanning, loads the context, and retrieves beans.
- **Configuration Details**:
  - `Box1`: Uses the default constructor (`@Component("box1")`).
  - `Box2`: Calls the single-parameter constructor (`super(5)`).
  - `Box3`: Calls the three-parameter constructor (`super(3, 4, 5)`).
  - `Box4`: Uses `@Value` to set `len=6`, `wid=3`, `hig=4`.
  - Component scanning detects the annotated classes automatically.

## Project Structure
The project is organized into three directories, one for each configuration style:

```
spring-box-demo/
├── xml-config/
│   ├── src/
│   │   └── com/example/
│   │       ├── MyBox.java
│   │       └── DemoObjects.java
│   ├── resources/
│   │   └── applicationContext.xml
│   └── pom.xml
├── java-config/
│   ├── src/
│   │   └── com/example/
│   │       ├── MyBox.java
│   │       ├── AppConfig.java
│   │       └── DemoObjects.java
│   └── pom.xml
├── annotation-config/
│   ├── src/
│   │   └── com/example/
│   │       ├── MyBox.java
│   │       ├── Box1.java
│   │       ├── Box2.java
│   │       ├── Box3.java
│   │       ├── Box4.java
│   │       └── DemoObjects.java
│   └── pom.xml
```

Each directory contains a Maven `pom.xml` file for dependency management.

## Prerequisites
- **Java**: JDK 8 or higher.
- **Maven**: For building and managing dependencies (optional; you can manually include JARs).
- **Spring Framework**: Version 5.3.39 (Core Spring, specifically `spring-context` and its dependencies).

### Maven Dependencies
Each `pom.xml` includes:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.39</version>
    </dependency>
</dependencies>
```

If not using Maven, download the following JARs and add them to the classpath:
- `spring-context-5.3.39.jar`
- `spring-core-5.3.39.jar`
- `spring-beans-5.3.39.jar`
- `commons-logging-1.2.jar`

## Setup and Running
1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   ```

2. **Choose a Configuration**:
   Navigate to one of the directories (`xml-config`, `java-config`, or `annotation-config`).

3. **Build (with Maven)**:
   ```bash
   mvn clean compile
   ```

4. **Run the Program**:
   - For **XML-Based**:
     ```bash
     java -cp target/classes:lib/* com.example.DemoObjects
     ```
     Ensure `applicationContext.xml` is in the `resources/` folder and included in the classpath.
   - For **Java-Based** or **Annotation-Based**:
     ```bash
     java -cp target/classes:lib/* com.example.DemoObjects
     ```

   If not using Maven, compile and run manually:
   ```bash
   javac -cp "lib/*" src/com/example/*.java
   java -cp "lib/*:src" com.example.DemoObjects
   ```

   For XML-based, ensure `applicationContext.xml` is in the classpath.

## Output
All three implementations produce the same output as the original program:
```
Box volume: 1.0
Box volume: 125.0
Box volume: 60.0
Box volume: 72.0
```


