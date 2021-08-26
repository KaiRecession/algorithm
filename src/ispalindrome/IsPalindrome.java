/**
 * 判断链表是不是回文链表
 * 递归体上面的语句正向循环，但是响应的变量还会在反相循环的时候存在
 * 最后要返回的变量，这个变量即使最后被返回的对象，也是每一次接收并开启递归的变量，这很重要，并且每次还能对他改造赋值！！
 * 快慢指针解决，快慢指针可以很好的解决空间复杂度大的问题，你要是直接把整个链表反相就需要空间，这就和上一个方法的空间复杂度一样了
 */
package ispalindrome;

public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;
        boolean res = isPalindrome.isPalindrome(node1);
        System.out.println(res);
    }

    ListNode left;

//    boolean isPalindrome(ListNode head) {
//        left = head;
//        return traverse(head);
//    }

    boolean isPalindrome(ListNode head) {
        ListNode fast, slow;
        fast = head; slow = head;
        // 奇数个和偶数个两种情况都要考虑
        // 循环出来后，就是要么fast.next == null，要么就是fast == null
        while (fast !=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 假如链表是奇数个
        if (fast != null) {
            slow = slow.next;
        }
        System.out.println(slow.val);
        ListNode pre, cur, nxt;
        pre = null; cur = slow; nxt = slow;
        // 必须是cur，否则最后一个节点的箭头没有反相
        while (cur != null) {
            nxt = cur.next;
            // 但凡你动了next，那么链表的结构就已经开始改变了
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        System.out.println(pre.val);
        // 注意要的是pre！！！
        while (pre != null) {
            if (head.val == pre.val) {
                head = head.next;
                pre = pre.next;
            }else {
                return false;
            }
        }
        return true;
    }

    // 空间复杂度较高
    boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        // res和那个head.next = 递归（head.next）有异曲同工之妙
        boolean res = traverse(right.next);
        // if return语句也能用，但是没有这个优雅
        res = res && (left.val == right.val);
        left = left.next;
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
}