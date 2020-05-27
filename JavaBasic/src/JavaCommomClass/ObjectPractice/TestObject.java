package JavaCommomClass.ObjectPractice;

public class TestObject {
    public static void main (String[] args){
        Person p = new Student("zl",21,"xian");
        Person p1 = new Person("fd",21);
        Person p2 = new Person("fd",21);
        Student s1 = new Student("whb",22,"xian");
        Student s2 = new Student("whb",22,"xian");
        Student s3 = new Student("whb",22,"shanghai");
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(p.name);
        //System.out.println(p.school);error 父类只可以使用自己的成员变量，不可以使用子类新增加的成员变量
        Student s = (Student) p;
        System.out.println(s.school);//xian
    }
}
class Person{

    String name;
    int age;
    Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public boolean equals(Object obj){
        if(obj != null){
            if(obj instanceof Person){
                Person p = (Person) obj;
                if (p.name ==this.name && p.age ==this.age){
                    return  true;
                }
            }
        }
        return false;
    }
}
class Student extends Person{

    String school;
    Student(String name,int age,String school){
        super(name,age);
        this.school = school;
    }
    public boolean equals(Object obj){
        if(obj != null){
            if(obj instanceof Person){
                Student p = (Student) obj;
                if (p.name ==this.name && p.age ==this.age && p.school == this.school){
                    return  true;
                }
            }
        }
        return false;
    }
}
