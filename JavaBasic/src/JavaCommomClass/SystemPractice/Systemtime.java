package JavaCommomClass.SystemPractice;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Systemtime {
    /*
    System
    该类构造器时private的，所以外部无法实例化，其成员变量和方法都是static的。
    System包含标准三个属性：in\out\err
    分别代表标准输入流，标准输出流和标准错误输出流。
    * */
    public static void main(String[] args) {

        //时间戳
        long time = System.currentTimeMillis();
        System.out.println(time);



        /*获取系统中属性名为key的属性对应的值。系统中常见的属性名以及属性的作用：
            System.getProperty("java.home")
            java.version          java运行时环境版本
            java.home             java运安装目录
            os.name               操作系统名称
            os.version            操作系统版本
            user.name             用户账户名称
            user.home             用户主目录
            user.dir              用户当前工作目录
         */
        System.out.println(System.getProperty("java.home"));


        //请求系统进行垃圾回收。至于系统是否会立即回收，取决于系统中垃圾回收算法的实现和系统执行时的情况。
        System.gc();

        //退出程序 0 正常推出，非0 异常退出，使用该方法可以图形化界面实现退出功能。
        System.exit(0);

    }
}
