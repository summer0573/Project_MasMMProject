package test;

import java.sql.SQLException;

//이름 변수에 값을 저장하는 테스트 클래스
public class test1 {

    public static String test;

    public test1() {
        test4 RD1 = new test4();
        RD1.name = "test";
//        RD1.setName("테스트");
    }


    public static void main(String[] args) {
        System.out.println(test);
    }

}
