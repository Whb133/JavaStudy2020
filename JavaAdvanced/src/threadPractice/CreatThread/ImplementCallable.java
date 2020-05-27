package threadPractice.CreatThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/*
创建线程方式三：实现Callable接口
Callable接口  call（）方法可以有返回值，且返回值类型为泛型，也可以抛异常
但使用Callable接口必须使用FutureTask类
FutureTask是Future类唯一实现类，
FutureTask同时实现了Runnable、Future接口。
FutureTask构造器参数为Callable类型。
FutureTask对象可以调用get()方法来获取Callable实现类call()方法的返回值。（会抛异常65）
* */
public class ImplementCallable implements Callable {

    @Override
    public Object call() throws Exception {
        boolean flag = true;
        return flag;
    }

    public static void main(String[] args) {
        ImplementCallable implementCallable = new ImplementCallable();
        FutureTask futureTask = new FutureTask(implementCallable);
        new Thread(futureTask).start();
        try {
            boolean res = (boolean)futureTask.get();
            System.out.println(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
