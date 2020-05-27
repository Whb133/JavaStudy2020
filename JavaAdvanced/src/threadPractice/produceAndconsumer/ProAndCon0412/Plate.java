package threadPractice.produceAndconsumer.ProAndCon0412;

public class Plate{

    Countable[] products;
    static int index = 0;
    Plate(Countable[] products){
        this.products = products;
    }
    //往盘子中放东西
    public synchronized void push(Countable product){
        while (index > products.length){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        products[index] = product;
        index++;
    }
    //从盘子中取出东西
    public synchronized Countable pop(){
        while (index == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        index--;
        return products[index];

    }
}
