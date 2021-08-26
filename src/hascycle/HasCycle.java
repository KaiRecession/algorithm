/** 快慢指针
 * 1、判断链表中是否有环
 * 2、找到环的起始位置
 * 3、删除倒数第N个节点
 */

package hascycle;

public class HasCycle {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = null;


        HasCycle hasCycle = new HasCycle();
//        System.out.println(hasCycle.hasCycle(node1));
//        System.out.println(hasCycle.detectCycle(node1).val);
        hasCycle.readListNode(hasCycle.removeNthFromEnd(node1,4));
    }



    boolean hasCycle(ListNode head) {
        ListNode fast, slow;
        fast = head; slow = head;
        // 快指针一定是要先判断fast，在判断fast.next是不是空，否则就很有可能fast.next,或者fast.next.next抛出空指针异常
        while (fast != null && fast.next != null) {
            // fast.next.next需要fast.next不为空保证，而fast.next又需要fast不为空保证！！！
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }

        }
        return false;
    }

    ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = head; slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        // 必然有且只有一个解
        return slow;
    }

    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast, slow;
        fast = head; slow = head;
        while (n>0) {
            fast = fast.next;
            n--;
        }
        // 删除一个节点，就是要确定到这个节点的上一个节点才行
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    void readListNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
}
