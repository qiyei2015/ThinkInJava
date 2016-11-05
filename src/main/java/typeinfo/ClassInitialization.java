package typeinfo;

import util.Util;

import java.util.Random;

/**
 * Created by qiyei2015 on 2016/10/26.
 */
public class ClassInitialization {
    public static Random random = new Random(47);

    public static void main(String[] args){
        Class initable = Initable.class;
        Util.println("atfer creat Initable ref");
        Util.println(Initable.staticFinal);
        Util.println(Initable.staticFinal2);
        Util.println(Initable2.staticFinal);
        try {
            Class initable3 = Class.forName("typeinfo.Initable3");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Util.println("after create Initable3 ref");
        Util.println(Initable3.staticFinal);

        testFilledList();
        testGenericToy();

    }

    private static void testFilledList(){
        FilledList<CountedInteger> f1 = new FilledList<CountedInteger>(CountedInteger.class);
        Util.println(f1.create(20));
    }

    private static void testGenericToy(){
        Class<FancyToy> ftClass = FancyToy.class;
        try {
            FancyToy fancyToy = ftClass.newInstance();
            Class<? super FancyToy> up = ftClass.getSuperclass();//只允许声明称Class<? super FancyToy>,不允许声明称Class<Toy>
            System.out.println(up.getSimpleName());
            //Toy toy = up.newInstance();//返回类型不正确,
            Object obj = up.newInstance();//只能用Object去接收了
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}

class Initable{
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.random.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2{
    static final int staticFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3{
    static final int staticFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }

}
