package ReflectionPractice.CinitAndInit.CInit;

public class CinitExce {
    /*在static语句块中使用到静态变量时一定要将该静态变量的声明语句放在static语句块的前面,
    否则会发生illegal forward references的编译错误
    */
    static CinitExce test = new CinitExce();

    // 静态语句块
    static {
        System.out.println("static statements block");
        // 注意 test 与 s 的声明位置
        System.out.println(test); // 调用类变量test, 未出现编译错误
//        System.out.println(s);    // 调用类变量s, 出现编译错误illegal forward reference
    }

    static String s = "string";
}
