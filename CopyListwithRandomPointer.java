/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
public class Solution {
  public Node copyRandomList(Node head) {

      if(head == null)
            return null;
      Node ptr = head;
      while(ptr!=null)
      {
          Node newNode = new Node(ptr.val);
          newNode.next = ptr.next;
          ptr.next = newNode;
          
          ptr = ptr.next.next;
          
      }
        
      ptr = head;
      while(ptr!=null)
      {
          ptr.next.random= (ptr.random!=null)?ptr.random.next:null;
          ptr=ptr.next.next;
      }
      
      Node old_list = head;
      Node new_list = head.next;
      Node head_new = head.next;
      
      while(old_list!=null)
      {
          old_list.next= new_list.next;
          new_list.next= (new_list.next!=null)?new_list.next.next:null;
          
          old_list=old_list.next;
          new_list=new_list.next;
      }
      
      return head_new;
  }
}
