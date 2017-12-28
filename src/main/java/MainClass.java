import time.TestOrigin;
import time.TestTime;

/**
 * Created by hzlaojiaqi on 2017/12/14.
 */
public class MainClass {


    static {
        System.out.println(">>>init");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(">>>main start");

        int num = new TestClass1().getNum();
        System.out.println(">>>1.getNum="+num);

        Thread.sleep(1000);
        AgentMain.initialize();

        TestOrigin testOrigin=new TestOrigin();
        testOrigin.m();

//        int num2 = new TestClass1().getNum();
//        System.out.println(">>>2.getNum="+num2);
    }
}
