package threadPractice.ThreadSynchronized;

class DeadLock implements Runnable{

    public int flag = 1;
    static Object o1 = new Object();
    static Object o2 = new Object();
    @Override
    public void run() {
        if (flag ==1){
            synchronized (o1){
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("flag= 1 && o1");
                synchronized (o2){
                    System.out.println("flag= 1 && o2");
                }
            }
        }
        if(flag == 2){
            synchronized (o2){
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("flag= 2 && o2");
                synchronized (o1){
                    System.out.println("flag= 2 && o1");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock d1 = new DeadLock();
        DeadLock d2 = new DeadLock();
        d1.flag = 1;
        d2.flag = 2;
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        t1.start();
        t2.start();
    }
}
