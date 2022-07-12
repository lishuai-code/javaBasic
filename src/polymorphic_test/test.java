package polymorphic_test;

import entity.ListNode;
import entity.child;

public class test {
    public static void main(String[] args) {
/*        //多态：
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new child();
        child child = new child();
        child = (child) listNode1;*/


        ListNode list1 = new ListNode(2,new ListNode(5,new ListNode(8,new ListNode(76))));
        ListNode list2 = new ListNode(1,new ListNode(4,new ListNode(9)));


        list1.next =list2; //执行这行代码：由于list1.next引用了list2，所以当list2的值改变时：

        //这个代码改变了list2所引用的对象地址，
        //但是list1.next所引用的是原来的list2所引用的对象（new ListNode(1,new ListNode(4,new ListNode(9)))）的地址
        //所以这个操作并不会改变list1的内容
        //list2 = list2.next;

        //这个代码改变了list2.next所引用的对象地址，所以list2的值改变，但是list所引用的对象地址没有改变
        //而list1.next所引用的是list2所引用的对象（new ListNode(1,new ListNode(999))）的地址
        //所以这个操作会改变list1的内容
        list2.next = new ListNode(999);

        System.out.println(list1);
        System.out.println(list2);





    }
}
