package ReflectionPractice.ReflectionCodes.Util;

import java.io.IOException;

@MyAnnotation(value = "main")
public class Employee extends People<String> implements Comparable,MyInterface{

    public String name;
    private int age;

    public Employee() {

    }

    @MyAnnotation(value = "construct")
    public Employee(String name) {
        this.name = name;
    }

    private Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @MyAnnotation
    public void showName()throws IOException,NullPointerException {
        System.out.println("MY name is " + name);
    }

    private void show(String str) {
        System.out.println(str+" MY name is " + name + " ,MY age is " + age);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void info() {
        System.out.println("职员");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
    public static void eat(String foodname){
        System.out.println("eating "+foodname);
    }
    public static void sleep(){
        System.out.println("sleeping!");
    }
}
