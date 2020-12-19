package 集合.Generics;

/**
 * 泛型接口
 *
 * 定义格式: public interface Generic<T> {}
 */
public interface GenericInterface<T> {
    void show(T t); //使用时需要实现类

    //定义一个内部类 作为实现类
    public class GenricImpl<T> implements GenericInterface<T>{
        @Override
        public void show(T t) {
            System.out.println(t);
        }
    }


/***************************************************************/
//    接口类型无法用main函数测试！

//    public static void main(String[] args) {
//        GenricImpl g1 = new GenricImpl();
//        g1.show("hello world!");
//        g1.show(10);
//    }
}
