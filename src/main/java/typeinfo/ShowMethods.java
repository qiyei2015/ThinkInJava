package typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Created by qiyei2015 on 2016/10/29.
 */
public class ShowMethods {

    private static Pattern pattern = Pattern.compile("\\w+\\.");//匹配所有的xx.形式,主要是为了去掉包名前缀
    public static void main(String[] args){
//        if (args.length < 1){
//            System.out.println("error ");
//            System.exit(0);
//        }

        int lines = 0;
        try {
            Class<?> c = Class.forName("Client");//获取对应名称的class对象
            Field[] allFields = c.getDeclaredFields();//获取所有声明的变量
            Field[] fields = c.getFields();//获取所有声明的公共变量
            Method[] methods = c.getMethods();//获取所有公共方法
            Method[] allMethods = c.getDeclaredMethods();//获取该类及接口的所有方法，不包含父类
            Constructor[] constructors = c.getConstructors();

            for (Field item : fields){
                //System.out.println(pattern.matcher(item.toString()).replaceAll(""));
                System.out.println(item.toString());
            }

            for (Method item : methods){
                System.out.println(pattern.matcher(item.toString()).replaceAll(""));
            }

//            for (Method item : allMethods){
//                System.out.println(pattern.matcher(item.toString()).replaceAll(""));
//            }

            for (Constructor item : constructors){
                System.out.println(pattern.matcher(item.toString()).replaceAll(""));
            }

            if (args.length == 1){

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
