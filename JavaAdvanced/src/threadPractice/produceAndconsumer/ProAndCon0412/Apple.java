package threadPractice.produceAndconsumer.ProAndCon0412;

public class Apple implements Countable{
    int id ;
    public Apple(int id){
        this.id = id;
    }

    @Override
    public int getId(){
        return id;
    }
}
