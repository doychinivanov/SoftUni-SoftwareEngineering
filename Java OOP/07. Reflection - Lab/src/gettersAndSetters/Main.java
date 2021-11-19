package gettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private static class MethodComparator implements Comparator<Method> {

        @Override
        public int compare(Method f, Method s) {
            boolean firstIsGetter = f.getName().startsWith("get");
            boolean secondIsGetter = s.getName().startsWith("get");

            if (firstIsGetter && secondIsGetter) {
               return f.getName().compareTo(s.getName());
            }

            boolean firstIsSetter = f.getName().startsWith("set");
            boolean secondIsSetter = s.getName().startsWith("set");

            if(firstIsSetter && secondIsSetter) {
                return f.getName().compareTo(s.getName());
            }

            return Boolean.compare(secondIsGetter, firstIsGetter);
        }
    }

    public static void main(String[] args) {

        Class<Reflection> reflection = Reflection.class;

        Method[] allMethods = reflection.getDeclaredMethods();

        Arrays.stream(allMethods)
                .filter(m -> !m.getName().equals("toString"))
                .sorted(new MethodComparator())
                .forEach(Main::printMethodInfo);
    }

    private static void printMethodInfo(Method method) {
        System.out.println(method.getName().startsWith("get")
                ? String.format("%s will return class %s", method.getName(), method.getReturnType().getSimpleName())
                : String.format("%s and will set field of class %s", method.getName(), method.getParameterTypes()[0].getSimpleName()));
    }
}
