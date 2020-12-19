package IO.特殊操作流;

import OOP.OOPStandard.Student;

import java.io.*;

/**
 * 对象序列化流  ObjectOutputStream
 *     将JAVA对象的原始数据类型和图形写入OutputStream，进行持久化存储。
 *     可以使用ObjectInputStream读取对象
 *
 *     构造方法
 *         ObjectOutputStream(OutputStream out)
 *
 *     对象序列化方法
 *         void writeObject(Object obj) 将指定对象写入ObjectOutputStream
 *
 *     要实例化的类必须实现Serializable接口,否则NotSerializableException 异常。
 *     它只是一个标识接口，并不用实现任何方法。
 *
 * ===
 * 对象反序列化流 ObjectInputStream
 *     构造方法
 *          ObjectInputStream(InputStream in)
 *
 *     对象反序列化方法
 *         Object readObject()  从ObjectInputStream中读取一个对象
 *
 * ====
 * - 如果一个对象已经序列化，此时修改类文件，读取数据会不会出现问题？
 *     java.io.InvalidClassException
 *         类的串行版本与从流中读取的类描述符的类型不匹配
 *         该类包含未知的数据类型
 *         该类没有可访问的无参数构造函数
 *    默认有一个 private static long serialVersionUID 序列化版本号，类的改动会导致UID改动，导致无法反序列化
 *
 * - 如果读取出现问题如何解决？
 *     给这个类添加一个属性  private static long serialVersionUID = 42L;
 *
 * - 如果对象的某个成员变量不希望被序列化，如何实现？
 *     变量添加transient关键字  private transient int age;
 */
public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myArray\\src\\IO\\特殊操作流\\oos.txt"));

        Student s1 = new Student("mcq",20);
        oos.writeObject(s1);
        oos.close();

        /************************************/
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myArray\\src\\IO\\特殊操作流\\oos.txt"));
        Object object = ois.readObject();
        Student student = (Student) object;
        System.out.println(student); //Student.toString
        ois.close();

    }
}
