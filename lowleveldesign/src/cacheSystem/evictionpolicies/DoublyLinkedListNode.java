package cacheSystem.evictionpolicies;

class DoublyLinkedListNode<Key> {
    Key key;
    DoublyLinkedListNode<Key> next;
    DoublyLinkedListNode<Key> prev;

    public DoublyLinkedListNode(final Key key, final DoublyLinkedListNode<Key> next,
                                final DoublyLinkedListNode<Key> prev) {
        this.key = key;
        this.next = next;
        this.prev = prev;
    }

    public DoublyLinkedListNode() {
    }
}
