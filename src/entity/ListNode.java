package entity;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {

    }
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "val = " + val +",entity.ListNode = {" + next + "}";
    }

//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
}
