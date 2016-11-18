package scanner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by ZW on 16-11-10.
 */
public class Scan {
    private String filePath;
    private FileReader reader;
    private BufferedReader bReader;
    private Scanner in = new Scanner(System.in);


    public Scan(String file) {
        boolean done = false;
        filePath = file;
        do {
            try {
                reader = new FileReader(filePath);
                done = true;
            } catch (FileNotFoundException e) {
                System.out.println("文件不存在,需要创建吗？");

                System.out.print("请重新输入地址:");
                filePath = in.nextLine().replace("\\", "\\\\");
            }
        } while (!done);
    }

    public void start(String target) {
        int Line = 1, index = 0;
        boolean done = false;
        List<Integer> num = new ArrayList<>();
        List<Integer> lines = new ArrayList<>();
        bReader=new BufferedReader(reader,20);
        char[] ins=new char[20];

        do {
            String read = null;
            try {
                index=bReader.read(ins,0,20);
                read=new String (ins);
                if (index==-1){
                    done=true;
                }
                for (int i = -5; i != -1; ) {
                    if(i==-5){
                    i=read.indexOf(target);
                    }else {
                    i = read.indexOf(target, num.get(num.size()-1)+1);
                    }switch (i){
                        case -1:
                            break;
                        default:
                            num.add(i+1);
                            lines.add(Line);
                    }
                }
                Line++;
            } catch (IOException e){
            }
        } while (!done);
        if (lines.isEmpty()) {
            System.out.println("未找到目标");
        } else {
            try {

                for (int i = 0; i < lines.size(); i++) {
                    System.out.print("在第" + lines.get(i) + "行第" + num.get(i) + "个字符");
                    System.out.println("处找到目标\"" + target + "\"");
                }
            } catch (Exception e) {
                System.out.println("出错了 我也不知道怎么错的反正就是错了");
            }
        }
    }

}
