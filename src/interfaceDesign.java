import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shallow dream
 * @create 2022--03--30 10:22
 */
public class interfaceDesign {
    static JFrame jf = new JFrame("词法分析器");
    static JPanel jp = new JPanel();

    public static void main(String[] args) {
        JLabel text_title = new JLabel("源程序");
        text_title.setBounds(5, 20, 100, 30);
        JTextArea text = new JTextArea();
        text.setBounds(5, 50, 300, 200);
        JScrollPane text_jsp = new JScrollPane(text);
        text_jsp.setBounds(5, 50, 300, 200);
        JLabel res_title = new JLabel("词法分析器结果");
        res_title.setBounds(5, 250, 100, 50);
        JTextArea res = new JTextArea();
        res.setBounds(5, 300, 300, 200);
        res.setEditable(false);
        JScrollPane res_jsp = new JScrollPane(res);
        res_jsp.setBounds(5, 300, 300, 200);
        JButton button = new JButton("分析");
        button.setBounds(150, 520, 100, 30);
        button.addActionListener(e -> {
            String s = text.getText();
            output(s, res);
        });
        JButton file = new JButton("选择文件");
        file.setBounds(50,520,100,30);
        file.addActionListener(e->{
           readFile read = new readFile();
           text.setText(read.program);
        });
        jp.add(file);
        jp.add(res_jsp);
        jp.add(text_jsp);
        jp.setLayout(null);
        jp.add(text_title);
//        jp.add(text);
        jp.add(res_title);
//        jp.add(res);
        jp.add(button);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setSize(400, 600);
        jf.add(jp);
    }

    public static void output(String s, JTextArea jta) {
        jta.setText("");
        lexicalAnalyzer la = new lexicalAnalyzer();
        LinkedList<String> res = processProgram.programToSlice(s);
        LinkedList<Token> list = new LinkedList<>();
        while (!res.isEmpty()) {
            list.addAll(la.analyze(res.pop()));
        }
        AtomicInteger i = new AtomicInteger(1);
        list.stream().forEach(token ->
                jta.append((i.getAndIncrement()) + ":" + token)
        );
    }
}
