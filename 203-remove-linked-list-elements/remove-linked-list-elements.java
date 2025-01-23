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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        // if(head.val==val)
        // {
        //     head = head.next;
        //     return head;
        // }
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode temp, prev;
        temp = head;
        prev = null;
        while(temp!=null){
            if(temp.val == val){
                prev.next = temp.next;
                
            }else
                prev = temp;
            temp = temp.next;
        }
        return head;
    }
}