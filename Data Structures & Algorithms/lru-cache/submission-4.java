class LRUCache {
HashMap<Integer,Node> cache;
int capacity;
Node leftNode,rightNode;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache=new HashMap<>();
        leftNode=new Node(0,0);
        rightNode=new Node(0,0);
        leftNode.next=rightNode;
        rightNode.prev=leftNode;
    }
    private void remove(Node node){
        Node prevNode=node.prev;
        Node nextNode=node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }

    private void insert(Node node){
        Node lastNode=this.rightNode.prev;
        lastNode.next=node;
        node.prev=lastNode;
        node.next=this.rightNode;
        this.rightNode.prev=node;

    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            remove(node);
            insert(node);
            Node getNode=cache.get(key);
            return getNode.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            remove(node);
        }
        Node newNode=new Node(key,value);
        cache.put(key,newNode);
            insert(newNode);
        if(cache.size()>capacity){
            Node lruNode=this.leftNode.next;
            remove(lruNode);
            cache.remove(lruNode.key);

        }
    }
}

class Node{
    int key;
    int value;
    Node next;
    Node prev;
    public Node(int key,int value){
        this.key=key;
        this.value=value;
        next=null;
        prev=null;
    }
}
