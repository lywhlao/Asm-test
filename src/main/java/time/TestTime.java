package time;

/**
 * Created by hzlaojiaqi on 2017/12/27.
 */
public class TestTime {
    public static long timer;

    public void m() throws InterruptedException {
        timer -= System.currentTimeMillis();
        Thread.sleep(100);
        timer += System.currentTimeMillis();
        System.out.println(timer);
    }
}
