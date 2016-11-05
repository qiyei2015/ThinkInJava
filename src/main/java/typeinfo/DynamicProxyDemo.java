package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by qiyei2015 on 2016/10/29.
 */
public class DynamicProxyDemo {

    public static void main(String[] args){
        //    我们要代理的真实对象
        RealObject real = new RealObject();
        consumer(real);
        // 我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxyHandler(real);

        //这里是动态代理
        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象。这里必须使用已经加载进来的类的加载器
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        Class<?>[] classes = real.getClass().getInterfaces();
        //Class<?>[] classes = new Class[]{Interface.class};//这样写也可以

        Interface proxy = (Interface) Proxy.newProxyInstance(handler.getClass().getClassLoader()
                ,classes,handler);
        consumer(proxy);
    }

    private static void consumer(Interface face){
        face.doSomething();
        face.somethingElse("hello");
    }
}
