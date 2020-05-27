package Java11.Codes;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class typeInfer {
    public static void main(String[] args) {
        //基本形式
        Consumer<String> con = (s)-> System.out.println(s);
        //变量需要加上注解的错误形式，必须要有类型，可以加 var
//        Consumer<String> con1 = (@Deprecated s)-> System.out.println(s);
        //变量需要加上注解的正确形式,使用var的好处是在使用Lambda表达式时给参数加上注解。
        Consumer<String> con2 = (@Deprecated var s)-> System.out.println(s);
    }
}
