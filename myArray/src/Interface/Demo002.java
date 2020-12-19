package Interface;

public interface Demo002 {
    //默认方法
    default void show1() {
        System.out.println("show1:");
        show();
        System.out.println("show1结束执行");
    }

    default void show2() {
        System.out.println("show2:");
        show();
        System.out.println("show2结束执行");
    }

    //私有方法，可以静态可以非静态
     static void show() {
        System.out.println("初级工程师");
        System.out.println("中级工程师");
        System.out.println("高级工程师");

    }

    //静态方法，不能调用非静态方法
    static void method1() {
        System.out.println("mehtod1:");
        System.out.println("初级工程师");
        System.out.println("中级工程师");
        System.out.println("高级工程师");
        System.out.println("method1结束执行");
    }

    static void method2() {
        System.out.println("method2:");
        System.out.println("初级工程师");
        System.out.println("中级工程师");
        System.out.println("高级工程师");
        System.out.println("method2结束执行");
    }


}
