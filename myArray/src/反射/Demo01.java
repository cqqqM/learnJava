package 反射;

import OOP.OOPStandard.Student;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Java反射机制：（通过类对象获取类的信息）
 *     指在运行时去获取一个类的变量和方法信息，然后通过该信息创建对象、调用方法的一种机制
 *
 *     首先获取到该类的字节码文件对象，三种方式获取：
 *         使用类的class属性获取对应的class对象。 Student.class
 *         调用对象的.getClass()方法
 *         使用Class类中静态方法forName(String className)，参数是某个类的全路径
 *
 *     反射获取构造方法Constructor
 *         获取构造器:
 *             Constructor<?>[] getConstructors()  返回由该class对象表示的类 的public构造函数数组
 *             Constructor<?>[] getDeclaredConstructors()  返回由该class对象表示的类 的全部构造函数数组
 *             Constructor<T> getConstructor(Class<?>... paramTypes)  返回由该class对象表示的类 的指定参数类型的public构造函数
 *             Constructor<T> getDeclaredConstructor(Class<?>... paramTypes)  返回由该class对象表示的类 的指定参数类型的所有构造函数
 *
 *         使用构造器: Constructor<T>
 *             T con.newInstance(Object... initArgs) 创建一个实例
 *             对私有的构造器无法正常从外部创建对象,可以使用暴力反射: public void setAccessible(boolean flag) 为true时取消访问检查
 *
 *     反射获取成员变量 Field
 *         获取字段
 *             Field[] getFields() 返回class对象类 所有public字段数组
 *             Field[] getDeclaredFields() 返回class对象类 所有字段数组
 *             Field getField(String name) 返回class对象类 指定public字段
 *             Field getDeclaredField(String name) 返回class对象类 指定字段
 *
 *         通过class对象使用字段
 *             void set(Object,object, Object value
 *             void setAccessible(Boolean flag)  取消访问检查
 *
 *     反射获取成员方法 Method
 *         获取成员方法,包括父类的方法:
 *             getMethods()
 *             getDeclaredMethods()
 *             getMethod(String funcName, Class<?>... args) 根据方法名和参数类型获取指定方法
 *             getDeclaredMethod(String funcName, Class<?>... args)
 *
 *         通过class对象使用method
 *             Object invoke(Object obj, Object args)
 *
 *
 */
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        /**
         * 获取class对象（类的字节码对象
         */
        //1.类的class属性
        Class<Student> c1 = Student.class;
        System.out.println(c1); //class OOP.OOPStandard.Student
        //2.对象的.getClass()方法
        Student s = new Student();
        Class<? extends Student> c2 = s.getClass();
        System.out.println(c2); //class OOP.OOPStandard.Student
        //3.Class类中静态方法forName(String className)
        Class<?> c3 = Class.forName("OOP.OOPStandard.Student");
        System.out.println(c3); //class OOP.OOPStandard.Student

        /**
         * 反射获取构造方法并使用: 获取到的构造器可以拿来创建新的对象
         * 获取构造器:
         *     Constructor<?>[] getConstructors()  返回由该class对象表示的类 的public构造函数数组
         *     Constructor<?>[] getDeclaredConstructors()  返回由该class对象表示的类 的全部构造函数数组
         *     Constructor<T> getConstructor(Class<?>... paramTypes)  返回由该class对象表示的类 的指定参数类型的public构造函数
         *     Constructor<T> getDeclaredConstructor(Class<?>... paramTypes)  返回由该class对象表示的类 的指定参数类型的所有构造函数
         *
         * 使用构造器: Constructor<T>
         *     T con.newInstance(Object... initArgs) 创建一个实例
         *     对私有的构造器无法正常从外部创建对象,可以使用暴力反射: public void setAccessible(boolean flag) 为true时取消访问检查
         */
        System.out.println("-------------------\nConstructors:");
//        Constructor<?>[] cons = c3.getConstructors(); //public构造器
        Constructor<?>[] cons = c3.getDeclaredConstructors();
        for(Constructor con : cons) {
            System.out.println(con);
        }

//        Constructor<?> con = c3.getConstructor(); //public构造器
        Constructor<?> con = c3.getDeclaredConstructor(String.class, int.class);

        //使用反射来的构造器 con.newInstance();
        Object obj = con.newInstance("马春琦",23);
        System.out.println(obj); //Student{name=null,age=0}  默认的对象内容

        /**
         * 反射获取成员变量并使用
         *     Field[] getFields() 返回class对象类 所有public字段数组
         *     Field[] getDeclaredFields() 返回class对象类 所有字段数组
         *     Field getField(String name) 返回class对象类 指定public字段
         *     Field getDeclaredField(String name) 返回class对象类 指定字段
         *
         * 使用字段
         *     void set(Object,object, Object value
         *     void setAccessible(Boolean flag)  取消访问检查
         */
        System.out.println("-------------------\nFields:");
//        Field[] fields = c3.getFields(); //public字段
        Field[] fields = c3.getDeclaredFields();
        for(Field field : fields) {
            System.out.println(field);
        }

        //Field field = c3.getField("name"); //public字段
        Field field = c3.getDeclaredField("name");
        System.out.println(field); //private java.lang.String OOP.OOPStandard.Student.name

        //使用反射来的字段
        //field.set(Obj, Value)
        field.setAccessible(true); // 取消private变量访问检查
        field.set(obj,"张永凯");
        System.out.println(obj);


        /**
         * 反射获取成员方法 Method
         *     获取成员方法,包括父类的方法:
         *         getMethods()
         *         getDeclaredMethods()
         *         getMethod(String funcName, Class<?>... args) 根据方法名和参数类型获取指定方法
         *         getDeclaredMethod(String funcName, Class<?>... args)
         *
         *     使用
         *         Object invoke(Object obj, Object args)
         */
        System.out.println("-------------------\nMethods:");
//        Method[] methods = c3.getMethods();
        Method[] methods = c3.getDeclaredMethods();
        for(Method method : methods) {
            System.out.println(method);
        }

//        Method method = c3.getMethod("show");
        Method method = c3.getDeclaredMethod("setAge", int.class);
        System.out.println(method);

        //使用反射来的方法
//        method.setAccessible(true); //取消public检查
        Object invoke = method.invoke(obj,60);
        method = c3.getDeclaredMethod("show");
        method.invoke(obj);


    }
}
