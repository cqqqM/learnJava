package OOP;

/*
 * 学生测试类
 */
public class StudentTest {
    public static void main(String[] args) {
        Student s = new Student("小明");
        System.out.println(s); //OOP.Student@4554617c

        s.setAge(30);
        //s.setName("mcq");

        s.show();
    }
}
