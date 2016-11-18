package player;
import player.Threads.*;

import java.util.List;

/**
 * Created by 张巍 on 2016/11/18.
 */
public class Tester {
    public static void main(String[] args) {
        String []GG={"V:\\Java Projects\\lifeline1\\5thClass\\res\\洛天依 - 一半一半.lrc"};
        Lyric m=new Lyric(GG);
        m.run();
    }
}
