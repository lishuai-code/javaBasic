package LeetCode;

import entity.ListNode;
import java.util.*;

public class Solution2 {
    public static void main(String[] args) {

        boolean listNode = new Solution2().isValid("([}}])");
        System.out.println(listNode);
    }

    public boolean isValid(String s) {
        //1.如果括号数为奇数，当然就无法成对闭合：不满足条件一
        if (s.length() % 2 == 1) return false;

        //2.如果没有左括号，或者没有右括号，当然就无法成对闭合：不满足条件一
        if (!s.contains("(") && !s.contains("[") && !s.contains("}")) return false;
        if (!s.contains(")") && !s.contains("]") && !s.contains("}")) return false;

        LinkedList<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++){

            //3.将左括号全部添加到链表中，这里用栈的特性(后进先出)方法:
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                queue.push(s.charAt(i));
            }

            //4.如果字符为右括号，则判断链表中第一个是否是对应的左括号，由于queue.peek() == '(';右边是单引号基本数据类型，queue.peek()为null时不能直接和基本数据类型作比较，所以判断queue.peek()不为空
            else if (s.charAt(i) == ')' && queue.peek() != null && queue.peek() == '(') {
                queue.pop();
            }
            else if (s.charAt(i) == ']' && queue.peek() != null && queue.peek() == '[') {
                queue.pop();
            }
            else if (s.charAt(i) == '}' && queue.peek() != null && queue.peek() == '{')  {
                queue.pop();
            }
            else return false;
        }
        //由步骤1、2得到queue.size()不可能为0，只有当3、4执行时，左右括号按题目要求成对出现后，queue.size()才会为0
        return queue.size() == 0;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //return Method1(head, n);
        return Method2(head, n);
    }

    //删除链表倒数节点：回溯法：
    private ListNode Method1(ListNode head, int n){
        if(n <= 0) return head;
        int traverse = traverse(head, n);
        //当删除的节点是倒数最后一个时(即第一个),只需返回链表的下一个节点即可
        if (traverse == n) return head.next;
        return head;
    }

    //删除链表倒数节点：快慢指针法：
    private ListNode Method2(ListNode head, int n) {
        //由于当删除的节点是第一个节点时,(slow.next = null，slow.next.next 不存在),也就是会出现空指针异常
        //所以在链表前添加一个新的节点，最后返回时返回下一个节点即可
        ListNode listNode = new ListNode(0, head);
        ListNode fast = listNode;
        ListNode slow = listNode;
        for (int i = 0; i < n; i++){
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return listNode.next;
    }

    private int traverse(ListNode node, int n) {
        //定义递归结束：
        //最后一个节点的下一个节点(即空节点）定义倒数指针为0
        if(node == null) return 0;
        int traverse = traverse(node.next, n);
        traverse ++;
        //如果倒数指针为n的时候，说明需要删除这个节点(即：将后一个节点赋值给当前节点):这个方法无效
        //由于链表的删除要通过上一个节点指向需要删除的该节点的下一个节点，所以需要回溯到上一个节点之后执行删除
        if(n == traverse - 1) node.next = node.next.next;
        return traverse;
    }

    //斐波拉契数数列前100项的和
    public void fbla(){
        int left = 0, right = 1, temp, sum = 0;
        for(int i = 1; i <= 100; i++){
            temp = left;
            left = right;
            sum += left;
            right = temp + right;
        }
        System.out.println(sum);
    }
}
