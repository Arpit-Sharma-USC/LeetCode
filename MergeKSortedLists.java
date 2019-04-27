/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists== null || lists.length==0)
            return null;
        
        return DnQ(lists, 0, lists.length - 1);
        
        
    }
    
    private ListNode DnQ(ListNode[] lists, int start , int end)
    {
        if (start == end)  
            return lists[start];
        if(start+1==end)
            return merge_2(lists[start],lists[end]);
        
        int mid = start+(end-start)/2;
        ListNode l1 = DnQ(lists,start,mid);
        ListNode l2 = DnQ(lists,mid+1,end);
        
        return merge_2(l1,l2);
    }
    
    private ListNode merge_2(ListNode l1, ListNode l2)
    {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        
        ListNode head,curr;
        head=curr=null;
        
        while(l1!=null && l2!= null)
        {
            ListNode small = null;
            if(l1.val<=l2.val)
            {
                small = l1;
                l1=l1.next;
            }
            else 
            {
                small = l2;
                l2=l2.next;
            }
            
            if(head==null){
                head=small;
                curr=small;
            }
            else
            {
                curr.next = small;
                curr=small;
            }
        }
        
        if(l1!=null)
            curr.next=l1;
        if(l2!=null)
            curr.next=l2;
        
        
        return head;
    }
}
