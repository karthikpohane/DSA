/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode tail = head;
        int len = 1;
        while(tail.next!=null){
            tail = tail.next;
            len++;
        }
        k = k%len;
        if(k == 0) return head;
        tail.next = head;
        ListNode newLastNode = findLastNode(head, len-k);
        head = newLastNode.next;
        newLastNode.next = null;
        return head;
    }

    private ListNode findLastNode(ListNode head, int k){
        int count = 1;
        while(head != null){
            if(count == k) return head;
            count++;
            head = head.next;
        }
        return head;
    }
}