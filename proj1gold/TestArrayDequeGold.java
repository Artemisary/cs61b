import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {
    /**@source
     * StudentArrayDequeLauncher.java
     * **/
    @Test
    public void test1(){
        double numberBetweenZeroAndOne = StdRandom.uniform();
        Integer expect;
        if (numberBetweenZeroAndOne < 0.5) {
            StudentArrayDeque<Integer> stu1 = new StudentArrayDeque<>();
            stu1.addFirst(20);
            stu1.addFirst(29);
            stu1.addLast(18);
            stu1.addLast(28);
            expect=4;
            assertEquals("Oh noooo!\nThis is bad:\n   size "  + stu1.size()
                    + " not equal to " + expect + "!",(Integer) stu1.size(),expect);
            expect=29;
            assertEquals("cipe",stu1.removeFirst(),expect);
            expect=28;
            assertEquals(stu1.removeLast(),expect);
            expect=18;
            assertEquals(stu1.get(1),expect);
        } else {
            ArrayDequeSolution<Integer> stu2 = new ArrayDequeSolution<>();
            stu2.addFirst(15);
            stu2.addFirst(12);
            stu2.addLast(9);
            stu2.addLast(4);
            expect=4;
            assertEquals("Oh noooo!\nThis is bad:\n   size "  + stu2.size()
                    + " not equal to " + expect + "!",(Integer) stu2.size(),expect);
            expect=12;
            assertEquals(stu2.removeFirst(),expect);
            expect=4;
            assertEquals(stu2.removeLast(),expect);
            expect=9;
            assertEquals(stu2.get(1),expect);
        }
    }
}
