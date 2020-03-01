public class ListNode {

    private int val;
    private ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void addNode(int val) {
        ListNode newNode = new ListNode(val);
        ListNode temp = this;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    @Override
    public String toString() {
        return val +
                "    ";
    }

    public void print() {
        ListNode temp = this;
        while (temp != null) {
            System.out.print(temp);
            temp = temp.next;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode myHead = new ListNode(0);
        ListNode cur = head;
        ListNode prep = myHead;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            while (prep.next != null && prep.next.val < cur.val) {
                prep = prep.next;
            }
            cur.next = prep.next;
            prep.next = cur;
            prep = myHead;
            cur = next;
        }
        return myHead.next;

    }

    public static void main(String[] args) {
        ListNode linkedlist = new ListNode(5);
        linkedlist.addNode(9);
        linkedlist.addNode(80);
        linkedlist.addNode(50);
        linkedlist.addNode(7);
        System.out.println("未排序前的链表：");
        linkedlist.print();
        System.out.println();
        System.out.println("排序后的链表：");
        insertionSortList(linkedlist).print();


    }
}
