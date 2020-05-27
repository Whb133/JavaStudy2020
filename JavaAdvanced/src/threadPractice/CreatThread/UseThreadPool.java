package threadPractice.CreatThread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class UseThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;
        threadPoolExecutor.setCorePoolSize(3);

        executorService.execute(new ImplementRunnable());
        executorService.submit(new ImplementCallable());

        executorService.shutdown();
    }
}
