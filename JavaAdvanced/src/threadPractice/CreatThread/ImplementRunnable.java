package threadPractice.CreatThread;

public class ImplementRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread");
    }

    public static void main(String[] args) {
        new Thread(new ImplementRunnable()).start();
    }
}
