public interface Deque<CherryDurian> {
    public void addFirst(CherryDurian x);
    public void addLast(CherryDurian x);
    default boolean isEmpty(){
        if (size() == 0) {
            return true;
        }
        return false;
    };
    public void printDeque();
    public int size();
    public CherryDurian removeFirst();
    public CherryDurian removeLast();
    public CherryDurian get(int index);
}
