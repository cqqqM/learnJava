package Lambda表达式.方法引用;

import OOP.OOPStandard.Student;

/**
 * Lambda表达式.方法引用  ::
 *     从Lambda来
 *     所在的表达式称为方法引用，引用已定义的方法
 *
 * 推导与省略
 *     如果使用lambda，“可推导就是可省略”原则，无需指定参数类型，会被自动推导
 *     如果使用方法引用，同样可以根据上下文推导
 *     参数传递：
 *         lambda表达式被 类方法/对象的实例方法/构造器 替代的时候，它的形式参数全部传递给方法作为参数
 *         lambda表达式被 类的实例方法 替代的时候，第一个参数作为调用者，后面的参数传递给该方法作为参数
 *
 * 常见的引用方式
 *     - 引用类方法（类中的静态方法
 *           类名::静态方法  Integer::parseInt
 *
 *     - 引用对象的实例方法（类中的成员方法
 *           对象::成员方法  "HelloWorld"::toUpperCase
 *
 *     - 引用类的实例方法
 *           类名::成员方法  String::toUpperCase
 *
 *     - 引用构造器（引用构造方法
 *           类名::new  Student::new
 *
 */
public class Demo01 {
    public static void main(String[] args) {
        //lambda方法调用
        //拿到参数s后，通过lambda表达式，传递给system.out.println方法处理
        usePrintable(s -> System.out.println(s));

        //Lambda表达式.方法引用
        //直接使用system.out中的println方法来取代lambda
       usePrintable(System.out::println);

       /*******/

       //引用类方法（工具类的静态方法）
        useConverter(Integer::parseInt);

        //引用对象的实例方法

        //引用类的实例方法
        usePrinter(String::toUpperCase);

        //引用构造器
        useStudentBuilder(Student::new);


    }

    private static void usePrintable(Printable p) {
        p.printString("hello,world");
    }

    private static void useConverter(Converter c) {
        int number = c.convert("666");
        System.out.println(number);
    }
    private static void usePrinter(Printer p) {
        String s = p.printUpperCase("HelloWorld");
        System.out.println(s);
    }
    private static void useStudentBuilder(StudentBuilder sb) {
        Student stu = sb.build("mcq", 23); //别忘记接收一下，不然只是一个接口
        System.out.println(stu);
    }
}
