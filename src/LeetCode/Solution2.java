package LeetCode;

import entity.ListNode;

public class Solution2 {
    public static void main(String[] args) {
        int left = 0, right = 1, temp, sum = 0;
        for(int i = 1; i <= 100; i++){
            temp = left;
            left = right;
            sum += left;
            right = temp + right;
        }
        System.out.println(sum);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        return  null;
    }
}
