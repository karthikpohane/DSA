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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        
        Stack<Integer> check = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            check.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp!=null)
        {
        if(!check.isEmpty() && check.peek() == temp.val)
            check.pop();
        else return false;
        temp = temp.next;
        }
        return check.isEmpty();
    }
}
