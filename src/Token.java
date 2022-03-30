/**
 * @author shallow dream
 * @create 2022--03--28 21:36
 */
public class Token {
    int syn; //种别码
    String word;  //单词符号

    public Token() {
        this(Integer.MIN_VALUE, null);
    }

    public Token(int syn, String word) {
        this.syn = syn;
        this.word = word;
    }

    //重写toString函数
    @Override
    public String toString() {
        return String.format("Word(" +
                "syn= " + "%2s" +
                ", name='" + "%6s" + '\'' +
                ')', syn, word) + "\n";
    }
}
