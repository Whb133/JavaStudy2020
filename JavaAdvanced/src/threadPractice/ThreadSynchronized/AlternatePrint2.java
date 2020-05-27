package threadPractice.ThreadSynchronized;

import java.util.Scanner;

public class AlternatePrint2 extends Thread {
    static int num = 0;
    static int count = 0;
    int id;
    AlternatePrint2(int id,String name){
        super(name);
        this.id = id;
    }

    @Override
    public void run() {
        synchronized (AlternatePrint2.class) {
            //类锁和对象锁
            while (true) {
                while (num % count != this.id) {
                    if (num > 100) {
                        break;
                    }
                    try {
                        AlternatePrint2.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (num > 100) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "  " + num);
                num++;
                AlternatePrint2.class.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入：");
        count = input.nextInt();
        for (int i = 0 ; i < count ; i++){
            new AlternatePrint2(i,"Thread-"+i).start();
        }
    }
}
