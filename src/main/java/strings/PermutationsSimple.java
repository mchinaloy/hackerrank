package strings;

public class PermutationsSimple {

    public static void main(String[] args) {
        permutations("ABCDE", "");
    }

    private static void permutations(String word, String ans) {
        if(word.isEmpty()) {
            System.out.println(ans);
            return;
        }

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            String ros = word.substring(0, i) + word.substring(i+1);
            permutations(ros, ans + ch);
        }
    }

}
