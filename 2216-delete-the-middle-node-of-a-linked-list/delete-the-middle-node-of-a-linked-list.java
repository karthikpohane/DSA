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
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while(temp!=null)
        {
            len++;
            temp = temp.next;
        }
        if(len==2){
            head.next=null;
            return head;
        }
        if(len==1) return null;
        int mid = len/2;
        int count = 0;
        temp = head;
        while(temp!=null){
            count++;
            if(count==mid)
                temp.next = temp.next.next;
            temp = temp.next;
        }
        return head;
    }
}