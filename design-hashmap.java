class MyHashMap {
    class ListNode{
        int key,value;
        ListNode next;
        ListNode(int key,int value ){
            this.key=key;
            this.value=value;
            
        }
        
    }
    
    final ListNode[] bucket = new ListNode[10000];
    private int idx(int key)
    {
        return Integer.hashCode(key)%bucket.length;
    }
    private ListNode find(ListNode node, int key)
    {
        ListNode temp=node, prev=null;
        while(temp!=null && temp.key!=key)
        {
            prev=temp;
            temp=temp.next;
        }
        return prev;
    }
    
    
    
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    
        int i =idx(key);
        if(bucket[i]==null)
           bucket[i] = new ListNode(-1,-1);
        ListNode prev=find(bucket[i],key);
        if(prev.next == null)
            prev.next = new ListNode(key,value);
        else
            prev.next.value=value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
        
        int i = idx(key);
        if(bucket[i]==null)
            return -1;
        ListNode prev=find(bucket[i],key);
        
        
        return prev.next==null?-1:prev.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        
        int i =idx(key);
        if(bucket[i]==null)
            return;
        ListNode prev=find(bucket[i],key);
        if(prev.next==null)
            return;
        prev.next=prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
