class LRUCache {
    //1. Create a class to initialize Doubbly LinkedList i.e ListNode
    class ListNode {
        ListNode prev, next;
        int key, value;
        ListNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    //2. Creation of head and tail of the linkedlist and a map to store the 
    // key and the node i.e reference of the node.
    ListNode head = new ListNode(0, 0);
    ListNode tail = new ListNode(0, 0);
    HashMap<Integer, ListNode> map = new HashMap<>();
    int capacity;

    //3. Initialize the capacity, head and tail of the DLL
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        deleteNode(node);
        insertNode(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deleteNode(map.get(key));
        }
        if (map.size() == capacity) {
            deleteNode(tail.prev);
        }
        insertNode(new ListNode(key, value));
    }

    private void deleteNode(ListNode node) {
        if (node == head || node == tail) return; 
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertNode(ListNode node) {
        map.put(node.key, node);
        ListNode headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }
}
