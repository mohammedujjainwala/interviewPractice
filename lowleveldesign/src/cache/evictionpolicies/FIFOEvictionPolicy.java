package cache.evictionpolicies;


import java.util.HashMap;

public class FIFOEvictionPolicy<Key> implements IEvictionPolicy<Key> {
    private DoublyLinkedList<Key> doublyLinkedList;
    private HashMap<Key, DoublyLinkedListNode<Key>> nodeMap;
    public FIFOEvictionPolicy(){
        doublyLinkedList = new DoublyLinkedList<>();
        nodeMap = new HashMap<>();
    }

    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> node = doublyLinkedList.getFirst();
        doublyLinkedList.removeNode(node);
        nodeMap.remove(node.key);
        return node.key;
    }

    @Override
    public void removeKey(Key key) {
        doublyLinkedList.removeNode(nodeMap.get(key));
        nodeMap.remove(key);
    }

    @Override
    public void keyAccessed(Key key){
        if(nodeMap.containsKey(key)){
            return;
        }
        DoublyLinkedListNode<Key> node = new DoublyLinkedListNode<>(key,null,null);
        nodeMap.put(key,node);
        doublyLinkedList.addNodeLast(node);
    }
}
