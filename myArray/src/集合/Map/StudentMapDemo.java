package 集合.Map;

import java.util.HashMap;
import java.util.Set;

public class StudentMapDemo {
    private String name;
    private int age;

    public StudentMapDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentMapDemo that = (StudentMapDemo) o;

        if (age != that.age) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    /****************************************************/
    public static void main(String[] args) {
        HashMap<StudentMapDemo,String> hm = new HashMap<>();
        StudentMapDemo s1 = new StudentMapDemo("mcq",16);
        StudentMapDemo s2 = new StudentMapDemo("wzj",18);
        StudentMapDemo s3 = new StudentMapDemo("zyk",20);
        StudentMapDemo s4 = new StudentMapDemo("zyk",25);

        StudentMapDemo s5 = new StudentMapDemo("mcq",16);

        //学生对象作为key，需要重写学生类的hashCode、equals
        hm.put(s1,"klmy");
        hm.put(s2,"xining");
        hm.put(s3,"xinyang");
        hm.put(s4,"bj");
        hm.put(s5,"bj"); //modify

        System.out.println(hm); //直接打印HashMap对象的方式，看不到引用对象具体内容(如果对象没有重写toString)，最好自行遍历查看

        Set<StudentMapDemo> keySet = hm.keySet();
        for(StudentMapDemo s : keySet){
            System.out.println(s.getName() + "," + s.getAge() + "," + hm.get(s));
        }
    }
}
