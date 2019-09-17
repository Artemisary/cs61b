import org.w3c.dom.ls.LSOutput;

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> b = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i = i + 1) {
            char a = word.charAt(i);
            b.addLast(a);
        }
        return b;
    }

    private boolean FirstEqualsLast(Deque<Character> x) {
        if (x.size() <= 1) {
            return true;
        }
        if (x.removeFirst() == x.removeLast()) {
            return FirstEqualsLast(x);
        }
        return false;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> b = wordToDeque(word);
        if (FirstEqualsLast(b)) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> b = wordToDeque(word);
        if (word.length() >= 2) {
            if (!cc.equalChars(b.removeFirst(), b.removeLast())) {
                return false;
            }
            word = word.substring(1, word.length() - 1);
            return isPalindrome(word, cc);
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        OffByOne offbyone = new OffByOne();

        palindrome.isPalindrome("flake", offbyone);
    }
}
