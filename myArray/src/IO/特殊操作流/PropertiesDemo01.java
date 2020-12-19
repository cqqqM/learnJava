package IO.特殊操作流;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * Properties：
 *     是一个map体系的集合类，可以保存到流中或从流中加载
 *     可以作为Map集合使用，其中的KV类型都是Object
 *
 *     特有方法：
 *         Object setProperty(String key, String value) 设置集合的KV，底层是HashTable的方法put()
 *         String getProperty(String key)
 *         Set<String> stringPropertyNames()  从该属性列表中返回一个不可修改的键集，KV都是字符串
 *
 *     Properties与IO流结合的方法
 *         void load(InputStream in)  从字节流读取
 *         void load(Reader reader)   从字节流读取
 *         void store(OutputStream out，String comments)  通过字节流写入Properties表
 *         void store(Writer writer, String comments)  通过字符流写入Properties表，第二个参数是描述
 *
 *
 */
public class PropertiesDemo01 {
    public static void main(String[] args) throws IOException {
        //创建Properties集合对象
        Properties prop = new Properties();
        System.out.println(prop); //{}

        //存储元素
        prop.put("mcq","001");
        prop.put("mtj","002");
        prop.put("lx","003");
        prop.setProperty("马春琦","005");
        prop.setProperty("木听讲","006");
        prop.setProperty("陆逊","007");
        //获取元素
        System.out.println(prop);
        System.out.println(prop.getProperty("陆逊"));

        //键的集合
        Set<Object> keySet = prop.keySet();
        Set<String> names = prop.stringPropertyNames();
        System.out.println(keySet.equals(names));


        mystore();

        myload();

    }

    /**
     * 把集合中的数据保存到文件
     */
    private static void mystore() throws IOException {
        Properties prop = new Properties();
        prop.setProperty("马春琦","005");
        prop.setProperty("木听讲","006");
        prop.setProperty("陆逊","007");

        //void store(Writer writer, String comments)
        FileWriter fw = new FileWriter("myArray\\src\\IO\\特殊操作流\\propFw.txt");
        prop.store(fw,null);
        fw.close();
    }

    /**
     * 把文件中的数据加载到集合
     */
    private static void myload() throws IOException {
        Properties prop = new Properties();
        FileReader fr = new FileReader("myArray\\src\\IO\\特殊操作流\\propFw.txt");

        //void load(Reader reader)   从字节流读取
        prop.load(fr);
        System.out.println(prop);
        fr.close();
    }
}
