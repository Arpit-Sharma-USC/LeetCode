// Java program to illustrate merge sorted 
// of linkedList 

public class linkedList 
{ 
	node head = null; 
	// node a,b; 
	static class node 
	{ 
		int val; 
		node next; 

		public node(int val) 
		{ 
			this.val = val; 
		} 
	} 
	


	// Utility function to get the middle of the linked list 
	

  
  node getMiddle(node head)
  {
    node first=head;
    node second = head.next;
    if(head==null)
      return head;
    
    while(second!=null)
    {
      second=second.next;
      if(second!=null)
      {
        first = first.next;
        second = second .next;
      }
    }
    
    return first;
  }
  
  
  node mergeLists(node leftPart, node rightPart)
  {
    if(rightPart==null)
      return leftPart;
    else if(leftPart==null)
      return rightPart;
    
    node res= null;
    if(leftPart.val<=rightPart.val)
    {
      	res = leftPart;
      	res.next= mergeLists(leftPart.next,rightPart);
    }
    else
    {
       	res = rightPart;
      	res.next= mergeLists(leftPart,rightPart.next);
    
    }
    
    return res;
  }
  
  	node mergeSort(node head)
    {
      	if(head == null || head.next == null)
          return head;
      
      node middle = getMiddle(head);
      node middlePlusOne = middle.next;
      middle.next = null;
      
      node leftPart = mergeSort(head);
      node rightPart = mergeSort(middlePlusOne);
      
      node res = mergeLists(leftPart,rightPart);
      
      return res;
      
      	
    }
  
  
	void push(int new_data) 
	{ 
		/* allocate node */
		node new_node = new node(new_data); 

		/* link the old list off the new node */
		new_node.next = head; 

		/* move the head to point to the new node */
		head = new_node; 
	} 

	// Utility function to print the linked list 
	void printList(node headref) 
	{ 
		while (headref != null) 
		{ 
			System.out.print(headref.val + " "); 
			headref = headref.next; 
		} 
	} 
	
	public static void main(String[] args) 
	{ 

		linkedList li = new linkedList(); 
		/* 
		* Let us create a unsorted linked lists to test the functions Created 
		* lists shall be a: 2->3->20->5->10->15 
		*/
		li.push(15); 
		li.push(10); 
		li.push(5); 
		li.push(20); 
		li.push(3); 
		li.push(2); 
		System.out.println("Linked List without sorting is :"); 
		li.printList(li.head); 

		// Apply merge Sort 
		li.head = li.mergeSort(li.head); 
		System.out.print("\n Sorted Linked List is: \n"); 
		li.printList(li.head); 
	} 
} 

// This code is contributed by Rishabh Mahrsee 
