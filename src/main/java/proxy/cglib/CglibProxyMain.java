package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import proxy.service.Car;

import java.lang.reflect.Method;

/**
 * Cglib动态代理
 * Created by hzlaojiaqi on 2018/1/3.
 */
public class CglibProxyMain {


    public static void main(String[] args) {
        Car car=new Car();
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(car.getClass());
        MethodInterceptor mi=new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("begin");
                methodProxy.invokeSuper(o,objects);
                System.out.println("end");
                System.out.println("=======");
                return null;
            }
        };
        enhancer.setCallback(mi);
        Car proxyCar = (Car) enhancer.create();
        for (int i = 0; i <5; i++) {
            proxyCar.doNothing(i+"");
        }
    }
}
