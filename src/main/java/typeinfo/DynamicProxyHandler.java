package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by qiyei2015 on 2016/10/29.
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;//这个就是我们要代理的真实对象

    //    构造方法，给我们要代理的真实对象赋初值
    public DynamicProxyHandler(Object o){
        this.proxied = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //　　在代理真实对象前我们可以添加一些自己的操作
        System.out.println("***proxy:" + proxy.getClass() + ", method:" + method + ",args:" + args);

        if (args != null){
            for (Object a : args){
                System.out.println("arg:" + a);
            }
        }
        //    当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        return method.invoke(proxied,args);
    }
}
