package main.philosopher;

import main.Philosopher;

/**
 * Created by 张巍 on 2016/11/7.
 */
public class IamPhilosopher implements Philosopher {
    private boolean hunger;
    private int index;
    private String name;

    public IamPhilosopher() {
        name = "IamPhilosopher";
    }
    @Override
    public String getName(){return name;}
    @Override
    public void setIndex(int index) {
        this.index = index;
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
