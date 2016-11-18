package main.philosopher;

import main.*;

/**
 * Created by 张巍 on 2016/11/7.
 */
public class GPhilosopher implements Philosopher {
    private static boolean hunger = false;
    private int index;
    private String name;

    public GPhilosopher() {
        name = "GPhilosopher";
    }
    @Override
    public String getName(){return name;}

    public void setIndex(int in) {
        this.index = in;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public boolean ifHunger() {
        if (!hunger) {
            int i = (int) Math.floor(2 * Math.random());
            switch (i) {
                case 0:
                    hunger = false;
                    break;
                case 1:
                    hunger = true;
                    break;
                default:
                    break;
            }
        }
        return hunger;
    }

}

