package Java11.Codes;

public class StringPTest {
    public static void main(String[] args) {
        //判断字符串是否为空白
        System.out.println("    ".isBlank());
        //去除首尾空白
        System.out.println("    ___Javastack___   ".strip());//___Javastack___
        //去除尾部空格
        System.out.println("    ___Javastack___   ".stripTrailing());//    ___Javastack___
        //去除首部空格
        System.out.println("    ___Javastack___    ".stripLeading());//___Javastack___
        //复制字符串
        System.out.println("Java".repeat(3));//JavaJavaJava
        //行数统计
        System.out.println("A\nB\nC".lines().count());//3
    }
    public void test1(int a){
        System.out.println(a);
    }
}
