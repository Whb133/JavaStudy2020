package Java8.Docs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stu {
    String name;
    int age;
    public Stu(){}
    public Stu(String name){
        this.name = name;
    }
    public Stu(String name,int age){
        this.name = name;
        this.age = age;
    }
    public static List<Stu> getStuInstances(){
        List<Stu> list = new ArrayList<>();
        list.add(new Stu("tom",22));
        list.add(new Stu("jerry",32));
        list.add(new Stu("jack",18));
        list.add(new Stu("loriy",22));
        list.add(new Stu("tim",23));
        return list;
    }
    public String getName() {
        return name;
    }

    public Stu getFriend(){
        return null;
    }
    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Stu stu = (Stu) o;
        return age == stu.age &&
                Objects.equals(name, stu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public int getAge() {
        return age;
    }
}