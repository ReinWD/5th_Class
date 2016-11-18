package scanner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by 张巍 on 2016/11/12.
 */
public class  Test {
    public static void main(String[] args) {
        File io = new File("V:\\test.txt");
        FileWriter HarukiMurakami;
        try {
            io.createNewFile();
            HarukiMurakami = new FileWriter(io);
            for (int i = 0; i < 20000; i++) {
                HarukiMurakami.write("那你很棒哦");
                System.out.println("你很棒哦");
            }
            HarukiMurakami.close();

        } catch (IOException e) {
            System.out.println("让你搞事");
        }
    }
}
