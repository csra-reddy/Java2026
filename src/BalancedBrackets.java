import java.util.ArrayDeque;

public class BalancedBrackets {

    public boolean isBalanced(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            } else {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if ((chars[i] == ')' && top != '(') ||
                   (chars[i] == ']' && top != '[') ||
                        (chars[i] == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        BalancedBrackets obj = new BalancedBrackets();
        boolean res = obj.isBalanced("[[]]");
        if (res) {
            System.out.println("it is balanced");
        } else {
            System.out.println("it is not balanced");
        }
    }
}
