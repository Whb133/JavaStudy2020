package arrayPractice.sort;

public class TestSort {
    public static void main(String[] args) {
        int[] a = new int[]{2,4,6,8,5,9,10};
        print(a);
        BubbleSort(a);
        print(a);
        SelectSort(a);
        print(a);
    }
    public static void BubbleSort(int[] a){
        for(int i =0;i<a.length;i++){
            for (int j = 0;j<a.length-1;j++){
                if(a[j]<a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] =temp;
                }
            }
        }
    }
    public static void SelectSort(int[] a){
        for (int i =0;i<a.length;i++){
            int max =i;
            for (int j =max+1;j<a.length;j++){
                if(a[max]<a[j]){
                    max = j;
                }
            }
            if(max != i){
                int temp = a[max];
                a[max] = a[i];
                a[i] = temp;
            }
        }
    }
    public static void QuickSort(int[] a) {

    }
    public static void print(int[] a){
        for (int i =0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
