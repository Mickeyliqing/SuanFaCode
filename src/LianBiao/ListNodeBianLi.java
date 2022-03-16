package LianBiao;

/**
 * 链表遍历的方式
 */
public class ListNodeBianLi {

    /**
     * 迭代访问一个单链表
     * @param head
     */
    void iteration(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {

        }
    }

    /**
     * 递归访问一个单链表
     * @param head
     */
    void traverses(ListNode head) {
        traverses(head.next);
    }

    /**
     * 递归实现单链表的反转
     * @param head
     * @return
     */
    ListNode traverse(ListNode head) {
        if(head.next == null) {
            return head;
        }
        //递归开始
        ListNode last = traverse(head.next);
        //你就默认递归已经结束，那么下面就是接下来要执行的操作
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 递归反转链表的 n 个节点
     */
    ListNode nodeNext = null;
    ListNode traverse(ListNode head, int n) {
        if(n == 1) {
            //这一步非常的巧，但节点数为 1 的时候，记录当前节点的下一个节点 nodeNext
            nodeNext = head.next;
            return head;
        }
        //以 head.next 为起点，需要反转 n-1 个节点
        ListNode last = traverse(head.next, n-1);
        //递归完成后需要执行的操作
        head.next.next = head;
        //反转之后 head 节点和后面的节点连接起来
        //假设链表结构是：1->2->3->4。反转 1,2,3 后。1 和 4 要相连。而 nodeNext 记录的就是4 的位置。
        head.next = nodeNext;
        return last;
    }

    /**
     * 递归反转链表在区间 [m.n] 这段内的元素
     * @param head
     * @param m
     * @param n
     * @return
     */
    ListNode traverse(ListNode head, int m, int n) {
        //当 m = 1 的时候，其实就相当于反转链表的 n 个节点
        if(m == 1) {
            traverse(head,n);
        }
        //以 head.next 为起点，需要反转 的区间就是 m-1 和 n-1 个节点
        head.next = traverse(head.next, m -1, n-1);
        return head;
    }
}
