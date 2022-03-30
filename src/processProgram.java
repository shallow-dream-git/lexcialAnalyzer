import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author shallow dream
 * @create 2022--03--28 23:23
 */
public class processProgram {
    /**
     * //将代码转换为片段
     * //片段：指的是 不包含换行符，不包含注释，依据分号切割成小片段
     * 1. 先按照换行符切成单独的row
     * 2. 每一行后面判断是否存在注释，若存在，将注释去掉
     * 3. 按照空格切分 eg. x := 1; -> [x,:=,1]
     * 4. 按照";"切分 eg. x:=1;x++; -> [x:=1,x++]
     */
    public static LinkedList<String> programToSlice(String program) {
        //slices作为分割后的List返回
        LinkedList<String> slices = new LinkedList<>();
        // step:1
        String[] row = program.split("\n+");
        // step:2
        LinkedList<String> excludeComments = new LinkedList<>();
        for (String s : row) {
            if (s.contains("#")) {
                s = s.split("#")[0];
            }
            // 去除字符串前后的空格字符
            s = s.strip();
        // step:3
            // 正则表达式:切割非空格字符
            excludeComments.addAll(Arrays.asList(s.split(" +")));
        }
        // step:4
        while (!excludeComments.isEmpty()) {
            String s = excludeComments.remove();
            if (!s.contains(";")) {
                slices.add(s);
            } else {
                String[] slice = s.split(";");
                for (int i = 0; i < slice.length; i++) {
                    slices.add(slice[i]);
                    /*
                    不确定当前片段是否是以分号结束
                    eg. x++;while(x){  这种情况不需要在结尾添加
                    eg. x++;y++; 这种情况需要切割成["x++",";","y++",";"]
                     */
                    if (i != slice.length - 1) {
                        slices.add(";");
                    }
                }
                //额外判断
                if (s.endsWith(";")) {
                    slices.add(";");
                }
            }
        }
        return slices;
    }
}
