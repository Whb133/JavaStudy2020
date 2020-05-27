package Java9.Codes;

public class MyImpl implements MyInterface {

    @Override
    public void testNormal() {
        System.out.println("我是实现类的testNormal");
    }

    public static void main(String[] args) {
        MyImpl my = new MyImpl();
        my.testNormal();
        my.testDefault();
        //不能调用接口中私有方法
        // my.tsetPrivate();
    }
}
