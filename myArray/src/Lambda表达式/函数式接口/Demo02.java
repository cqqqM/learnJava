package Lambda表达式.函数式接口;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 常用的函数式接口 jdk8 util.function
 *     -Supplier 生产型接口
 *         Supplier<T> 包含一个无参方法
 *              T get() 获得结果
 *         如果指定了接口的泛型类型，那么接口中的get方法就会生产一个指定类型的数据
 *
 *     -Consumer 消费型接口
 *         Consumer<T>包含两个方法
 *             void accept(T t) 对给定的参数执行此操作
 *             default Consumer<T> andThen(Consume after)  返回一个组合的Consumer，以此执行此操作，然后执行after操作
 *
 *     -Predicate接口  通常用于判断参数是否满足指定条件
 *         Predicate<T> 常用4个方法
 *             boolean teat(T t) 对给定的参数进行判断（具体由lambda实现），返回一个boolean
 *             default Predicate<T> negate()  返回一个逻辑的否定
 *             default Predicate<T> and(Predicate other)  返回一个逻辑的否定
 *             default Predicate<T> or(Predicate other)  返回一个逻辑的否定
 *
 *     -Function接口   通常用于对参数进行处理，转换（T->R,具体逻辑由lambda实现），然后返回一个新的值
 *         Function<T, R> 两个常用方法
 *             R apply<T, R>  将此函数应用于给定的参数，接收T类型的参数，返回R类型的结果
 *             default<V> Function andThen(Functiong after)  返回一个组合函数，首先将该函数应用于输入，然后将after函数应用于结果
 *
 */
public class Demo02 {
    public static void main(String[] args) {
        //通过supllier接口产生一个字符串数据，接收
        String s = getString(() -> "马春琦1");
        System.out.println(s);

        //消费一个字符串数据
        operatorString("马春琦2",ss -> System.out.println(ss));
//        operatorString("马春琦2",System.out::println);//方法引用也可以
        operatorString("马春琦2",sss -> System.out.println(sss), sss -> System.out.println(new StringBuilder(sss).reverse().toString()));

        //参数判断
        boolean b1 = checkString("hello", ssss -> ssss.length() > 8);
        System.out.println(b1);
        boolean b2 = checkString("hello", ssss -> ssss.length() > 8, ssss -> ssss.length() < 10);
        System.out.println(b2);

        //字符串转换
        convet("100", s5 -> Integer.parseInt(s5));
        convet(100, i -> String.valueOf(i + 566));
        convet("100",s5 -> Integer.parseInt(s5), i -> String.valueOf(i+566));

    }

    //通过supplier接口产生一个字符串数据
    private static String getString(Supplier<String> sup) {
        return sup.get();//具体的实现动作由lambda表达式完成
    }

    //通过Consumer接口消费一个字符串数据
    private static void operatorString(String name, Consumer<String> con) {
        con.accept(name);//具体的实现动作由lambda表达式完成
    }
    //通过Consumer接口，用不同方式消费同一个字符串两两次
    private static void operatorString(String name, Consumer<String> con1, Consumer<String> con2) {
//        con1.accept(name);
//        con2.accept(name);
        con1.andThen(con2).accept(name);
    }

    //通过predicat接口，判断给定字符串是否满足要求
    private static boolean checkString(String s, Predicate<String> pre) {
        return pre.test(s);
//        return pre.negate(s); // !test
    }
    //通过predicat接口，判断给定字符串是否不同条件满足要求，并对两个结果做逻辑运算
    private static boolean checkString(String s, Predicate<String> pre1, Predicate<String> pre2) {
//        boolean b1 = pre1.test(s);
//        boolean b2 = pre2.test(s);
//        boolean b = b1 && b2;
//        return b;
//        return pre1.and(pre2).test(s);
        return pre1.or(pre2).test(s);
    }

    //通过Function接口，把字符串转换成int型并打印
    private static void convet(String s , Function<String,Integer> fun) {
        int i = fun.apply(s);
        System.out.println(i);
    }
    ////通过Function接口，把int类型加上一个整数，并打印
    private static void convet(int i , Function<Integer,String> fun) {
        String s = fun.apply(i);
        System.out.println(s);
    }
    //通过Function接口，把字符串转换成int型，再加上一个整数，并打印
    private static void convet(String s, Function<String, Integer> fun1, Function<Integer, String> fun2) {
//        Integer i = fun1.apply(s);
//        String ss = fun2.apply(i);
//        System.out.println(ss);
        fun1.andThen(fun2).apply(s);
    }


}
