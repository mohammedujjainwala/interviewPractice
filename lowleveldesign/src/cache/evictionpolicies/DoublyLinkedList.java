package cache.evictionpolicies;

public class DoublyLinkedList<Value> {
    private DoublyLinkedListNode<Value> head,last;
    DoublyLinkedList(){
        head = new DoublyLinkedListNode<>();
        last = new DoublyLinkedListNode<>();
        head.next = last;
        last.prev = head;
    }

    void removeNode(DoublyLinkedListNode<Value> node){
        DoublyLinkedListNode<Value> prev = node.prev;
        DoublyLinkedListNode<Value> next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    void addNodeLast(DoublyLinkedListNode<Value> node){
        add(last.prev, last, node);
    }

    void addNodeFirst(DoublyLinkedListNode<Value> node){
        add(head, head.next, node);
    }

    DoublyLinkedListNode<Value> getFirst(){
        if(head.next==last)return null;
        return head.next;
    }

    DoublyLinkedListNode<Value> getLast(){
        if(last.prev==head)return null;
        return last.prev;
    }

    private void add(DoublyLinkedListNode<Value> prev, DoublyLinkedListNode<Value> next, DoublyLinkedListNode<Value> node){
        prev.next = node;
        node.prev = prev;
        node.next = next;
        next.prev = node;
    }
}
