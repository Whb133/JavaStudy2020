package ReflectionPractice.CinitAndInit.CInit;

public class clinitTest {
    /*
    //在类加载到连接完成阶段，ClassInit类在内存中的状态为：init=null,x=0,y=0
    //如果同时包含多个静态变量和静态代码块，则按照自上而下的顺序依次执行
    //初始化阶段时，需要执行clinit方法，该方法类似如下伪代码：
    clinit(){
	    //init=new ClassInit();调用构造方法
        x++;//x=1 因为此时x的值为连接的准备阶段赋的默认值0，然后++变成1
        y++;//y=1 因为此时y的值为连接的准备阶段赋的默认值0，然后++变成1
            //x=0;//为什么这里没有执行x=0，因为程序没有给x赋初值，因此在初始化阶段时，不会执行赋初值操作
        y=0;//因为类变量y在定义时，指定了初值，尽管初值为0，因此在初始化阶段的时候，需要执行赋初值操作
        x=10;//第一个静态块的赋值操作，结果为x=10;
        y=10;//第一个静态块的赋值操作，结果为y=10;
    }
    //所以最终结果为x=10,y=10，如果不执行静态代码块，程序结果是x=1,y=0


    //如果private static ClassInit init=new ClassInit(); 此段代码在public static int y=0;后面，
    那么clinit方法的伪代码如下：
    clinit(){
        //x=0;//这里虽然没有执行，但此时x的值为连接的准备阶段赋的默认值0
        y=0;//因为类变量y在定义时，指定了初值，尽管初值为0，因此在初始化阶段的时候，需要执行赋初值操作
	    //init=new ClassInit();调用构造方法
        x++;//x=1 因为此时x的值为连接的准备阶段赋的默认值0，然后++变成1
        y++;//y=1 因为此时y的值为初始化阶段赋的初值，只是这个初值刚好等于默认值0而已，然后++变成1
        x=10;//第一个静态块的赋值操作，结果为x=10;
        y=10;//第一个静态块的赋值操作，结果为y=10;
    }
    //所以最终结果为x=10,y=10，如果不执行静态代码块，程序结果是x=1,y=1
*/
    public static void main(String[] args) {
        ClassCInit init=ClassCInit.newInstance();

        System.out.println(init.x);
        System.out.println(init.y);
    }
}

class ClassCInit{
    //饿汉单例模式
    private static ClassCInit init=new ClassCInit();
    public static int x;
    public static int y=0;
//    private static ClassInit init=new ClassInit();
    static{
        x=10;
        y=10;
    }
    private ClassCInit(){
        x++;
        y++;
    }
    public static ClassCInit newInstance(){
        return init;
    }
}