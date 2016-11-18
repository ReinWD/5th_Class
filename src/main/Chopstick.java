package main;

/**
 * Created by 张巍 on 2016/11/7.
 */
public class Chopstick  {
    int index=0;
    boolean taken=false;

    public Chopstick(int i) {
        this.setIndex(i);
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    public void take() {
        this.taken = true;
    }

    public void put() {
        this.taken = false;
    }

    public boolean getTaken() {
        return taken;
    }


}