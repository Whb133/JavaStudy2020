package Java10.Codes;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LocalVariableTypeInference {
    /*
    局部变量类型推断
    * */
    public static void main(String[] args) {
        var local = new LocalVariableTypeInference();
        local.testUse();
        local.testUnuse();

    }
    private void testUse(){
        //声明变量时，根据所附的值，推断变量的类型
        var num = 10;
        System.out.println(new Integer(num));
        var str = "string";
        //出现异常  java.lang.NumberFormatException: For input string: "string"
        //System.out.println(new Integer(str));
        var list = new ArrayList<Integer>();
        list.add(123);
        for (var integer : list) {
            System.out.println(integer);
            System.out.println(integer.getClass());
        }
    }
    private void testUnuse(){

        var str1 = "str";
        //因为jvm自动推断为String类型，才可以调用getClass()方法
        System.out.println(str1.getClass());
        var i = 10;
        //因为jvm自动推断为int类型，无法调用getClass()方法
        //System.out.println(i.getClass());


        //1.局部变量不赋值，无法实现类型推断
        //var v1;
        //2.局部变量不能赋值为null，null无法实现类型推断
        //var str = null;
        Supplier<Double> sup = () -> Math.random();
        //3. lambda表示式中,左边的函数式接口不能声明为var
        //var sup1 = () -> Math.random();
        //4.方法引用中，左边的函数式接口不能声明为var
        Consumer<String> con = System.out::println;
        //var con1 = System.out::println;
        //5.数组的静态初始化中，注意如下的情况也不可以
        int[] arr = {1,2,3,4};
        var arr1 = new int[]{1,2,3,4};
        //var arr2 = {1,2,3,4};
        /*
        6.其他情况
        情况1:没有初始化的局部变量声明
            var str = null;
        情况2:方法的返回类型
        情况3:方法的参数类型
        情况4:构造器的参数类型
        情况5:属性
        情况6: catch块
        try{
        }catch(var e){
            e.printStackTrace();
        }
        */


    }
    //情况2:方法的返回类型
//    public var testMethodRetuen(){
//        return 0;
//    }

    //情况3:方法的参数类型
//    public void testMethodPara(var num){
//    }
    //情况4:构造器的参数类型
//    LocalVariableTypeInference(var num){
//
//    }
    //情况5:属性(成员变量  可能有默认值)
    int num =10;
//    var str = "Str";
}
