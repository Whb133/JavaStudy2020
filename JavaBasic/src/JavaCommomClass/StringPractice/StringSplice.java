package JavaCommomClass.StringPractice;

public class StringSplice {
    public static void main(String[] args) {

        /*
        1.字符串拼接事实上依然调用StringBuilder（或StringBuffer）实现，然后通过toString()转换为字符串
        2..常量与常量的拼接结果在常量池中，且常量池中不会存在相同序列的常量。
            当"+"两端均为编译期确定的字符串常量时，编译器会进行相应的优化，直接将两个字符串常量拼接好
        3.只要其中一个是变量（引用），结果就在堆中。
        4.如果拼接的结果调用intern()方法，返回值就在常量池中。
        5.综上，“+”连接符对于直接相加的字符串常量效率很高，因为在编译期间便确定了它的值，
        即形如"I"+“love”+“java”; 的字符串相加，在编译期间便被优化成了"Ilovejava"。
        对于间接相加（即包含字符串引用，且编译期无法确定值的），
        即形如s1+s2+s3; 效率要比直接相加低，因为在编译器不会对引用变量进行优化。
        * */
        String s1 = "javalanguage";
        String s2 = "java";
        String s3 = "language";
        String s4 = "java"+"language";
        String s5 = s2+"language";
        String s6 = "java"+s3;
        String s7 = s2+s3;

        System.out.println(s1 == s4);//true
        System.out.println(s1 == s5);//false
        System.out.println(s1 == s6);//false
        System.out.println(s1 == s7);//false


        /**
         * 编译期确定
         * 对于final修饰的变量，它在编译时被解析为常量值的一个本地拷贝存储到自己的常量池中或嵌入到它的字节码流中。
         * 所以此时的"java" + s8和"java"+"language"效果是一样的。故结果为true。
         */
        /**
         * 编译期无法确定
         * 这里面虽然将s10用final修饰了，但是由于其赋值是通过方法调用返回的，那么它的值只能在运行期间确定
         * 因此s1和s11指向的不是同一个对象，故结果为false。
         */

        //String s1 = "javalanguage";
        final String s8 = "language";
        String s9 = "java" + s8;
        final String s10 = getS3();
        String s11 = "java" + s10;

        System.out.println(s1 == s9);//true
        System.out.println(s7 == s9);//false
        System.out.println(s1 == s11);//false
        System.out.println(s7 == s11);//false

    }

    public static String getS3() {
        return "language";
    }
}
