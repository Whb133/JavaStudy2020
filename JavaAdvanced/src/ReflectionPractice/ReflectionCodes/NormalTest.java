package ReflectionPractice.ReflectionCodes;

public class NormalTest {
    public static void main(String[] args) {
        Student s1 = new Student("tom");
        //使用new+构造方法无法使用私有的构造器new对象
        //Student s2 = new Student("jerry",20);
        s1.setAge(20);
        s1.name = "tom123";
        //对象直接无法修改私有属性，除非调用set方法
        //s1.age = 22;
        System.out.println(s1);
        s1.showName();
        //自身类外对象直接无法调用私有方法
        //s1.show();

    }
}
