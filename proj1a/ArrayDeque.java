/**
 * Array based list.
 *
 * @author Josh Hug
 */
public class ArrayDeque<CherryDurian> {
    private CherryDurian[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    /**
     * Creates an empty list.
     */
    public ArrayDeque() {
        items = (CherryDurian[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
    }

    /**
     * Insert x into the front of the array
     */
    public void addFirst(CherryDurian x) {
        if (size == items.length) {
            resize();
        }
        items[nextFirst] = x;
        nextFirst = nextFirst - 1;
        if (nextFirst == -1) {
            nextFirst = items.length - 1;
        }
        size = size + 1;
    }

    /**
     * Create a new array with bigger size
     */
    private void resize() {
        CherryDurian[] a = (CherryDurian[]) new Object[size * 2];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
        if (nextFirst != size - 1) {
            System.arraycopy(items, 0, items, size, nextLast);
            for (int i = 0; i < nextLast; i = i + 1) {
                items[i] = null;
            }
            nextLast = size + nextLast;
        } else {
            nextFirst = items.length - 1;
            nextLast = size;
        }
    }

    /**
     * Inserts X into the back of the list.
     */
    public void addLast(CherryDurian x) {
        if (size == items.length) {
            resize();
        }
        items[nextLast] = x;
        nextLast = nextLast + 1;
        if (nextLast == items.length) {
            nextLast = 0;
        }
        size = size + 1;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        for (int i = 0; i < size; i = i + 1) {
            if (i + nextFirst + 1 > items.length - 1) {
                System.out.print(items[i + nextFirst + 1 - items.length] + " ");
            } else {
                System.out.print(items[i + nextFirst + 1] + " ");
            }
        }
        System.out.println(" ");
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     */
    public CherryDurian removeFirst() {
        nextFirst = nextFirst + 1;
        if (nextFirst == items.length) {
            nextFirst = 0;
        }
        CherryDurian a = items[nextFirst];
        items[nextFirst] = null;
        size = size - 1;
        return a;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null.
     * Must not alter the deque!
     */
    public CherryDurian get(int index) {
        if (index + nextFirst + 1 > items.length - 1) {
            return items[index + nextFirst + 1 - items.length];
        } else {
            return items[nextFirst + 1 + index];
        }
    }

    /**
     * Returns the number of items in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Deletes item from back of the list and
     * returns deleted item.
     */
    public CherryDurian removeLast() {
        nextLast = nextLast - 1;
        if (nextLast == -1) {
            nextLast = items.length - 1;
        }
        CherryDurian a = items[nextLast];
        items[nextLast] = null;
        size = size - 1;
        return a;
    }

    /**
     * Creates a deep copy of other
     */
    public ArrayDeque(ArrayDeque other) {
        items = (CherryDurian[]) new Object[other.items.length];
        System.arraycopy(other.items, 0, items, 0, other.items.length);
        nextLast = other.nextLast;
        nextFirst = other.nextFirst;
        size = other.size();
    }

    public static void main(String[] args) {
        ArrayDeque<String> artemisary = new ArrayDeque<>();
        System.out.println(artemisary.isEmpty());
        artemisary.addFirst("hi");
        artemisary.addFirst("how");
        artemisary.addFirst("where ");
        artemisary.addFirst("China");
        artemisary.addLast("boy");
        artemisary.addLast("to go");
        artemisary.addLast("123");
        artemisary.addFirst("aaaaaaaaaaaa");
        artemisary.addLast("aooooooooooo");
        artemisary.addLast("awwwwwwwwwwww");
        artemisary.addFirst("akkkkkkkkk");
        System.out.println(artemisary.isEmpty());
        artemisary.printDeque();
        System.out.println(artemisary.get(4));
        System.out.println(artemisary.get(7));
        artemisary.removeFirst();
        artemisary.removeLast();
        ArrayDeque<String> wy = new ArrayDeque<>(artemisary);
    }
} 
