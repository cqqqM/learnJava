package Stream流;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Actor {
    private String name;

    public Actor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/*********************************/
    public static void main(String[] args) {
        ArrayList<String> actor = new ArrayList<>();
        actor.add("周润发");
        actor.add("成龙");
        actor.add("刘德华");
        actor.add("吴京");
        actor.add("周星驰");
        actor.add("李连杰");

        ArrayList<String> actress = new ArrayList<>();
        actress.add("林心如");
        actress.add("张曼玉");
        actress.add("林青霞");
        actress.add("柳岩");
        actress.add("林志玲");
        actress.add("王祖贤");

        //男演员 名字3个字 前三人
        Stream<String> manStream = actor.stream().filter(s -> s.length() == 3).limit(3);
        //女演员 林姓  不要第一人
        Stream<String> womanStream = actress.stream().filter(s -> s.startsWith("林")).skip(1);
        //合并两个流
        Stream<String> stream = Stream.concat(manStream, womanStream);
        //按流中元素构造actor类对象，遍历
//        stream.map(Actor::new).forEach(System.out::println);
        stream.map(Actor::new).forEach(p -> System.out.println(p.getName()));

    }
}
