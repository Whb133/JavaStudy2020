package arrayPractice.yasef;


//数组模仿链表

public class ArrayImitationList {
    public static void main(String[] args) {
        int[] array = new int[500];
        for (int i =0;i<array.length;i++){
            array[i] = i+1;
        }
        array[array.length-1]=0;


        int index = 0;
        int countnum = 0;
        while(index != array[index]){
            countnum++;
            if (countnum == 7){
                array[index] = array[array[index]];
                countnum=0;
            }
            index=array[index];
        }






//        while (array[index] != index){
//
//            if(index == array.length-1){
//                if(array[index] == 0){
//
//                }
//            }else if(index+1==array[index]) {
//                countnum++;
//                if (countnum == 3) {
//                    countnum = 0;
//                    if(index==0){
//                        int length = array.length;
//                        while (array[length-1]==0){
//                            array[length-1]=array[0];
//                            length--;
//                        }
//                    }else {
//                        array[index - 1] = array[index];
//                    }
//                }
//            }
//            index = array[index];
////            if (index==array.length){
////                index=0;
////            }
//        }



        System.out.println(index);

        for (int i =0;i<array.length;i++){
            System.out.print(i+":"+array[i]+" ");
        }
    }
}
