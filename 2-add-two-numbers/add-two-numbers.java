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
        ListNode list1temp = l1;
        ListNode list2temp = l2;
        ListNode dummy = new ListNode(-1);
        ListNode curent  = dummy;
        int carry=0;
        while(list1temp !=null || list2temp!=null)
        {
            int sum = carry;
            if(list1temp!=null)
                sum += list1temp.val;
            if(list2temp!=null)
                sum += list2temp.val;
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            curent.next = newNode;
            curent = curent.next;

            if(list1temp!=null) list1temp = list1temp.next;
            if(list2temp!=null) list2temp = list2temp.next;
        }
        if(carry!=0){
            ListNode newNode = new ListNode(carry);
            curent.next = newNode;
        }
        return dummy.next;
    }
}