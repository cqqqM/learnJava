package 集合.Set;


import java.util.HashSet;

public class HashSetStudentDemo {
    //成员变量
    private String name;
    private int age;
    //构造方法
    public HashSetStudentDemo() {
    }
    public HashSetStudentDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //成员方法
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void show() {
        System.out.println(this.name + "," + this.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashSetStudentDemo that = (HashSetStudentDemo) o;

        if (age != that.age) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    /********************************************************************************/

    public static void main(String[] args) {
        HashSet<HashSetStudentDemo> hs = new HashSet<>();

        HashSetStudentDemo s1 = new HashSetStudentDemo("mcq",24);
        HashSetStudentDemo s2 = new HashSetStudentDemo("zyk",88);
        HashSetStudentDemo s3 = new HashSetStudentDemo("wzj",2);

        hs.add(s1);
        hs.add(s2);
        hs.add(s3);

        //s4是和s1不同的对象，所以这里会添加成功
        //重写了Student类的hashCode()和equals()方法后，s4和s1能被看作同一对象了
        HashSetStudentDemo s4 = new HashSetStudentDemo("mcq",24);
        hs.add(s4);

        for(HashSetStudentDemo s : hs){
            s.show();
        }

    }
}
