import es.datastructur.synthesizer.ArrayRingBuffer;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayRingBuffer {
    @Test
    public void testArrayRingBuffer() {

        ArrayRingBuffer<Integer> test = new ArrayRingBuffer<Integer>(4);
        assertEquals("Wrong size defining!", 4, test.capacity());
        test.enqueue(5);
        assertEquals("Wrong Peek or Enqueue!", (Integer) 5, test.peek());
        test.enqueue(6);
        test.enqueue(7);
        test.enqueue(9);
        assertEquals("Wrong FillCount!", 4, test.fillCount());
        assertEquals("Wrong IsFull!", true, test.isFull());
        assertEquals("Wrong Dequeue!", (Integer) 5, test.dequeue());
        assertEquals("Wrong Dequeue!", (Integer) 6, test.dequeue());
        assertEquals("Wrong IsEmpty!", false, test.isEmpty());
    }
}
