import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shallow dream
 * @create 2022--03--29 15:27
 */
class lexicalAnalyzerTest {

    @org.junit.jupiter.api.Test
    void test() {
        lexicalAnalyzer lc = new lexicalAnalyzer();
        readFile rf = new readFile();
        String s = rf.program;
        LinkedList<String> res = processProgram.programToSlice(s);
        LinkedList<Token> list = new LinkedList<>();
        while (!res.isEmpty()) {
            list.addAll(lc.analyze(res.pop()));
        }
        AtomicInteger i = new AtomicInteger(1);
        list.stream().forEach(token ->
                System.out.print((i.getAndIncrement()) + ":" + token)
        );
    }
}