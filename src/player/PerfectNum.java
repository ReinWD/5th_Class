package player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张巍 on 2016/11/17.
 */
public class PerfectNum {
    public static void main(String[] args) {
        int a=200000,n,sum=0;
        List<Integer>fuck=new ArrayList<>();
        for (n = 6; n <=a ; n++) {
            for (int i = 1; i <=(n/2)+1; i++) {
                if (n % i == 0) sum += i;
            }
            if (sum==n)fuck.add(n);
            sum=0;
        }
        for (int A:fuck) {
            System.out.print(A+",its factors are");
                for (int j = 1; j <A; j++) {
                    if (A % j == 0) System.out.print(j+",");
                }
            System.out.println();
        }
    }
}
