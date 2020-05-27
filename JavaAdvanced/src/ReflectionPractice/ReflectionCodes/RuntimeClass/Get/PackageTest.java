package ReflectionPractice.ReflectionCodes.RuntimeClass.Get;

import ReflectionPractice.ReflectionCodes.Util.Employee;

public class PackageTest {
    public static void main(String[] args) {
        Class c = Employee.class;
        //获取运行时类所在的包
        Package pack = c. getPackage( );
        System. out . println(pack);

    }
}
