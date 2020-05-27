package JavaCommomClass.ComparePractice;

public class User implements Comparable{
    String name;
    int  age;

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
