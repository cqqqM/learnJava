package 反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 反射可以实现一些正常情况下无法完成的事情
 *     - 访问私有成员
 *     - 越过泛型检查
 */
public class Demo02 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /**
         * 越过泛型检查: 在Integer数组中添加String
         */
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(20);

        //通过反射拿到add方法,在其中添加String对象
        Class<? extends ArrayList> aClass = arr.getClass();
        Method m = aClass.getMethod("add", Object.class);
        m.invoke(arr,"hello!?"); //[10, 20, hello!?]
        System.out.println(arr);
    }
}
