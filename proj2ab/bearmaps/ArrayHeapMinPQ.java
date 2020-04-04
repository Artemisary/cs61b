package bearmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
/**Attention: Integer with a==b compares the address of a and b, a.equals(b) compares the value of a and b.
 *Because of the range of Integer is form -128 to 127. So in the contain function I use equals.
 */
public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ<T> {

    private ArrayList<PriorityNode> itemPQ;

    public ArrayHeapMinPQ() {
        itemPQ = new ArrayList<>();
    }

    @Override
    public void add(T item, double priority) {
        if (contains(item)) {
            throw new IllegalArgumentException();
        }
        itemPQ.add(new PriorityNode(item, priority));
        swim(size() - 1);
    }

    @Override
    public boolean contains(T item) {
        if (isEmpty()) {
            return false;
        }
        for(int i=0;i<itemPQ.size();i++){
            if(itemPQ.get(i).getItem().equals(item)){
                return true;
            }
        }
        return false;
    }

    @Override
    public T getSmallest() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return itemPQ.get(0).getItem();
    }

    @Override
    public T removeSmallest() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T toRemove = itemPQ.get(0).getItem();
        swap(0, size() - 1);
        itemPQ.remove(size() - 1);
        sink(0);
        return toRemove;
    }

    @Override
    public int size() {
        return itemPQ.size();
    }

    @Override
    public void changePriority(T item, double priority) {
        if (isEmpty() ) {
            throw new NoSuchElementException();
        }
        int index=-1;
        for (int i=0;i<itemPQ.size();i++){
            if(itemPQ.get(i).getItem().equals(item)){
                index = itemPQ.get(i).getKey();
                break;
            }
        }
        if(index==-1)
            throw new NoSuchElementException();
        double oldPriority = itemPQ.get(index).getPriority();
        itemPQ.get(index).setPriority(priority);
        if (oldPriority < priority) {
            sink(index);
        } else {
            swim(index);
        }
    }
    private class PriorityNode {
        private T item;
        private double priority;
        private int key;
        PriorityNode(T item, double priority) {
            this.item = item;
            this.priority = priority;
            this.key = itemPQ.size();
        }

        T getItem() {
            return item;
        }

        double getPriority() {
            return priority;
        }
        int getKey(){
            return key;
        }
        void setPriority(double priority) {
            this.priority = priority;
        }
        void setKey(int key){
            this.key=key;
        }
    }

    private boolean isEmpty() {
        return size() == 0;
    }

    private int parent(int i) {
        if (i == 0) {
            return 0;
        } else {
            return (i - 1) / 2;
        }
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swim(int i) {
        if (i > 0 && smaller(i, parent(i))) {
            swap(i, parent(i));
            swim(parent(i));
        }
    }

    private void sink(int i) {
        int smallest = i;
        if (leftChild(i) <= size() - 1 && smaller(leftChild(i), i)) {
            smallest = leftChild(i);
        }
        if (rightChild(i) <= size() - 1 && smaller(rightChild(i), i)) {

            smallest = rightChild(i);
        }
        if (smallest != i) {
            swap(i, smallest);
            sink(smallest);
        }
    }

    private void swap(int i, int j) {
        PriorityNode temp = itemPQ.get(i);
        itemPQ.set(i, itemPQ.get(j));
        itemPQ.set(j, temp);
        itemPQ.get(i).setKey(i);
        itemPQ.get(j).setKey(j);
    }

    private boolean smaller(int i, int j) {
        return itemPQ.get(i).getPriority() < itemPQ.get(j).getPriority();
    }
}
