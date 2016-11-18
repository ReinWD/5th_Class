package main;

import java.util.*;
import main.philosopher.*;
import main.main;

/**
 * Created by 张巍 on 2016/11/7.
 */
public class Servant {
    private List<Philosopher> aPhilosophers;
    private Map<Philosopher, Boolean> Hunger=
            new HashMap<Philosopher, Boolean>();
    private List<Chopstick> chopsticks = new ArrayList<Chopstick>();
    private Map<Chopstick, Boolean> chopExistance =
            new HashMap<Chopstick, Boolean>();
    private Stack<Philosopher> hungryList=new Stack<>();

    public Servant(Philosopher[] Philosopher) {
        this.aPhilosophers = Arrays.asList(Philosopher);//把哲♂学家们放在列表里
        setChopSticks(5);int i=0;
        for (Philosopher Philosophers : aPhilosophers) {
            Philosophers.setIndex(i);
            i++;
            System.out.println();
        }//给哲♂学家编号
    }

    void start(int times){
        for (int i = 0; i < times; i++) {
            dinnerTime();//午时（划掉）晚餐时间到
            order();
            for (;!hungryList.isEmpty();) {
                takeChops(hungryList.pop());
            }
        }
    }

    private void setChopSticks(int quantity) {
        for (int i = 0; i < quantity; i++) {
            chopsticks.add(new Chopstick(i));
        }
        for (Chopstick chopstick : chopsticks) {
            chopExistance.put(chopstick, chopstick.getTaken());
        }//初始化筷子
    }

    private void order() {

    }

    private void dinnerTime() {
        for (Philosopher Philosophers : aPhilosophers) {
            Hunger.put(Philosophers, Philosophers.ifHunger());
            if (Hunger.get(Philosophers)) {
                hungryList.add(Philosophers);
            }
        }//将饿了的放在列表里
    }//询问哲学家们饿不饿

    private void takeChops(Philosopher p) {
        int left = p.getIndex() - 1, right = p.getIndex() + 1;
        if(left==-1)left=chopsticks.size()-1;
        if(right==chopsticks.size())right=0;
        chopsticks.get(left).take();
        chopsticks.get(right).take();
    }
}
