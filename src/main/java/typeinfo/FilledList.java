package typeinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiyei2015 on 2016/10/28.
 */
public class FilledList<T> {
    private Class<T> type;

    public FilledList(Class<T> type){
        this.type = type;
    }

    public List<T> create(int num){
        List<T> list = new ArrayList<T>();

        for (int i = 0; i < num; i++){
            try {
                list.add(type.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}

class CountedInteger{
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }
}