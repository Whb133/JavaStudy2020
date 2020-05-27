package arrayPractice.yasef;

public class Number3Quit {
    public static void main(String[] args){

        boolean[] array = new boolean[500];
        for (int i =0;i<array.length;i++){
            array[i] = true;
        }
        int index = 0;
        int numbercount = 0;
        int leftnum = array.length;
        while (leftnum > 1){
            if(array[index]){
                numbercount++;
                if (numbercount == 3){
                    numbercount=0;
                    array[index] = false;
                    leftnum --;
                }

            }
            index ++;
            if(index == array.length){
                index = 0;
            }
        }
        for (int i =0;i<array.length;i++){
            if (array[i]){
                System.out.println(i);
            }
        }
    }
}
