import java.util.HashMap;
import java.util.Map;

/**
 * @author shallow dream
 * @create 2022--03--28 22:01
 */
public class categoryCodeTable {
    private categoryCodeTable() {
    }

    private static Map<String, Integer> keywords = new HashMap<>();
    private static Map<String, Integer> simpleOperators = new HashMap<>();
    private static Map<String, Integer> compoundOperators = new HashMap<>();

    public static Token isOperator(String s, int length) {
        if (length == 1) {
            return (simpleOperators.containsKey(s)) ? new Token(simpleOperators.get(s), s) : new Token(-2, s);// null;
        } else {
            return (compoundOperators.containsKey(s)) ? new Token(compoundOperators.get(s), s) : new Token(-3, s);//null;
        }
    }

    static {
        String[] s = new String[]{"begin", "if", "then", "while", "do", "end", "int", "main",};
        for (int i = 0; i < s.length; i++) {
            keywords.put(s[i], i + 1);
        }
        keywords.put("return", 12);
        keywords.put("cout", 13);
//        keywords.put(";", 34);
    }

    static {
        String[] s = new String[]{"+", "-", "*", "/", "(", ")", "[", "]", "{", "}", ",", ":"};
        for (int i = 0; i < s.length; i++) {
            simpleOperators.put(s[i], i + 22);
        }
        simpleOperators.put(";", 34);
        simpleOperators.put("\\", 41);

        simpleOperators.put(">", 35);
        simpleOperators.put("<", 36);
        simpleOperators.put("!", -1);
        simpleOperators.put("#", 0);
        simpleOperators.put("\0", 1000);
    }

    static {
        compoundOperators.put(":=", 18);
        compoundOperators.put("==", 21);
        compoundOperators.put(">=", 37);
        compoundOperators.put("<=", 38);
        compoundOperators.put("!=", 40);
    }

    private static boolean isDigital(String s) {
//        if(keywords.containsKey(s)) {
//            return true;
//        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIdentifier(String s) {
//        if(keywords.containsKey(s)){
//            return true;
//        }
        if (!Character.isLetter(s.charAt(0))) {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static Token judge(String s) {
        if (categoryCodeTable.keywords.containsKey(s)) {
            return new Token(categoryCodeTable.keywords.get(s), s);
        }
        if (categoryCodeTable.isIdentifier(s)) {
            return new Token(10, s);
        }
        if (categoryCodeTable.isDigital(s)) {
            return new Token(20, s);
        }
        return null;
    }
}
