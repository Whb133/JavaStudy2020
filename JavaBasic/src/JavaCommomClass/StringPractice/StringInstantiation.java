package JavaCommomClass.StringPractice;

/*
    String 实例化的两种方法：
    字面量直接赋值
    new + 构造器
* */
public class StringInstantiation {
    public static void main(String[] args) {

        //通过字面量声明的方式：此时s1和s2的数据java在方法区的字符串常量池中。
        String s1 = "java";
        String s2 = "java";

        //通过new + 构造器的方式：此时的s3和s4保存的是地址值，此地址值指向的是堆内存中对应对象的地址。
        //通过new方式创建对象，事实上在内存中创建了两个对象，一个是堆内存中的new结构，一个是char[]对应的字符串常量池中的数据“”java
        String s3 = new String("java");
        String s4 = new String("java");

        //获取某字符串在常量池中的字符串常量，如果原来池中已经存在，直接返回池中该字符串的引用，
        // 如果原来（String Pool）池中没有，将此对象添加到池中，并返回池中此对象的引用。
        String s5 = s4.intern();

        //String使用构造器创建新对象时，首先在堆内存中开辟空间存放String对象，
        // 而String对象具体存放的value依然需要引用方法区中字符串常量池中的内容。
        StringInstantiation stringInstantiation = new StringInstantiation();
        Peole p1 = stringInstantiation.new Peole("tom");
        Peole p2 = stringInstantiation.new Peole("tom");

        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s3 == s4);//false
        System.out.println(s1 == s5);//true
        System.out.println(s4 == s5);//false
        System.out.println(p1.name == p2.name);//true
    }
    class Peole{
        String name;
        Peole(String name){
            this.name = name;
        }
    }

}
