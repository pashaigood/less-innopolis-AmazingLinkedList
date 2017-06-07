package less.android;

public class Main {

    public static void main(String[] args) {
        testAddToTail();
        testAddAtIndex();
        testRemoveAtIndex();
        testRemoveItem();
        testContaintns();
    }

    private static void testAddToTail() {
        AmazingLinkedList<Number> list1 = new AmazingLinkedList<>();

        try {
            list1.add(5);
            if (list1.getSize() != 1) {
                System.err.println("New size should be 1.");
            }
        } catch (Exception e) {
            System.err.println("Add should work.");
        }

        try {
            list1.add(1);
            if (list1.getSize() != 2) {
                System.err.println("New size should be 2.");
            }
        } catch (Exception e) {
            System.err.println("Add should work.");
        }
    }

    private static void testAddAtIndex() {
        int prevSize;
        AmazingLinkedList<Number> list1 = new AmazingLinkedList<>();

        prevSize = list1.getSize();
        try {
            list1.add(3, 124);
            System.err.println("Should not add a item at to big index.");
        } catch (IndexOutOfBoundsException e) {
            if (prevSize != list1.getSize()) {
                System.err.println("Size should be equals.");
            }
        }

        try {
            list1.add(0, 3);
        } catch (Exception e) {
            System.err.println("Should add item at 0 item to the empty list.");
        }
        if (list1.getSize() != 1) {
            System.err.println("The size should be 1. Has: " + list1.getSize());
        }

        list1.add(4343);
        list1.add(342);

        if (list1.getSize() != 3) {
            System.err.println("The size should be 3. Has: " + list1.getSize());
        }

        try {
            list1.add(1, 3);
            if (list1.getSize() != 4) {
                System.err.println("The size should be 4. Has: " + list1.getSize());
            }
        } catch (Exception e) {
            System.err.println("Should add a item at 1 index.");
        }

        try {
            list1.add(0, 33);
            if (list1.getSize() != 5) {
                System.err.println("The size should be 5. Has: " + list1.getSize());
            }
        } catch (Exception e) {
            System.err.println("Should add a item at first index.");
        }

        try {
            list1.add(4, 33);
            if (list1.getSize() != 6) {
                System.err.println("The size should be 6. Has: " + list1.getSize());
            }
        } catch (Exception e) {
            System.err.println("Should add a item at last index.");
        }
    }

    private static void testRemoveAtIndex() {
        int prevSize;
        AmazingLinkedList<Number> list1 = new AmazingLinkedList<>();

        try {
            list1.remove(3);
            System.err.println("Should not remove a item at to big index.");
        } catch (IndexOutOfBoundsException e) {}

        list1.add(4343);
        list1.add(431243);
        list1.add(23);
        list1.add(999);

        prevSize = list1.getSize();
        try {
            list1.remove(list1.getSize() - 1);
            if (prevSize - 1 != list1.getSize()) {
                System.err.println("The size should be " + (prevSize - 1) + ". Has: " + list1.getSize());
            }
        } catch (Exception e) {
            System.err.println("Should remove a item at last index.");
        }




        prevSize = list1.getSize();
        try {
            list1.remove(list1.getSize() - 2);
            if (prevSize - 1 != list1.getSize()) {
                System.err.println("The size should be " + (prevSize - 1) + ". Has: " + list1.getSize());
            }
        } catch (Exception e) {
            System.err.println("Should remove a item at " + (list1.getSize() - 1) + " index.");
        }

        prevSize = list1.getSize();
        try {
            list1.remove(0);
            if (prevSize - 1 != list1.getSize()) {
                System.err.println("The size should be " + (prevSize - 1) + ". Has: " + list1.getSize());
            }
        } catch (Exception e) {
            System.err.println("Should remove a item at first index.");
        }
    }

    private static void testRemoveItem() {
        int prevSize;
        AmazingLinkedList<Number> list1 = new AmazingLinkedList<>();

        list1.add(4343);
        list1.add(122);
        list1.add(122);
        list1.add(545);

        prevSize = list1.getSize();
        try {
            list1.remove((Number) 4343);
            if (list1.getSize() != prevSize - 1) {
                System.err.println("The size should be " + (prevSize - 1) + ". Has: " + list1.getSize());
            }
        } catch (Exception e) {
            System.err.println("Should remove an item." );
            System.err.println(e);
        }

        prevSize = list1.getSize();
        try {
            list1.remove((Number) 122);
            if (list1.getSize() != prevSize - 2) {
                System.err.println("The size should be " + (prevSize - 2) + ". Has: " + list1.getSize());
            }
        } catch (Exception e) {
            System.err.println("Should remove an item." );
            System.err.println(e);
        }
    }

    private static void testContaintns() {
        AmazingLinkedList<String> list1 = new AmazingLinkedList<>();

        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("3");

        try {
            if (list1.contains("1") != true) {
                System.err.println("Should have the item." );
            }

            if (list1.contains("3") != true) {
                System.err.println("Should have the item." );
            }
        } catch (Exception e) {
            System.err.println("Should remove an item." );
        }

        list1.remove("1");

        try {
            if (list1.contains("1") == true) {
                System.err.println("Should not have the item." );
            }
        } catch (Exception e) {
            System.err.println("Should remove an item." );
        }

        list1.remove("3");

        try {
            if (list1.contains("3") == true) {
                System.err.println("Should not have the item." );
            }
        } catch (Exception e) {
            System.err.println("Should remove an item." );
        }
    }
}
