package IO.进阶;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class TreeSet2FileStudentDemo {
    String name;
    int chinese;
    int english;
    int math;

    public TreeSet2FileStudentDemo(String name, int chinese, int english, int math) {
        this.name = name;
        this.chinese = chinese;
        this.english = english;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }
     public int getTotal(){
        return math + chinese + english;
     }

    /*****************************************
     * 从TreeSet到文件
     */
    public static void main(String[] args) throws IOException {
        //创建TreeSet，明确比较规则
        TreeSet<TreeSet2FileStudentDemo> ts = new TreeSet<>(new Comparator<TreeSet2FileStudentDemo>() {
            @Override
            public int compare(TreeSet2FileStudentDemo o1, TreeSet2FileStudentDemo o2) {
                //主要条件：总分
                int num = o2.getTotal() - o1.getTotal();
                //第二条件：语文成绩
                int num2 = num==0?o1.getChinese()-o2.getChinese():num;
                //第三条件：数学成绩
                int num3 = num2==0?o1.getMath()-o2.getMath():num2;
                //第四条件：姓名
                int num4 = num3==0?o1.getName().compareTo(o2.getName()):num3;
                return num4;
            }
        });

        //键盘录入学生数据
        for(int i = 0; i < 5; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请录入第" + (i+1) + "个学生信息");
            System.out.println("姓名:");
            String name = sc.nextLine();
            System.out.println("语文:");
            int chinese = sc.nextInt();
            System.out.println("数学:");
            int math = sc.nextInt();
            System.out.println("英语:");
            int english = sc.nextInt();

            //创建学生对象
            TreeSet2FileStudentDemo stu = new TreeSet2FileStudentDemo(name,chinese,english,math);

            //学生加入TresSet
            ts.add(stu);
        }

        //写入文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("myArray\\src\\IO\\进阶\\info"));
        for(TreeSet2FileStudentDemo student : ts) {
            bw.write(student.getName() + "," + student.getChinese() + "," + student.getMath() + "," +student.getEnglish());
            bw.newLine();
            bw.flush();
        }
        bw.close();

    }
}
