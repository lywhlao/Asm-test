/**
 * Created by hzlaojiaqi on 2017/12/14.
 */
public class MainClass {


    static {
        System.out.println(">>>init");
        AgentMain.initialize();
    }

    public static void main(String[] args) {
        System.out.println(">>>main start");
        int num = new TestClass1().getNum();
        System.out.println(">>>getNum="+num);
    }
}
