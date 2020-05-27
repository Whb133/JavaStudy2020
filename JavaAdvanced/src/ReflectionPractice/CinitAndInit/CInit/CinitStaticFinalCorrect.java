package ReflectionPractice.CinitAndInit.CInit;

public class CinitStaticFinalCorrect {

    /*
    对比CinitStaticFinalCorrect和 CinitStaticFinalWrong 输出结果
    分析: correct代码中由于name被赋予字符串字面量"string_name", 故在name声明时其值就是"string_name";
        而wrong代码中由于使用new String方式为name赋值, 导致name在声明时未被初始化(默认为null),
         直到static语句块执行后才会被初始化为"string_name", 而static语句块执行期间调用类的构造方法, 构造方法中使用了name,
         注意此时name并未被赋值,因此testName为null.

    结论: 要保证静态常量在使用前被赋予值, 否则会出现意想不到的情况.
    */

    private static CinitStaticFinalCorrect test;

    static {
        test = new CinitStaticFinalCorrect();
    }

    private static final String name = "string_name";

    private String testName;

    private CinitStaticFinalCorrect() {
        testName = name;
    }

    public static void main(String[] args) {
        System.out.println(test.testName); // 输出结果为: string_name
    }
}
