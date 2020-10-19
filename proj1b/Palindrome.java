public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordInDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordInDeque.addLast(word.charAt(i));
        }
        return wordInDeque;
    }


    private boolean isPalindromeHelper(Deque<Character> deque) {
        if (deque.size() <= 1) {
            return true;
        } else if (deque.removeFirst() != deque.removeLast()) {
            return false;
        } else {
            return isPalindromeHelper(deque);
        }
    }
    public boolean isPalindrome(String word) {

        return isPalindromeHelper(wordToDeque(word));
    }
    //use equalchars
    private boolean isPalindromeHelper(Deque<Character>deque, CharacterComparator cc) {
        if (deque.size() <= 1) {
            return true;
        } else if (cc.equalChars(deque.removeFirst(),deque.removeLast())){
            return false;
        } else {
            return isPalindromeHelper(deque, cc);
        }
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {

        return isPalindromeHelper(wordToDeque(word),cc);
    }


}
