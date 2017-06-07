package less.android;

public class AmazingLinkedList<T> {
    AmazingLinkedList() {}

    private int size = 0;
    private int pick = 0;

    private AmazingNode<T> first;
    private AmazingNode<T> last;

    public int getSize() {
        return size;
    }

    public boolean add(T value) {
        addLast(value);
        return true;
    }

    public boolean add(int index, T value) {
        checkIndex(index);
        if (index == size) {
            addLast(value);
        } else {
            insertBefore(value, findNodeAt(index));
        }
        return true;
    }

    private void checkIndex(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + "is to big. Size: " + size);
        }
    }

    private void addLast(T value) {
        AmazingNode<T> last = this.last;
        AmazingNode<T> newNode = new AmazingNode<>(last, value, null);

        this.last = newNode;
        if (last == null) {
            first = newNode;
        } else {
            last.setPrev(newNode);
        }

        size++;
        pick = size / 2;
    }

    private void insertBefore(T value, AmazingNode<T> node) {
        final AmazingNode<T> pred = node.getPrev();
        final AmazingNode<T> newNode = new AmazingNode<>(pred, value, node);
        node.setPrev(newNode);
        if (pred == null) {
            first = newNode;
        } else {
            pred.setNext(newNode);
        }
        size++;
        pick = size / 2;
    }

    private AmazingNode<T> findNodeAt(int index) {
        if (index < pick) {
            AmazingNode<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.getNext();
            return x;
        } else {
            AmazingNode<T> x = last;
            System.out.println(last);
            for (int i = size - 1; i > index; i--) {
                x = x.getPrev();
            }
            return x;
        }
    }

    public boolean remove() {
        return false;
    }

    public boolean containts() {
        return false;
    }
}
