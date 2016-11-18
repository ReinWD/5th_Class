package player.Threads;

import javazoom.jl.player.jlp;

/**
 * Created by 张巍 on 2016/11/16.
 */
public class Music extends Thread {
    String[] aPath = null;

    public Music(String []path) {
        aPath = path;
    }

    public void run() {
        aPath[0]=aPath[0].replace("\\","\\\\");
        jlp.main(aPath);
    }

}
