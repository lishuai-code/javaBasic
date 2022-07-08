import java.lang.reflect.Array;
import java.util.*;

public class tt {

    public static void main(String[] args) {

        double listNode = new tt().findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println(listNode);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i :
                nums1) {
            numbers.add(i);
        }
        for (int j :
                nums2) {
            numbers.add(j);
        }
        numbers.sort((Integer a, Integer b) -> a - b);

        int middle = numbers.size() / 2;
        if(numbers.size() / 2 == 0){
            result =  ( numbers.get(middle - 1) + numbers.get(middle) ) / 2;
            System.out.println();
        }
        else {
            result =  numbers.get(middle);
        }
        return result;
    }

}
