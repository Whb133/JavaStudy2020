package Java9.Codes;

public interface MyInterface {
    //如下的三个方法的权限修饰符都是public
    public void testNormal();
    public static void testStatic(){
        System.out.println("我是接口中的静态方法");

    }
    public default void testDefault(){
        System.out.println("我是接口中的默认方法");
        testPrivate();
    }
    //jdk 9中允许接口中定义私有的方法
    private void testPrivate(){
        System.out.println("我是接口中的私有方法");
    }
}
