package main;

import main.philosopher.*;

import java.util.*;

/**
 * Created by 张巍 on 2016/11/7.
 */
public class main {
    public static final Philosopher[] GG = {
            new GPhilosopher(),
            new WowPhilosopher(),
            new IamPhilosopher(),
            new WtPhilosopher(),
            new SeriouslyPhilosopher(),
    };


    public static void main(String[] args) {
        Servant G=new Servant(GG);
        G.start(1);
    }
}