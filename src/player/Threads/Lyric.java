package player.Threads;

import javazoom.jl.player.jlp;

import java.io.*;
import java.util.*;

/**
 * Created by 张巍 on 2016/11/16.
 */
public class Lyric extends Thread {
    private String[] aPath = new String[0];
    private BufferedReader aReader = null;
    private List<String> aTimeLine = new ArrayList<>();
    private Stack<String> info = new Stack<>();
    private Stack<String> aLyric = new Stack<>();
    private List<String> cache = new ArrayList<>();

    public Lyric(String[] path) {
        aPath = path;
    }

    public void run() {
        try {
            aReader = new BufferedReader(new FileReader(aPath[0]));
            readLRC();
        } catch (IOException e) {
            System.out.println("歌词文件错误，已退出。");
            return;
        }
    }

    private void readLRC() {
        String outPut;
        try {
            while (true) {
                aReader.readLine();
                if (aReader == null) break;
                outPut = aReader.toString();
                cache.add(outPut);
            }
            System.out.println("Yoooooooooooo");
        } catch (IOException e) {
        }

    }

    private void analyze() {
        String[] GG = null;
        for (String a : cache
                ) {
            GG = a.split("\\[" + "\\]");
        }
        for (String a : GG) {
            if (a.startsWith("\\d")) {
                aTimeLine.add(a);
            } else if (a.startsWith("ti") || a.startsWith("ar") ||
                    a.startsWith("al") || a.startsWith("by")) {
                info.add(a);
            } else {
                aLyric.add(a);
            }
        }
    }
}
