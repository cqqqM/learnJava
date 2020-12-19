package 反射;

/**
 * 类加载：
 *     当程序要使用某个类时，如果类没有加载到内存中，JVM会通过三个步骤对类进行初始化
 *     类加载--类连接--类初始化，统称为类加载或类初始化
 *
 *     类加载：
 *         将class文件读入内存，并创建一个java.lang.Class对象
 *         任何类被使用时，都会创建一个java.lang.Class对象
 *
 *     类连接：
 *         验证阶段：检验被加载的类是否有正确的内部结构，并和其他类协调一致
 *         准备阶段：负责为类的变量分配内存，并设置默认初始化值
 *         解析阶段：将类的二进制数据中的符号引用替换为直接引用
 *
 *     类的初始化：主要对类变量进行初始化
 *         1.假如类还未被加载和连接，则程序先加载并连接该类
 *         2.假如类的直接父类还未初始化，则先初始化其直接父类 （遵循1~3，系统会保证类的所有父类都被初始化）
 *         3.假如类中有初始化语句，则系统依次执行这些初始化语句
 *
 *     类的初始化时机
 *         - 创建 类的实例
 *         - 调用 类的类方法（static方法
 *         - 访问或赋值 类或者接口的类变量
 *         - 使用反射方式强制创建某个类或接口对应的java.lang.Class对象
 *         - 初始化某个类的子类
 *         - 直接使用java.exe命令来运行某个主类
 * =====
 * 类加载器  ClassLoader
 *     负责将.class文件加载到内存中，并生成对应的java.lang.Class对象
 *     JVM的类加载机制：全盘负责 / 父类委托 / 缓存机制
 *
 *     Java运行时具有的类加载器：
 *         Bootstrap，虚拟机内置的类加载器，通常表示为null，类加载器的祖宗
 *         Platform，平台类加载器。平台类包括Java SE平台API的实现类，和JDK特定的运行时类
 *         System，系统(应用程序)类加载器。用于定义应用程序类路径，模块路径和JDK特定工具上的类。
 *
 *     ClassLoader中的两个方法：getSystemClassLoader()、getParent()
 *
 */
public class 类加载器 {
    public static void main(String[] args) {
        //系统类加载器
        ClassLoader c = ClassLoader.getSystemClassLoader();
        System.out.println(c); //AppClassLoader

        //父类加载器
        ClassLoader c2 = c.getParent();
        System.out.println(c2); //ExtClassLoader

        System.out.println(c2.getParent()); //null，也就是Bootstrap class loader
    }
}
