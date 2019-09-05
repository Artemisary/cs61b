
public class LinkedListDeque<CherryDurian> {
    private class StuffNode {
        private CherryDurian item;
        private StuffNode prev;
        private StuffNode next;

        StuffNode(CherryDurian i) {
            item = i;
        }

    }

    private StuffNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new StuffNode(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(CherryDurian x) {
        StuffNode sentinelnextcopy = sentinel.next;
        sentinel.next = new StuffNode(x);
        sentinel.next.prev = sentinel;
        size = size + 1;
        sentinel.next.next = sentinelnextcopy;
        sentinelnextcopy.prev = sentinel.next;
    }

    public CherryDurian getFirst() {
        if (sentinel.next == sentinel.prev) {
            return null;
        }
        return sentinel.next.item;
    }

    public void addLast(CherryDurian x) {
        StuffNode sentinelprevcopy = sentinel.prev;
        sentinel.prev = new StuffNode(x);
        sentinel.prev.next = sentinel;
        size = size + 1;
        sentinel.prev.prev = sentinelprevcopy;
        sentinelprevcopy.next = sentinel.prev;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new StuffNode(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
        for (int i = 0; i < other.size(); i = i + 1) {
            addLast((CherryDurian) other.get(i));
        }
    }

    public void printDeque() {
        StuffNode sentinelcopy=sentinel.next;
        while (sentinelcopy!=sentinel) {
            System.out.print(sentinelcopy.item+ " ");
            sentinelcopy=sentinelcopy.next;
        }
        System.out.println();
    }

    public CherryDurian removeFirst() {
        if (sentinel.prev == sentinel.next) {
            return null;
        }
        size = size - 1;
        CherryDurian a = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        return a;
    }

    public CherryDurian removeLast() {
        if (sentinel.prev == sentinel.next) {
            return null;
        }
        size = size - 1;
        CherryDurian a = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return a;
    }

    public CherryDurian get(int index) {
        StuffNode sentinelcopy = sentinel.next;
        if (index > this.size()) {
            return null;
        }
        for (int i = 0; i < index; i = i + 1) {
            sentinelcopy = sentinelcopy.next;
        }
        return sentinelcopy.item;
    }

    public CherryDurian getRecursive(int index) {
        LinkedListDeque copy = new LinkedListDeque();
        if (index > this.size()) {
            return null;
        }
        if (index == 0) {
            return this.sentinel.next.item;
        }
        copy.sentinel = this.sentinel.next;
        copy.size = this.size() - 1;
        return (CherryDurian) copy.getRecursive(index - 1);

    }

    public static void main(String[] args) {
        LinkedListDeque<String> artemisary = new LinkedListDeque<>();
        artemisary.addFirst("20");
        artemisary.addLast("aremisary");
        artemisary.addLast("hello world");
        artemisary.addFirst("where are you");
        artemisary.size();
        artemisary.get(3);
        System.out.println(artemisary.getRecursive(3));
        System.out.println(artemisary.isEmpty());
        artemisary.printDeque();
        System.out.println(artemisary.getFirst());
        System.out.println(artemisary.removeLast());
        System.out.println(artemisary.removeFirst());
        LinkedListDeque<String> wy = new LinkedListDeque(artemisary);
    }
}
