package player.Threads;

import com.sun.org.apache.xalan.internal.lib.ExsltBase;

import java.io.*;
import java.util.*;

/**
 * Created by 张巍 on 2016/11/16.
 */
public class Lyric extends Thread {
    private String[] aPath = new String[0];
    private BufferedReader aReader = null;
    private List<String> aTimeLine = new ArrayList<>();
    private List<Integer> aMilisec = new ArrayList<>();
    private List<String> info = new ArrayList<>();
    private List<String> cache = new ArrayList<>();
    private HashMap<Integer, String> lyricMap = new HashMap<>();
    private HashMap<String, Integer> timeMap = new HashMap<>();
    private HashMap<Long, String> millMap = new HashMap<>();
    int i = 0;

    public Lyric(String[] path) {
        aPath = path;
    }

    public void run() {
        try {
            aReader = new BufferedReader(new FileReader(aPath[0]));
            readLRC();
            out();
        } catch (IOException e) {
            System.out.println("歌词文件错误，已退出。");
        }
    }

    private void readLRC() {
        String outPut;
        try {
            while (true) {
                outPut = aReader.readLine();
                if (outPut == null) break;
                cache.add(outPut);
            }
            analyze();
            transform();
            System.out.println("Yoooooooooooo");
        } catch (IOException e) {
        }

    }

    private void analyze() {
        String[] GG = null;
        int line = 1;
        for (String a : cache
                ) {
            GG = a.split("\\[|\\]");
            for (String b : GG) {
                if (b.equals(""))continue;
                if (b.startsWith("0")) {
                    aTimeLine.add(b);
                    if (GG[GG.length - 1].startsWith("0")) {
                        timeMap.put(b, 1);
                    } else {
                        timeMap.put(b, line);
                    }
                } else if (b.startsWith("ti") || b.startsWith("ar") ||
                        b.startsWith("al") || b.startsWith("by")) {
                    info.add(b);
                } else {
                    if(b.equals("\uFEFF"))lyricMap.put(line,"");
                    else lyricMap.put(line, b);
                }
            }
            line++;
        }
        System.out.println("analyze done");
    }

    private void transform() {
        String[] GG;
        int milliSec;
        for (String a : aTimeLine) {
            GG = a.split(":|\\.");
            milliSec = 1000 * (60 * Integer.valueOf(GG[0]) + Integer.valueOf(GG[1])) + 10 * Integer.valueOf(GG[2]);
            aMilisec.add(milliSec);
            millMap.put((long)milliSec, a);;
        }
        aMilisec.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(aMilisec);
        System.out.println(timeMap);
        System.out.println(millMap);
        System.out.println(lyricMap);
    }

    private void out() {
        long temp=0;
        for (String string : info
                ) {
            System.out.println(string);
            try {
                sleep((long) aMilisec.get(0) / info.size());
            } catch (Exception e) {
            }
        }
        for (long a:aMilisec) {
            switch (i) {
                case 0:
                    try {
                        sleep(a);
                        System.out.println(lyricMap.get(timeMap.get(millMap.get(a))));
                        i++;
                        temp=a;
                    } catch (Exception e) {
                    }
                    break;
                default:
                    try{sleep(a-temp);
                        System.out.println(lyricMap.get(timeMap.get(millMap.get(a))));
                    temp=a;
                    i++;}catch (Exception e){}
                    break;
            }
        }
    }
}
