package less.android;

public class Main {

    public static void main(String[] args) {
        testAddToTail();
        testAddAtIndex();
    }

    private static void testAddToTail() {
        AmazingLinkedList<Number> list1 = new AmazingLinkedList<>();

        if (!list1.add(5)) {
            System.err.println("Add should work.");
        } else if (list1.getSize() != 1) {
            System.err.println("New size should be 1.");
        }

        if (!list1.add(1)) {
            System.err.println("Add should work.");
        } else if (list1.getSize() != 2) {
            System.err.println("New size should be 2.");
        }
    }

    private static void testAddAtIndex() {
        AmazingLinkedList<Number> list1 = new AmazingLinkedList<>();

        try {
            list1.add(3, 124);
            System.err.println("Should not add a item at to big index.");
        } catch (IndexOutOfBoundsException e) {

        }

        if (! list1.add(0, 3)) {
            System.err.println("Should add item at 0 item to the empty list.");
        } else if (list1.getSize() != 1) {
            System.err.println("The size should be 1. Has: " + list1.getSize());
        }

        list1.add(4343);
        list1.add(342);

        if (list1.getSize() != 3) {
            System.err.println("The size should be 3. Has: " + list1.getSize());
        }

        if (! list1.add(1, 3)) {
            System.err.println("Should add a item at 1 index.");
        } else if (list1.getSize() != 4) {
            System.err.println("The size should be 4. Has: " + list1.getSize());
        }

        if (! list1.add(0, 33)) {
            System.err.println("Should add a item at first index.");
        } else if (list1.getSize() != 5) {
            System.err.println("The size should be 5. Has: " + list1.getSize());
        }

        if (! list1.add(4, 33)) {
            System.err.println("Should add a item last index.");
        } else if (list1.getSize() != 6) {
            System.err.println("The size should be 6. Has: " + list1.getSize());
        }
    }

    private static void testRemoveAtIndex() {

    }
}
