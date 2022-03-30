import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shallow dream
 * @create 2022--03--29 16:34
 */
public class readFile {
    String program;
    public readFile(){
        this("test.cpp");
    }
    public readFile(String fileName){
        this.program = read(fileName);
    }
    public String read(String filename){
        StringBuffer sb = new StringBuffer();
        try (
                FileInputStream in = new FileInputStream(filename);
                InputStreamReader StreamReader = new InputStreamReader(in);
                BufferedReader reader = new BufferedReader(StreamReader);
        ) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sb.length() != 0){
                System.out.println("数据读出成功");
            }
        }
        return sb.toString();
    }

//    public static void main(String[] args) {
//        readFile rf = new readFile();
//
//    }
}
