class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head; 
        if (n == 1 && head.next == null) return null; 

        int counter = 0;
        int sum = 0;
        ListNode temp, prev, len;
        temp = head;
        len = head;
        prev = null;

        while (len != null) {
            sum++;
            len = len.next;
        }

        // If removing the head (special case when `n == sum`)
        if (sum == n) return head.next;

        while (temp != null) {
            counter++;
            if (sum - counter + 1 == n) {
                if (temp.next == null) { // If the node to remove is the last node
                    prev.next = null; // Update the previous node's next to null
                } else { 
                    prev.next = temp.next;
                }
                break;
            }
            prev = temp;
            temp = temp.next;
        }

        return head; 
    }
}
