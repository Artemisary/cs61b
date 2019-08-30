public class SLList {
    public IntNode sentinel;
    public int size;

    public class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    /**
     * Adds an item to the front of the list.
     */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size = size + 1;
    }

    /**
     * Retrieves the front item from the list.
     */
    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {
        size = size + 1;
        IntNode p = sentinel.next;
        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    /**
     * Returns the size of the list starting at IntNode p.
     * private static int size(IntNode p) {
     * if (p.next == null) {
     * return 1;
     * }
     * <p>
     * return 1 + size(p.next);
     * }
     * public int size(){
     * return size(first);
     * }
     * We don't need it any more.
     */
    public static void main(String[] args) {
        SLList l = new SLList();
        l.addFirst(10);
        l.addFirst(5);
        l.addLast(20);
        int x = l.getFirst();
        System.out.println(l.size);
    }
}
