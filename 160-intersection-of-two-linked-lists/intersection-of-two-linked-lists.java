/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 //Approach One
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         HashMap<ListNode, Integer> map = new HashMap<>();
//         ListNode temp = headA;
//         while(temp!=null){
//             map.put(temp, 1);
//             temp = temp.next;
//         }
//         temp = headB;
//         while(temp!=null){
//             if(map.containsKey(temp))
//                 return temp;
//             temp = temp.next;
//         }
//         return null;
//     }
// }

//Approach Two
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int len1 = 0;
        int len2 = 0;
        while(temp1!=null){
            len1++;
            temp1 = temp1.next;
        }
        while(temp2!=null){
            len2++;
            temp2 = temp2.next;
        }
        if(len1<len2){
            int diff = len2-len1;
            return spotLink(headA, headB, diff);
        } else{
            int diff = len1-len2;
            return spotLink(headB, headA, diff);
        } 
    }
    
    public ListNode spotLink(ListNode temp1, ListNode temp2, int diff){
        while(diff!=0){
            diff--;
            temp2 = temp2.next;
        }

        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp2;
    } 
}