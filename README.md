# sybex-1Z0-816-chapter-6
Code and commands from OCP Oracle Certified Professional Java SE 11 Programmer II Study Guide:: Exam 1Z0-816 by Jeanne Boyarsky and Scott Selikoff

The code in chapter 6 (modules) is a lot of file creation. Additionally, the commands can be hard to type in. Therefore we are providing a repository with the code from the book to facilitate running the examples.

Also see:
* Our [main book page](https://www.selikoff.net/ocp11-2/)
* To buy the book: [Amazon](https://www.amazon.com/Oracle-Certified-Professional-Programmer-Study/dp/1119617626/ref=sr_1_5?keywords=jeanne+boyarsky+ocp+11&qid=1572008221&sr=8-5)
* The [code examples for Appendix A](https://github.com/boyarsky/sybex-1Z0-815-chapter-11) same examples as Chapter 11 of our iZ0-815 book

# Analyzing JDK Dependencies
See the identify-dependencies folder for the code.

## Using jdeps

Compile Dino jar
```
javac zoo/dinos/*.java
```
Create zoo.dino.jar for Dino module
```
jar -cvf zoo.dino.jar .
```
Run jdeps commands
```
jdeps zoo.dino.jar
jdeps -s zoo.dino.jar
jdeps --jdk-internals zoo.dino.jar
```

# Migrating an Application
See the cyclic-dependencies folder for the code. 

## Failing to Compile with a Cyclic Dependency

Compile Butterfly module
```
javac -d butterflyModule butterflyModule/zoo/butterfly/Butterfly.java butterflyModule/module-info.java
```
Create zoo.butterfly.jar for Butterfly module
```
jar -cvf mods/zoo.butterfly.jar -C butterflyModule/ .
```
Compile Caterpillar module
```
javac -p mods -d caterpillarModule caterpillarModule/zoo/caterpillar/*.java caterpillarModule/module-info.java
```
Create zoo.caterpillar.jar for Caterpillar module
```
jar -cvf mods/zoo.caterpillar.jar -C caterpillarModule/ .
```
Compile Butterfly again to introduce cyclic dependency
```
javac -p mods -d butterflyModule butterflyModule/zoo/butterfly/Butterfly.java butterflyModule/module-info.java
```

# Creating a Service
See the services folder for the code.

## Declaring the Service Provider Interface
Compile service provider interface module
```
javac -d serviceProviderInterfaceModule serviceProviderInterfaceModule/zoo/tours/api/*.java serviceProviderInterfaceModule/module-info.java
```
Create zoo.tours.api.jar for the service provider interface module
```
jar -cvf mods/zoo.tours.api.jar -C serviceProviderInterfaceModule/ .
```

## Creating a Service Locator
Compile service locator module
```
javac -p mods -d serviceLocatorModule serviceLocatorModule/zoo/tours/reservations/*.java serviceLocatorModule/module-info.java
```
Create zoo.tours.reservations.jar for the service locator module
```
jar -cvf mods/zoo.tours.reservations.jar -C serviceLocatorModule/ .
```

## Invoking from a Consumer
Compile consumer module
```
javac -p mods -d consumerModule consumerModule/zoo/visitor/*.java consumerModule/module-info.java
```
Create zoo.visitor.jar for the visitor module
```
jar -cvf mods/zoo.visitor.jar -C consumerModule/ .
```
Run Tourist class
```
java -p mods -m zoo.visitor/zoo.visitor.Tourist
```

## Adding a Service Provider
Compile service provider module
```
javac -p mods -d serviceProviderModule serviceProviderModule/zoo/tours/agency/*.java serviceProviderModule/module-info.java
```
Create zoo.tours.agency.jar for the service provider module
```
jar -cvf mods/zoo.tours.agency.jar -C serviceProviderModule/ .
```
Run Tourist class
```
java -p mods -m zoo.visitor/zoo.visitor.Tourist
```

## Merging Service Locator and Consumer
Compile multi-purpose module
```
javac -p mods -d multiPurposeModule multiPurposeModule/zoo/tours/hybrid/*.java multiPurposeModule/module-info.java
```
Create zoo.tours.hybrid.jar for the multi-purpose module
```
jar -cvf mods/zoo.tours.hybrid.jar -C multiPurposeModule/ .
```
Run TourLengthCheck class
```
java -p mods -m zoo.tours.hybrid/zoo.tours.hybrid.TourLengthCheck
```