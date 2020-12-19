package Lambda表达式;

/**
 * 抽象方法带参带返回值
 */
public class AddableDemo {
    public static void main(String[] args) {
        //匿名内部类写法
        useAddable(new Addable() {
            @Override
            public int add(int x, int y) {
                return x + y;
            }
        });

        //Lambda函数写法
        useAddable((int x, int y) -> {
            return x + y;
        });

        //Lambda函数的省略写法:
        // 参数的类型可以省略，但是有多个参数的情况下不能只省略一个
        // 如果参数只有一个，形参小括号可以省略
        // 如果代码块只有一条语句，return、大括号和封号可以省略
        useAddable((x, y) -> x + y);
    }

    private static void useAddable(Addable a) {
        int res = a.add(10,20);
        System.out.println(res);
    }
}
