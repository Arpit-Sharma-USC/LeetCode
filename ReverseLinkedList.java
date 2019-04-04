/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
      
        if(head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode current = head;
        while(current!=null)
        {
            ListNode temp = current.next;
            current.next  = prev;
            
            //advance to next node in the list
            
            prev= current;
            current = temp;
        }
            
        return prev;
        
    }
    
   
}
