/**
 * 循环实现反转部分链表，递归实现K组反转
 * 递归一定要想好，我要怎么准备好本次循环的，怎么接收下次的循环，
 * 递归语句下面的当成不赋值的变量，反相循环考虑
 * 不要陷进递归，考虑一次循环体，关注循环体
 */

package listnode.top;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    ListNode reverse(ListNode head) {
//        ListNode pre = null;
//        ListNode cur = head;
//        ListNode nxt = head;
        ListNode pre,cur,nxt;
        //赋值放在同一句
        pre = null; nxt = head; cur = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    ListNode reversePart(ListNode head, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null; cur = head; nxt = head;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        return pre;
    }

//    ListNode reverseK(ListNode head, int k) {
//       if (head == null) {
//           return null;
//       }
//
//       ListNode a, b;
//       for (int i = 0; i<k; i++) {
//           if (b == null) return head;
//       }
//    }

    // 递归就像是一个计算图模型，看流程
    ListNode reverseGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode start, end;
        start = end = head;
        for (int i = 0; i < k; i++) {
            end = end.next;
            // 只要不动对象里面的内容就行
            if (end == null) {
                return start;
            }

        }

        ListNode newListNode = reversePart(start, end);
        // start已经跑到末尾
        // 从递归语句开始到下一次递归语句就是下次循环要准备的条件，递归语句上面的就是本次要准备的条件
        // 下面的语句不会被立即计算，会被搁置，最后倒着循环算，上面的语句是已经处理好的，正着算的
        start.next = reverseGroup(end, k);
        return newListNode;
    }

    static void readNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println("");
    }

}
