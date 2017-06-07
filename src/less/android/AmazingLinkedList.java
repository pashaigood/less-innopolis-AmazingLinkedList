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

    public void add(T value) {
        addLast(value);
    }

    public void add(int index, T value) {
        checkIndex(index);
        if (index == size) {
            addLast(value);
        } else {
            insertBefore(value, findNodeAt(index));
        }
    }

    private void checkIndex(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + " is to big. Size: " + size);
        }
    }

    private void addLast(T value) {
        AmazingNode<T> currentLast = last;
        AmazingNode<T> newNode = new AmazingNode<>(currentLast, value, null);

        last = newNode;
        if (currentLast == null) {
            first = newNode;
        } else {
            currentLast.setNext(newNode);
        }

        incrementSize();
    }

    private void insertBefore(T value, AmazingNode<T> node) {
        final AmazingNode<T> prev = node.getPrev();
        final AmazingNode<T> newNode = new AmazingNode<>(prev, value, node);
        node.setPrev(newNode);

        if (prev == null) {
            first = newNode;
        } else {
            prev.setNext(newNode);
        }

        incrementSize();
    }

    private AmazingNode<T> findNodeAt(int index) {
        if (index < pick) {
            AmazingNode<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.getNext();
            return x;
        } else {
            AmazingNode<T> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.getPrev();
            }
            return x;
        }
    }

    public void remove(int index) {
        checkIndex(index);
        AmazingNode<T> nodeToRemove = findNodeAt(index);
        if (nodeToRemove == null) {
            throw new IndexOutOfBoundsException("Should not find node at: " + index);
        }

        removeNode(nodeToRemove);
    }

    public void remove(T value) {
        AmazingNode<T> node = first;

        while (node != null) {
            if (node.getValue().equals(value)) {
                removeNode(node);
            }
            node = node.getNext();
        }
    }

    private void removeNode(AmazingNode<T> nodeToRemove) {
        AmazingNode<T> prevNode = nodeToRemove.getPrev();
        AmazingNode<T> nextNode = nodeToRemove.getNext();

        if (nextNode == null) {
            last = prevNode;
            prevNode.setNext(null);
        } else if (prevNode == null) {
            first = nextNode;
        }
        else {
            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);
        }

        decrementSize();
    }

    private void incrementSize() {
        size++;
        pick = size / 2;
    }

    private void decrementSize() {
        size--;
        pick = size / 2;
    }


    public boolean contains(T value) {
        AmazingNode<T> node = first;

        while (node != null) {
            if (node.getValue().equals(value)) {
                return true;
            }

            node = node.getNext();
        }

        return false;
    }
}
