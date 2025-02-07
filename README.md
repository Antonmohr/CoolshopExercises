# CoolshopExercises
Programmet er lavet med Maven for dependencies

For at køre det skal du køre main.java i den ønskede exercise mappe

##Exercise 1
Viser Opgave 1 som beskrevet i mailen 

- Gson: Bruges til at konvertere JSON til Java-objekter.
- Lombok: fjerner behovet for at skrive getters og setters.
- Java.net: Bruges til at foretage HTTP requests.


##Exercise 2
Viser calculate delivery date opgaven
- Java.Time: til at arbejde med tid og datoer 

# For at køre program

#Sikrer at du har Java 17 og Maven

#Naviger til project directory

#Køre følgende kommandoer i terminal:

mvn clean compile 

mvn package

#exercise 1:
mvn exec:java -Dexec.mainClass="com.coolshop.exercise1.Main"

#exercise 2:
mvn exec:java -Dexec.mainClass="com.coolshop.exercise2.Main"

