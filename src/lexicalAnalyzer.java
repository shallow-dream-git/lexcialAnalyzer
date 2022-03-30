import java.util.LinkedList;

/**
 * @author shallow dream
 * @create 2022--03--29 14:47
 */
public class lexicalAnalyzer {
    public LinkedList<Token> analyze(String s) {
        LinkedList<Token> list = new LinkedList<>();
        Token token = categoryCodeTable.judge(s);
        if (token != null) {
            list.add(token);
        } else {
            expression(list, s);
        }
        return list;
    }

    public void expression(LinkedList<Token> list, String s) {
        char[] c = s.toCharArray();
        int i = 0;
        while (i < c.length) {
            if (Character.isLetter(c[i])) {
                String ch = "";
                ch += c[i++];
                //后面为字符或者数字
                while (i < c.length && (Character.isLetter(c[i]) || Character.isDigit(c[i]))) {
                    ch += c[i++];
                }
                //将token加入list中
                list.add(new Token(10, ch));
                continue;
            } else if ((Character.isDigit(c[i]))) {
                String ch = "";
                ch += c[i++];
                //error1
                //后面跟着数字
                while (i < c.length && (Character.isDigit(c[i]))) {
                    ch += c[i++];
                }
                list.add(new Token(20, ch));
                continue;
            } else {
                int j = (i + 1 < c.length && c[i + 1] == '=') ? i + 2 : i + 1;
                Token token = categoryCodeTable.isOperator(s.substring(i, j), j - i);
                if (token != null) {
                    list.add(token);
                }
                i = j;
//                switch (c[i]) {
//                    case ':':
//                    case '=':
//                    case '>':
//                    case '<':
//                    case '!':
//                        int j = (c[i + 1] == '=') ? i + 2 : i + 1;
//                        Token token = categoryCodeTable.isOperator(s.substring(i,j),j-i);
//                        if(token != null){
//                            list.add(token);
//                        }
//                        i = j;
//                        break;
//                    default:
//                        if (categoryCodeTable.simpleOperators.containsKey(c[i])) {
//                            list.add(new Token(categoryCodeTable.simpleOperators.get(c[i]), String.valueOf(c[i])));
//                        } else {
//                            System.out.println("未识别" + c[i] + "字符");
//                        }
//                        i++;
//                }
            }
        }
    }
}
