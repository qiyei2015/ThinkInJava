package typeinfo;

/**
 * Created by qiyei2015 on 2016/10/29.
 */
public class RealObject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String args) {
        System.out.println("somethingElse:" + args);
    }
}
