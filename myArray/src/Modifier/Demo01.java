package Modifier;

import jicheng.Jicheng02.Teacher;

/*
  导包

  包package 对类文件进行分类管理，多级package用.分开

  带包类的编译方式（自动建包）
        编译: javac -d HelloWorld.java
        运行：java [包名].HelloWorld
 */
public class Demo01 {
    public static void main(String[] args) {

        //调用其他包中的类
        jicheng.Jicheng02.Teacher t1 = new jicheng.Jicheng02.Teacher();
        t1.teach();

        //import导入其他包，直接使用其中的类
        Teacher t2 = new Teacher();
        t2.teach();
    }

}
