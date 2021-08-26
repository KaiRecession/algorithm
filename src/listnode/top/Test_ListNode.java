package listnode.top;

public class Test_ListNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

//        ListNode.readNode(node1);
//        ListNode.readNode(node1.reverse(node1));
 //       ListNode.readNode(node1.reversePart(node1,node4));
//        ListNode.readNode(node1.reverseK(node1,2));
 //       ListNode.readNode(node1.reverseGroup(node1, 2));
    }
}
