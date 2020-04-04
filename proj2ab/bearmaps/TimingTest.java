package bearmaps;

public class TimingTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ArrayHeapMinPQ<Integer> minHeap = new ArrayHeapMinPQ<>();
        for (int i = 0; i < 2000; i += 1) {
            minHeap.add(i, 1000 - i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Total time elapsed: " + (end - start) / 1000.0 +  " seconds.");
        long start2 = System.currentTimeMillis();
        for (int j = 0; j < 2000; j += 1) {
            minHeap.changePriority(j, j + 1);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("Total time elapsed: " + (end2 - start2) / 1000.0 +  " seconds.");
    }
}
