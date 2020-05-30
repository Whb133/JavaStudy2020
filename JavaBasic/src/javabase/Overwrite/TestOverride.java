package javabase.Overwrite;

import java.io.IOException;
import java.io.InterruptedIOException;

public class TestOverride {
    public void eat(){
        System.out.println("eat");
    }
    public void sleep() throws IOException {
        System.out.println("sleep");
        throw new IOException();
    }
    int study(){
        return 10;
    }
    void run(){

    }
    private void exer(){

    }
}
class To extends TestOverride{

    @Override
    public void eat(){
        System.out.println("to eat");
    }
    @Override
    public void sleep() throws InterruptedIOException {
        System.out.println("to sleep");
        throw new InterruptedIOException();
    }
    @Override
    int study(){
        return 10;
    }
    @Override
    public void run(){

    }
    public void exer(){

    }

    public static void main(String[] args){
        TestOverride t = new To();
        TestOverride t1 = new TestOverride();
        t.eat();
        try{
            t.sleep();
        }catch (InterruptedIOException intere){
            intere.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            t1.sleep();
        }catch (InterruptedIOException intere){
            intere.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
