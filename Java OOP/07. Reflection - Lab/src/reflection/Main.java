package reflection;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> reflection = Reflection.class;

        Class<?> superclass = reflection.getSuperclass();

        System.out.println(reflection);
        System.out.println(superclass);

        Arrays.stream(reflection.getInterfaces())
                .forEach(System.out::println);


//        Also works
//        try{
//            Object reflectionObject = reflection.getDeclaredConstructor().newInstance();
//            System.out.println(reflectionObject);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        try{
            Constructor<Reflection> ctor = reflection.getDeclaredConstructor();
            Reflection reflectionObject = ctor.newInstance();

            System.out.println(reflectionObject);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
