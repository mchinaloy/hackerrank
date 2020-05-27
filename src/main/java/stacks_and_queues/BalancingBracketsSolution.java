package stacks_and_queues;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BalancingBracketsSolution {

    public static String isBalanced(String s) {

        if(s == null) {
            return "YES";
        }

        // Walk the characters in the string
        char[] brackets = s.toCharArray();

        Set<Character> rightBrackets = new HashSet<>();
        rightBrackets.add('}');
        rightBrackets.add(']');
        rightBrackets.add(')');

        if(rightBrackets.contains(brackets[0])) {
            return "NO";
        }

        Set<Character> leftBrackets = new HashSet<>();
        leftBrackets.add('{');
        leftBrackets.add('[');
        leftBrackets.add('(');

        Map<Character, Character> bracketMapping = new HashMap<>();
        bracketMapping.put('{','}');
        bracketMapping.put('[',']');
        bracketMapping.put('(',')');

        // Push each left bracket onto a stack
        Stack<Character> seenLeftBrackets = new Stack<>();

        for(int i = 0; i < brackets.length; i++) {
            if(leftBrackets.contains(brackets[i])) {
                seenLeftBrackets.push(brackets[i]);
            } else {
                if(seenLeftBrackets.empty()) {
                    return "NO";
                }
                char poppedLeft = seenLeftBrackets.pop();
                if(bracketMapping.get(poppedLeft) != brackets[i]) {
                    return "NO";
                }
            }
        }

        return "YES";

    }

    public static void main(String[] args) {
        System.out.println(isBalanced("}}))[)]{][)))][]){([)(([))]})[[({{){]}{]{([]}{]}]()}}()[}[[[(][]{))}{}{[)){})()]})([[[[((])})})}()[(({})))({][[][[)[(()(}]})]{[({)}][]{){]}{{(({(}[}{[)[(][))}()){]}][}(((}(}{)({{(]}]))}}]]][)))}{()()]{[}{({){]}({})[{(][](])(}]){{}(][)[[{]{]{(]}{)){}[{{{)]{[[][][())([[{){][(({){}[])}[{([}}{{}][)]]{})}}[{]{(]()}]{}}{{}({]}(]]()}(}]}]({[()(]]{{){})[{{)}({])]{)({[{](]{}(]])]](]()[{{[[){})(}}{(()()})([)(}{(])[{([]){}{{{]{]{{}[({]{[(()){}[)}(([[([{}}){]](}[{}}(){}[[)[}}{}[]{(){][]](}]})[[))))][}(}()){()}([}([})[[}}({{[)}][[]])[[}])]][](([}()[)}])][}}}(()(())({{[]][))}{[[[]]{{[{]}{}}))(]]){)][((}((){[(((]((})[((}][]{[]}([][]])({][){}}[{{]}])}()(}{)]}]])(}{[][]){([)))[{[[)))(}][]{]}[{([(}]([{{{))}})}[)[](}({((}{)(](}[}[[())()]"));
    }

}
