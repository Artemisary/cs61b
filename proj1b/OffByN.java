public class OffByN implements CharacterComparator {
    public int N;
    public OffByN(int N1) {
        N=N1;
    }
    @Override
    public boolean equalChars(char a,char b) {
        if (a + N == b | a - N == b) {
            return true;
        }
        return false;
    }
}
