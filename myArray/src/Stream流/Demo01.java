package Stream流;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream流一般与lambda表达式一起使用
 *
 * stream流的使用：
 *     生成操作
 *         通过数据源（集合、数组等）生成流
 *         生成方式：
 *             - Collection体系的集合可以使用.stream()方法生成流    default Stream<E> stream()
 *             - Map体系的集合间接生成流
 *             - 数组可以通过Stream接口的静态方法生成流 of(T... values)
 *
 *     中间操作
 *          一个流后面可以跟随0个或多个中间操作，做出某种数据过滤/映射，然后返回新的流，交给下一个操作使用
 *          常见方法：
 *              - Stream<T> filter(Predicate predicate) 用于对流中的中间数据过滤。
 *                  predicate接口中的test方法对给定参数进行判断，返回Boolean
 *              - Stream<T> limit(long maxSize) 截取流中前maxSize个数据，返回新的流
 *              - Stream<T> skip(long n)  跳过前n个数据，返回剩余元素的流
 *              - static<T> Stream<T> concat(Stream a, Stream b) 合并ab为同一个流
 *              - Stream<T> distinct()  返回由该流的不同元素（根据Object.equals(Object)）组成的流
 *              - Stream<T> sorted()  返回该流自然排序组成的流
 *              - Stream<T> sorted(Comparator comparator)  返回该流根据比较器排序的流
 *              - <R> Stream<R> map(Function mapper) 返回mapper函数应用于流中元素的结果组成的流
 *                  Function接口中的apply方法： R apply（T t） 接收T类型的参数，返回R类型的结果
 *              - IntStream mapToInt(ToIntFunction mapper)  返回mapper函数应用于流中元素的结果组成的IntStream
 *                  ToIntFunction接口中的applyAsInt方法：
 *                  int applyAsInt(T value) 接收T类型的参数，返回int类型的结果
 *                  IntStream中包含一些特殊方法，如int sum()
 *
 *     终结操作
 *         一个流只能有一个终结操作，执行后这个流就无法再被操作了
 *         常见操作：
 *             void forEach(Consumer action)  对该流的每一个元素执行操作
 *             long count()  返回此流中的元素个数
 *
 *     收集操作
 *         Stream流中的操作完成后，收集到集合中
 *         收集方法
 *             R collect(Collector collector)
 *             Collector是一个接口，Collectors工具类提供了收集方式
 *                 Collectors.toList()
 *                 Collectors.toSet()
 *                 Collectors.toMap(Function keyMapper, Function valueMapper)  两个lambda表达式，一个对键操作，一个对值操作
 *
 */
public class Demo01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("马春琦");
        list.add("张永凯");
        list.add("马学与");
        list.add("穆亭江");
        list.add("陆逊");
        list.add("张开元");
        list.add("张夕");
//        //把以张开头的元素存储到另一个集合
//        ArrayList<String> zhangList = new ArrayList<>();
//        for(String s : list) {
//            if(s.startsWith("张")) {
//                zhangList.add(s);
//            }
//        }
//        System.out.println(zhangList);

        //Stream流的方式 stream--filter--filter--foreach
//        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length()==3).forEach(System.out::println);

        /**
         * 流生成
         *  Collection体系的集合可以使用.stream()方法生成流    default Stream<E> stream()
         *  Map体系的集合间接生成流
         *  数组可以通过Stream接口的静态方法生成流 of(T... values)
         */
        List<String> list1 = new ArrayList<>();
        Stream<String> listStream = list1.stream();

        Set<String> set1 = new HashSet<>();
        Stream<String> setStream = set1.stream();

        Map<String, Integer> map1 = new HashMap<>();
        Stream<String> keyStream = map1.keySet().stream(); //键对应的流
        Stream<Integer> valueStream = map1.values().stream(); //值对应的流
        Stream<Map.Entry<String, Integer>> entryStream = map1.entrySet().stream(); //键值对对象对应的流

        String[] strArray = {"马春琦，23","张永凯，30","穆听讲，18"};
        Stream<String> strArrayStream = Stream.of(strArray);
        Stream.of(10,20,30);

        /**
         * 流中间操作方法 filter  limit  skip  concat  distinct  sorted  map  mapToInt
         */
        System.out.println("\n中间操作----------");
        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length()==3).forEach(System.out::println);
        list.stream().skip(3).limit(3).forEach(System.out::println);

        Stream<String> s1 = list.stream().limit(4);
        Stream<String> s2 = list.stream().skip(2);
        Stream.concat(s1,s2).distinct().forEach(s -> System.out.print(s + ","));

        list1.add("10");
        list1.add("20");
        list1.add("30");
        list1.add("40");
        list1.add("50");
        list1.add("60");
        list1.add("70");
        list1.stream().map(Integer::parseInt).forEach(System.out::println);

        /**
         * 终结操作 foreach  count
         */
        System.out.println("\n终结操作----------");
        System.out.println(list1.stream().mapToInt(Integer::parseInt).sum());
        System.out.println(list1.stream().count());

        /**
         * 收集操作 collect
         */
        System.out.println("\n收集操作----------");
        List<String> names = list.stream().collect(Collectors.toList());
        System.out.println(names);

        Set<Integer> set = list1.stream().map(Integer::parseInt).collect(Collectors.toSet());
        System.out.println(set);

        Stream<String> arrStream = Stream.of(strArray).filter(s -> Integer.parseInt(s.split("，")[1]) > 20);
        Map<String, Integer> map = arrStream.collect(Collectors.toMap(s -> s.split("，")[0],  //键
                s -> Integer.parseInt(s.split("，")[1])));//值
        System.out.println(map);


    }
}
