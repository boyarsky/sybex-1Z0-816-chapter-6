# sybex-1Z0-816-chapter-6
Code and commands from OCP Oracle Certified Professional Java SE 11 Programmer II Study Guide:: Exam 1Z0-816 by Jeanne Boyarsky and Scott Selikoff

The code in chapter 6 (modules) is a lot of file creation. Additionally, the commands can be hard to type in. Therefore we are providing a repository with the code from the book to facilitate running the examples.

Also see:
* Our [main book page](https://www.selikoff.net/ocp11-2/)
* To buy the book: [Amazon](https://www.amazon.com/Oracle-Certified-Professional-Programmer-Study/dp/1119617626/ref=sr_1_5?keywords=jeanne+boyarsky+ocp+11&qid=1572008221&sr=8-5)
* The [code examples for Appendix A](https://github.com/boyarsky/sybex-1Z0-815-chapter-11) same examples as Chapter 11 of our iZ0-815 book

# Analyzing JDK Dependencies
## Using jdeps
See the identify-dependencies folder for the code.

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
## Failing to Compile with a Cyclic Dependency
See the cyclic-dependencies folder for the code. 

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