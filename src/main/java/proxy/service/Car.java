package proxy.service;

/**
 * Created by hzlaojiaqi on 2018/1/3.
 */
public class Car implements CarDrive {

    @Override
    public void doSomething(String values) {
        System.out.println("this is car values:"+values);
    }

    public void doNothing(String values){
        System.out.println("this is car do nothing:"+values);
    }
}
