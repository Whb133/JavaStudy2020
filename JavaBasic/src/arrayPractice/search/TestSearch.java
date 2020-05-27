package arrayPractice.search;
import arrayPractice.sort.TestSort;

public class TestSearch {
    public static void main(String[] args) {
        int [] array = new int[]{1,5,7,9,8,6,4,3};
        TestSort.SelectSort(array);
        int x= 1;
        int res = BinarySearch(array,x);
        if(res != -1) {
            System.out.println(x + "在数组中的索引是" +res);
        }else {
            System.out.println("查找失败,未找到该数字！"+x);
        }
    }
    public static int BinarySearch(int[] a,int x) {
        int length = a.length;
        int left = 0;
        int right = length - 1;
        int middle = (left + right) / 2;
        while (x != a[middle]) {
            if(left <= right) {
                if (x < a[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
                middle = (left + right) / 2;
            }else {
                return -1;
            }
        }
        return middle;
    }
}

