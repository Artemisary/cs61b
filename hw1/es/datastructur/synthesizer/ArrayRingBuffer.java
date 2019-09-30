package es.datastructur.synthesizer;

import javax.sql.rowset.FilteredRowSet;
import java.util.Iterator;
import java.util.Objects;

//Make sure to that this class and all of its methods are public
//Make sure to add the override tag for all overridden methods
//Make sure to make this class implement BoundedQueue<T>

public class ArrayRingBuffer<T> implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // Create new array with capacity elements.
        // first, last, and fillCount should all be set to 0.
        first = 0;
        last = 0;
        fillCount = 0;
        rb = (T[]) new Object[capacity];
    }

    @Override
    public int capacity() {
        return rb.length;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public void enqueue(T x) {
        //  Enqueue the item. Don't forget to increase fillCount and update
        //       last.
        if (fillCount == rb.length) {
            throw new RuntimeException("Ring Buffer overflow");
        }
        rb[last] = x;
        last = last + 1;
        if (last == rb.length) {
            last = 0;
        }
        fillCount = fillCount + 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {
        //  Dequeue the first item. Don't forget to decrease fillCount and
        //       update first.
        if (fillCount == 0) {
            throw new RuntimeException("Ring Buffer underflow");
        }
        T dequeueItem = rb[first];
        rb[first] = null;
        first = first + 1;
        if (first == rb.length) {
            first = 0;
        }
        fillCount = fillCount - 1;
        return dequeueItem;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T peek() {
        // Return the first item. None of your instance variables should
        //       change.
        return rb[first];
    }

    private class ArrayRingBufferIterator implements Iterator<T> {
        private int wizPos;
        private int FirstCopy;

        public ArrayRingBufferIterator() {
            wizPos = 0;
            FirstCopy = first;
        }

        @Override
        public boolean hasNext() {
            return wizPos < fillCount;
        }

        @Override
        public T next() {
            T returnItem = rb[FirstCopy];
            wizPos += 1;
            FirstCopy = FirstCopy + 1;
            if (FirstCopy == capacity()) {
                FirstCopy = 0;
            }
            return returnItem;
        }
    }

    @Override
    public boolean equals(Object o) {
        Iterator<T> seer = ((ArrayRingBuffer<T>) o).iterator();
        int a = this.first;
        while (seer.hasNext()) {
            if (seer.next() != this.rb[a]) {
                return false;
            }
            a = a + 1;
            if (a == this.capacity()) {
                a = 0;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }
    //  When you get to part 4, implement the needed code to support
    //       iteration and equals.
}

