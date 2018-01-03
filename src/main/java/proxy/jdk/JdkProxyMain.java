package proxy.jdk;

import proxy.service.CarDrive;
import proxy.service.Car;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * jdk动态代理
 * Created by hzlaojiaqi on 2018/1/3.
 */
public class JdkProxyMain {


    public static void main(String[] args) {
        Car car=new Car();
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        CarDrive carProxy = (CarDrive)Proxy.newProxyInstance(contextClassLoader, car.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("begin invoke method");
                method.invoke(car,args);
                System.out.println("end invoke method");
                System.out.println("================");
                return null;
            }
        });

        for (int i = 0; i < 10; i++) {
            carProxy.doSomething(i+"");
        }
    }
}
