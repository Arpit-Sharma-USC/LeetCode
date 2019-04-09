class LRUCache {

    class DLLNode
    {
        int key;
        int value;
        DLLNode next;
        DLLNode prev;
        
    }
    
    private HashMap<Integer,DLLNode> cache = new HashMap<Integer,DLLNode>();
    private int size;
    private int capacity;
    private DLLNode head,tail;
    
    private void addItToHead(DLLNode node)
    {
        node.prev = head;
        node.next = head.next;
        head.next.prev=node;
        head.next = node;
        
    }
    private void deleteFromTail(DLLNode node)
    {
        node.prev.next = node.next;
        node.next.prev=node.prev;
    }
    
    private void moveItToHead(DLLNode node)
    {
        deleteFromTail(node);
        addItToHead(node);
        
    }
    
    private DLLNode popTail()
    {
        DLLNode res = tail.prev;
        deleteFromTail(res);
        
        return res;
    }
    public LRUCache(int capacity)
    {
        this.size = 0;
        this.capacity = capacity;
        
         head = new DLLNode();
         tail = new DLLNode();
        
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        
        DLLNode node = cache.get(key);
        if(node == null)
            return -1;
        
        moveItToHead(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        
        DLLNode node = cache.get(key);
        if(node==null)
        {
            DLLNode newNode = new DLLNode();
            newNode.key=key;
            newNode.value=value;
            
            cache.put(key,newNode);
            
            addItToHead(newNode);
            
            size++;
            if(size>capacity)
            {
                //overflow 
                DLLNode tail = popTail();
                cache.remove(tail.key);
                
                size--;
            }
        }
        else{
            node.value = value;
            moveItToHead(node);
            
        }
        
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
