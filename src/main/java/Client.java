import typeinfo.Candy;
import typeinfo.Cookie;

/**
 * Created by qiyei2015 on 2016/10/24.
 */
public class Client {

    private static int a = 10;
    public static int a1 = 2;
    protected static int a3 = 4;
    private int b = 1;
    public int c = 2;
    protected int d = 3;

    public static void main(String[] args){
       test_14_1();


    }

    /**
     * 类型信息 14章 P557
     */
    private static void test_14_1(){
        System.out.println("inside main");
        new Candy();
        System.out.println("after creating Candy");

        try {
            Class.forName("typeinfo.Gum");//需要指定包名
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("after class for name Gum");
        new Cookie();
    }

}
