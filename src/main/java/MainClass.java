/**
 * Created by hzlaojiaqi on 2017/12/14.
 */
public class MainClass {


    static {
        System.out.println(">>>init");
//        AgentMain.initialize();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(">>>main start");
        int num = new TestClass1().getNum();
        System.out.println(">>>getNum="+num);
        Thread.sleep(1000);
        AgentMain.initialize();
        int num2 = new TestClass1().getNum();
        System.out.println(">>>getNum="+num2);
    }
}
