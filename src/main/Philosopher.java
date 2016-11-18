package main;

/**
 * Created by 张巍 on 2016/11/7.
 */
public interface Philosopher {

    String getName();

    boolean ifHunger();

    void setIndex(int in);

    int getIndex();
}
