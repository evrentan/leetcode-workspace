public class ReverseLinkedList {
    public static void main(String[] args) {

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.executeExample1();
        reverseLinkedList.executeExample1Recursive();
        reverseLinkedList.executeExample2();
        reverseLinkedList.executeExample2Recursive();
        reverseLinkedList.executeExample3();
        reverseLinkedList.executeExample3Recursive();
    }

    private void executeExample1() {
        System.out.println("****************** Example 1*****************");
        ListNode headExample1 = new ListNode(1);
        headExample1.next = new ListNode(2);
        headExample1.next.next = new ListNode(3);
        headExample1.next.next.next = new ListNode(4);
        headExample1.next.next.next.next = new ListNode(5);

        this.printList(headExample1, false);

        ListNode reversedLinkedListExample1 = this.reverseList(headExample1);
        this.printList(reversedLinkedListExample1, true);
    }

    private void executeExample1Recursive() {
        System.out.println("****************** Example 1 - Recursive *****************");
        ListNode headExample1 = new ListNode(1);
        headExample1.next = new ListNode(2);
        headExample1.next.next = new ListNode(3);
        headExample1.next.next.next = new ListNode(4);
        headExample1.next.next.next.next = new ListNode(5);

        this.printList(headExample1, false);

        ListNode reversedLinkedListExample1Recursive = this.reverseListRecursive(headExample1);
        this.printList(reversedLinkedListExample1Recursive, true);
    }

    private void executeExample2() {
        System.out.println("****************** Example 2*****************");
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        this.printList(head2, false);

        ListNode reversedLinkedListExample2 = this.reverseList(head2);
        this.printList(reversedLinkedListExample2, true);
    }

    private void executeExample2Recursive() {
        System.out.println("****************** Example 2*****************");
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        this.printList(head2, false);

        ListNode reversedLinkedListExample2Recursive = this.reverseListRecursive(head2);
        this.printList(reversedLinkedListExample2Recursive, true);
    }

    private void executeExample3() {
        System.out.println("****************** Example 3*****************");
        ListNode head3 = null;

        this.printList(head3, false);

        ListNode reversedLinkedListExample3 = this.reverseList(head3);
        this.printList(reversedLinkedListExample3, true);
    }

    private void executeExample3Recursive() {
        System.out.println("****************** Example 3*****************");
        ListNode head3 = null;

        this.printList(head3, false);

        ListNode reversedLinkedListExample3Recursive = this.reverseListRecursive(head3);
        this.printList(reversedLinkedListExample3Recursive, true);
    }

    private ListNode reverseList(ListNode head) {
        ListNode reversed = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = reversed;
            reversed = current;
            current = nextNode;
        }

        return reversed;
    }

    private ListNode reverseListRecursive(ListNode head) {

        if (head == null || head.next == null)
            return head;


        ListNode reversedList = reverseListRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return  reversedList;
    }

    private void printList(ListNode head, boolean reversed) {
        ListNode current = head;

        System.out.print(reversed ? "Reversed Linked List: " : "Linked List: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}