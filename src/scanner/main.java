package scanner;

import java.io.File;
import java.util.Scanner;

/**
 * Created by 张巍 on 2016/11/12.
 */
public class main {
    public static void main(String[] IG) {
        String path = null;
        String target = null;
        Scan wow = null;
        boolean done = false;
        if (IG.length == 2) {
            path =IG[0];
            target =IG[1];
            if (new File(path).canRead()){
            wow=new Scan(path);
            wow.start(target);}else {
                System.out.println("参数错误");
            }
        } else {
            System.out.println("请输入文件地址");
            path = new Scanner(System.in).nextLine().replace("\\", "\\\\");
            wow = new Scan(path);
            System.out.println("请输入搜索目标");
            target = new Scanner(System.in).nextLine();
            done = false;
            do {
                wow.start(target);
                System.out.println("继续搜索其他字符吗？(y)");
                String whether = new Scanner(System.in).next();
                switch (whether) {
                    case "y":
                        System.out.println("请输入搜索目标");
                        target = new Scanner(System.in).nextLine();
                        break;
                    default:
                        done = true;
                }
            } while (!done);
        }
    }


    static {
        System.out.println("2016214874张巍的作业");
    }
}
