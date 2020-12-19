package OOP.OOPStandard;

/*
 * student标准类的测试
 */
public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student(); //使用无参构造方法创建对象
        s1.setName("mcq");
        s1.setAge(24);
        s1.show();

        Student s2 = new Student("小明",30);
        s2.show();

    }
}
