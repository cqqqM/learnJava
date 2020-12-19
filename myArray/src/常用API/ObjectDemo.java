package 常用API;

import OOP.OOPStandard.Student;

/*
Object类是类层次结构根，每个类都可以将Object类作为超类。 所有类都直接或间接继承自Object

看方法的源码：选中方法，按 ctrl+B

建议所有子类重写 toString 方法
 */
public class ObjectDemo {
    public static void main(String[] args) {
        /**
         *  看方法的源码：选中方法，按 ctrl+B
         *         public void println(Object x) {
         *             String s = String.valueOf(x);
         *             synchronized (this) {
         *                 print(s);
         *                 newLine();
         *             }
         *         }
         *
         *         public static String valueOf(Object obj) {
         *             return (obj == null) ? "null" : obj.toString();
         *         }
         *
         *      建议所有子类重写 toString 方法
         *         public String toString() {
         *             return getClass().getName() + "@" + Integer.toHexString(hashCode());
         *        }
         */
        Student s = new Student("mcq", 30);
        System.out.println(s); //OOP.OOPStandard.Student@4554617c，重写后Student{name=mcq,age=30}
        System.out.println(s.toString()); //Student{name=mcq,age=30}


        /**
         * public boolean equals(Object obj)指示一些其他对象是否等于此。
         * 重写了Student中的 equals方法
         */
        Student s2 = new Student("mcq", 30);
        System.out.println(s.equals(s2));
    }


}
