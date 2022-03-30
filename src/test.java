import java.util.Arrays;

/**
 * @author shallow dream
 * @create 2022--03--28 23:22
 */
public class test {
    public static void main(String[] args) {
        String s = "int main(){\n" +
                "    int x1:=10;\n" +
                "\n" +
                "\n" +
                "    if(x1>=10){\n" +
                "        int y:=x*x+10;\n" +
                "    }else{\n" +
                "        int z:=x*x*x+1/3; #求x的三次方加上1/3\n" +
                "    }\n" +
                "    return 0;\n" +
                "}";
//        System.out.println(processProgram.programToSlice(s).toString());
//        [int, main(){, int, x1:=10, ;, if(x1>=10){, int, y:=x*x+10, ;,
//         }else{, int, z:=x*x*x+1/3, ;, }, return, 0, ;, }}

    }
}
