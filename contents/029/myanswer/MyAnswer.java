import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.StringBuffer;

public class MyAnswer {
    public static void main(String[]args){
        try {
//            Class<?> clazz = Class.forName("java.lang.StringBuffer");
//            Class<?> clazz = new StringBuffer("").getClass();
            Class<?> clazz = StringBuffer.class;


            Constructor<?> constructor = clazz.getConstructor();
            Object instance = constructor.newInstance();

            Method appendMethod = clazz.getMethod("append", String.class);

            appendMethod.invoke(instance, "Good ");
            appendMethod.invoke(instance, "luck");

            System.out.println(instance.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
