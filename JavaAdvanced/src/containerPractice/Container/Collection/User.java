package containerPractice.Container.Collection;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    transient int flag;
    String name;
    int age;


    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User us = (User) o;
        return age == us.age &&
                Objects.equals(name, us.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "us{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
