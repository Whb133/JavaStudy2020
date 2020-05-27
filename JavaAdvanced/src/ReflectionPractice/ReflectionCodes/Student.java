package ReflectionPractice.ReflectionCodes;


import ReflectionPractice.ReflectionCodes.Util.People;

public class Student {

    public String name;
    private int age;

    public Student(){

    }
    public Student(String name) {
        this.name = name;
    }

    private Student(String name, int age) {
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

    public void showName(){
        System.out.println("MY name is "+name);
    }
    private void show(){
        System.out.println("MY name is "+name+" ,MY age is "+age);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
