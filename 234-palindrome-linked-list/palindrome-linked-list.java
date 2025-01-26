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
        
        // Stack<Integer> check = new Stack<>();
        // ListNode temp = head;
        // while (temp != null) {
        //     check.push(temp.val);
        //     temp = temp.next;
        // }
        // temp = head;
        // while(temp!=null)
        // {
        // if(!check.isEmpty() && check.peek() == temp.val)
        //     check.pop();
        // else return false;
        // temp = temp.next;
        // }
        // return check.isEmpty();
        int [] arr = new int[100000];
        int len = 0;
        ListNode temp = head;
        while(temp!=null)
        {
            arr[len++] = temp.val;
            temp = temp.next;
        }
        int mid = len/2;
        for(int i=0; i<mid; i++)
        {
            if(arr[i]!=arr[--len])
                return false;
        }
        return true;
    }
}
