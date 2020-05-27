package ReflectionPractice.Instantiation;

import ReflectionPractice.ReflectionCodes.Student;

public class InstanByNew {
    public static void main(String[] args) {
        Student s = new Student("tom");
        s.setAge(20);
        System.out.println(s);
        Student s1 = new Student();
        System.out.println(s1);
    }
}
