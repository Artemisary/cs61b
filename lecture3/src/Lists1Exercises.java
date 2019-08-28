public class Lists1Exercises {
    /** Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change. */
    public static IntList incrList(IntList L, int x) {
        IntList P =new IntList(L.get(L.size())+x,null);
        for(int i=L.size()-1;i>0;i=i-1){
            P =new IntList(L.get(i)+x,P);
        }
        return P;
    }

    /** Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        IntList P = L;
        for(int i=1;i<P.size()+1;i++){
            L.first = L.first + x;
            L = L.rest;
        }
        return P;
    }

    public static void main(String[] args) {
        IntList Q;
        IntList M;
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);
        System.out.println(L.size());
        System.out.println(L.iterativeSize());
        System.out.println(L.get(2));
        Q = incrList(L,4);
        M = dincrList(L,5);


        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        // System.out.println(L.get(1));
        // System.out.println(incrList(L, 3));
        // System.out.println(dincrList(L, 3));
    }
}