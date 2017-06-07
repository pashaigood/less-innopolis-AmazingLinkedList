package less.android;

public class AmazingNode<E> {
    private AmazingNode prev;
    private AmazingNode next;
    private E value;

    AmazingNode(AmazingNode prev, E value, AmazingNode next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }

    public AmazingNode<E> getPrev() {
        return prev;
    }

    public void setPrev(AmazingNode prev) {
        this.prev = prev;
    }

    public AmazingNode<E> getNext() {
        return next;
    }

    public void setNext(AmazingNode next) {
        this.next = next;
    }

    public E getValue() {
        return value;
    }
}
