package ReflectionPractice.ReflectionCodes.RuntimeClass.Get;

import ReflectionPractice.ReflectionCodes.Util.Employee;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {

    //获取属性结构
    public static void main(String[] args) {
        Class c = Employee.class;
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = c.getFields();
        for (Field f : fields){
            System.out.println(f);
        }

        System.out.println("*********************");
        //getDeclaredFields():获取当前运行时类中声明的所有属性。(不包含父类中声明的属性)
        Field[] dFields = c.getDeclaredFields();
        for (Field dField : dFields) {
            System.out.println(dField);
            //权限修饰符
            System.out.println("权限修饰符"+dField.getModifiers()+" " + Modifier.toString(dField.getModifiers()));
            //数据类型
            System.out.println("数据类型"+dField.getType().getName());
            //变量名
            System.out.println("变量名"+dField.getName());
        }
    }
}
