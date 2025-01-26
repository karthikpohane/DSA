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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = reverseList(l1);
        ListNode temp2 = reverseList(l2);
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        while(temp1!=null || temp2!=null || carry!=0)
        {
            int sum = carry;
            if(temp1!=null){
                sum += temp1.val;
                temp1 = temp1.next;
            }
            if(temp2!=null){
                sum += temp2.val;
                temp2 = temp2.next;
            }

            carry = sum/10;
            current.next = new ListNode(sum%10);
            current = current.next; 
        }
        return reverseList(dummy.next);
    }
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode nextHead = head.next;
            head.next = prev;
            prev = head;
            head = nextHead;
        }
        return prev;
    }
}