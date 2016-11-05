package annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by qiyei2015 on 2016/11/4.
 */
public class UseCaseTracker {

    public static void trackUseCases(List<Integer> useCases , Class<?> cl){
        for (Method m : cl.getDeclaredMethods()){
            if (m != null){
                UseCase u = m.getDeclaredAnnotation(UseCase.class);
                if (u != null){
                    System.out.println("usecase id:" + u.id() + ",description:" + u.description());
                    useCases.remove(new Integer(u.id()));
                }
            }
        }
    }

    public static void main(String[] args){
        List<Integer> us = new ArrayList<>();
        Collections.addAll(us,47,48,49,50);
        trackUseCases(us,PasswordUtils.class);
    }
}
