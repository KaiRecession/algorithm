/**
 * 递归中的保持不赋值的变量主要看递归体中传递的变量
 * 递归体上边会立即赋值，正向循环，递归体下面是先不赋值，反相循环（它会占用着空间，一直存在）
 */

package nodereverse;

public class ListNodeReverse {

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

//        nodereverse.ListNodeReverse.readNode(node1);
//        nodereverse.ListNodeReverse.readNode(node1.reverse(node1));
//        nodereverse.ListNodeReverse.readNode(node1.reverse(node1,3));
//        nodereverse.ListNodeReverse.readNode(node1.reverse(node1,3,6));



    }

    public static void readNode(ListNode listNode) {
        while (listNode.next != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }

        System.out.print(listNode.val);
        System.out.println("");
    }
}


//单链表节点结构
class ListNode {  //即代表了对象，也代表了自身的地址
    int val; //节点的内容
    ListNode next; //节点的指针
    ListNode(int x) { val = x; } //节点的赋值方法

    // 递归就像一个反相循环体，基线条件是停止条件，递归的参数传递就像是控制while循环的i，每次都减一下，递归条件就像是while
    ListNode reverse(ListNode head) {
        if (head.next ==null) return head;  //基线条件
        ListNode last = reverse(head.next);  //递归条件（else），注意这句话的位置，递归条件复合的时候不能去执行递归体！
        //新栈不断地压入，当前栈暂停，满足基线条件后，继续执行下面的语句，所以说last就没变过
        //递归就像一个可以暂停的不断扩张的表达式!!!
        head.next.next = head;  //关注递归的主体，这句话让下一个节点的指针指向上一个节点，牛蛙
        head.next = null; //这句话等于是切断了上一个指针与本指针的指向
        return last;  //返回值是基线条件的返回值，在递归过程就没变过
    }

    ListNode successor = null;
    ListNode reverse(ListNode head, int m) {
        
        if (m == 1) {
           successor = head.next;
           return head;   //抓两头，确定最后一个变成头返回，第一个指针最终指向末尾！
        }

        ListNode last = reverse(head.next, m-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    ListNode reverse(ListNode head, int m, int n) {
        if (m == 1) {
            return reverse(head,n);
        }
        // 递归体就代表了下一次循环的内容，所以return head
        // 巧用return，否则还要if else啥的，很不简洁
        // 得到下一次循环的返回结果，传递进去循环中每次会变化的变量，确保循环进行下去
        head.next = reverse(head.next,m-1,n-1);
        // 递归条件下的都是循环体
        return head; //每次return都是当前的循环体的head
    }
}
