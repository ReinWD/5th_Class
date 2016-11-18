package player;

import javazoom.jl.player.jlp;
import player.Threads.Lyric;
import player.Threads.Music;

import java.io.BufferedReader;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by 张巍 on 2016/11/16.
 */
public class main {
    public static void main(String[] args) {
        if (args[0].length() == 0) {
            System.out.println();
            return;
        }
       /* System.out.println("有几首歌呢");
        String aPath[] = new String[0];
        int n=0;
        for (;aPath.length==0;){
         n = new Scanner(System.in).nextInt();
            try {
                aPath = new String[n];
                if (n==0) System.out.println("0首什什么鬼啦...");
            } catch (Exception e) {
                System.out.println("请别闹兄弟");
                n=0;
            }
        }
        switch (n) {
            case 1:
                System.out.println("请输入路径");
                aPath[0] = new Scanner(System.in).nextLine().replace("\\", "\\\\");
                break;
            default:
                for (int i = 0; i < n; i++) {
                    System.out.println("请输入第" + (i + 1) + "首的路径");
                    aPath[i] = new Scanner(System.in).nextLine().replace("\\", "\\\\");
                }
        }*/
        String aPath[] = new String[1];
        String bPath[] = new String[1];
        Music music = null;
        Lyric lyric = null;
        switch (args.length) {
            case 1:
                aPath[0] = args[0];
                music = new Music(aPath);
                music.run();
                break;
            case 2:
                aPath[0] = args[0];
                bPath[0] = args[1];
                music = new Music(aPath);
                lyric = new Lyric(bPath);
                lyric.run();
                music.run();

                break;
            default:
                int length = args.length;
                if (length % 2 == 1) {
                    System.out.println("请按规矩来谢谢~ ");
                } else {
                    for (int i = 0; i < args.length ; i += 2) {
                        aPath[0] = args[i];
                        bPath[0] = args[i + 1];
                        music = new Music(aPath);
                        lyric = new Lyric(bPath);
                        lyric.run();
                        music.run();
                    }
                }
        }
        System.out.println("播放结束");
    }
}
