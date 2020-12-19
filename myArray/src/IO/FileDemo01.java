package IO;

import java.io.File;
import java.io.IOException;

/**
 * IO流
 *     流：是一种相对概念，是对数据传输的总称。流的本质是数据传输
 *     IO流：用来处理设备间的数据传输问题：如文件复制/上传/下载
 *
 *     按数据类型分类：
 *         字符流：人能读懂内容的数据
 *         字节流
 *
 *
 * File: 文件 和 目录路径名 的抽象表示
 *
 *     构造方法：
 *         File(String pathname)  给定目录字符串，转换为抽象路径名，来构建File实例
 *         File(String parent, String chile) 通过父路径字符串和子路径字符串，来创建File实例
 *         File(File parent, String child)  通过父抽象路径名和子路径字符串，来创建File实例
 *
 *     创建功能：
 *         public boolean createNewFile() 创建文件，（目录必须存在
 *         public boolean mkdir()  创建目录
 *         public boolean mkdirs()  创建多级目录
 *
 *     判断和获取功能：
 *         public boolean isDirectory()
 *         public boolean isFile()
 *         public boolean exists()
 *         public String getPath()  相对路径
 *         public String getAbsolutePath()
 *         public String getName()   返回此抽象路径名表示的文件或目录的名称（包含在getPath中）
 *         public String[] list()    返回目录中的文件和目录名
 *         public File[] listFiles()  返回目录中的文件和目录的File对象数组
 *
 *     删除功能：
 *         public boolean delete() 删除目录时需要先删除目录中的内容
 *
 *
 */
public class FileDemo01 {
    public static void main(String[] args) throws IOException {
        /**
         * 三种构造方法
         */
//        File f1 = new File("D:\\files\\javaWorks\\learnJava\\javafile.txt");
//        System.out.println(f1); //D:\files\javaWorks\learnJava\javafile.txt
//
//        File f2 = new File("D:\\files\\javaWorks\\learnJava","javafile.txt");
//        System.out.println(f2);
//
//        File f3 = new File("D:\\files\\javaWorks\\learnJava");
//        File f4 = new File(f3,"javafile.txt");
//        System.out.println(f3);
//        System.out.println("-----\n");


        /**
         * 创建文件/目录
         */
//        System.out.println(f1.createNewFile());//需要抛出异常
//
//        File f5 = new File("D:\\files\\javaWorks\\learnJava\\filetest\\demo01");
//        System.out.println(f5.mkdirs());
//
//        File f6 = new File("D:\\files\\javaWorks\\learnJava\\javafile.txt");
//        System.out.println(f6.mkdir());//此时会成功，因为调用的是mkdir方法，会创建一个名为.txt的目录
//        System.out.println("-----\n");


        /**
         * 判断和获取文件/目录
         */
//        System.out.println(f1.exists());
//        System.out.println(f1.isFile());
//        System.out.println(f1.isDirectory());
//
//        System.out.println(f1.getPath()); //D:\files\javaWorks\learnJava\javafile.txt
//        System.out.println(f1.getAbsolutePath()); //D:\files\javaWorks\learnJava\javafile.txt
//        System.out.println(f1.getName()); //javafile.txt
//
//        String[] list = f3.list();
//        for(String s : list){
//            System.out.print(s + ","); //String对象
//        }
//        System.out.println();
//
//        File[] files = f3.listFiles();
//        for(File f : files){ //File对象，还能作判断
//            if(f.isFile()){
//                System.out.println(f.getName());
//            }
//        }
//        System.out.println("-----\n");

        /**
         *  删除功能
         */
//        File f7 = new File("myArray\\src\\IO\\fileDemo.txt");
//        System.out.println(f7.createNewFile());
//        System.out.println(f7.delete());

        /**
         * 递归遍历目录，输出目录下所有的内容
         */
        File f8 = new File(".");
        getAllFilePath(f8);

    }

    //递归遍历方法，输出所有的file文件
    public static void getAllFilePath (File srcFile){
        File[] files = srcFile.listFiles();
        if(files != null) { //健壮性
            for (File f : files) {
                if (f.isDirectory()) {
                    getAllFilePath(f);
                } else {
                    System.out.println(f.getPath());
                }
            }
        }
    }
}
