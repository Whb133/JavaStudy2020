package JavaCommomClass.ComparePractice;

import java.util.Objects;

public class User implements Comparable{
    String name;
    int  age;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {

        if (o instanceof User){
            User user = (User)o;
            return this.name.compareTo(user.name);
        }else {
            throw new RuntimeException("数据类型不匹配！");
        }

    }
}
