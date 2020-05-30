package javabase.javaReference;

import java.io.PrintStream;

public class Num {

    public static void main(String[] args){
        int a = 10;
        int b = 10;
        method2(a,b);
        System.out.println("a="+a);
        System.out.println("b="+b);
    }

    static void method(int a,int b){
        System.out.println("a="+(a*10));
        System.out.println("b="+(b*20));
        System.exit(0);
    }

    static void method2(int a,int b){
        PrintStream ps =new PrintStream(System.out){
            @Override
            public void println(String str) {
                if ("a=10".equals(str)){
                    print("a=100");
                    println();
                }else if ("b=10".equals(str)){
                    print("b=200");
                    println();
                }
            }
        };
        System.setOut(ps);
    }
}
