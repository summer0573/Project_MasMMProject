package MasProject1;

import java.sql.SQLException;

public class test2 {
    int T2;
    int T3 = 5;
    public  test2(){
        test T = new test();
        T.setT(T3);
        T2 = T.getT();

    }
    public static void main(String[] args) {
        new test2();
    }
}
