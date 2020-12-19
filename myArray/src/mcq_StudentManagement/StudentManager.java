package mcq_StudentManagement;

/*
   特别注意：
        删除/修改学号不存在的问题
        添加学生学号重复问题
 */

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 学生管理系统
 * ctrl + d 复制一行
 */
public class StudentManager {
    public static void main(String[] args) {
        //学生数据集合
        ArrayList<Student> stu = new ArrayList<>();

        //主界面
        while (true) {
            System.out.println("\n--------欢迎来到学生管理系统--------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.退出");
            System.out.print("请输入你的选择: ");

            //键盘录入数据
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            //switch语句选择
            switch (line) {
                case "1":
                    //System.out.println("添加学生");
                    addStudent(stu);
                    break;
                case "2":
                    //System.out.println("删除学生");
                    deletStudent(stu);
                    break;
                case "3":
                    //System.out.println("修改学生");
                    updateStudent(stu);
                    break;
                case "4":
                    //System.out.println("查看所有学生");
                    showAllStudents(stu);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    return;
            }
        }
    }

    //添加学生
    public static void addStudent(ArrayList<Student> arr) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入学号: ");
        String sid = sc.nextLine();

        //如果学生已存在，提示错误
        if(isExisted(arr,sid)){
            System.out.println("学生学号已存在！");
            return;
        }

        System.out.print("请输入姓名: ");
        String name = sc.nextLine();
        System.out.print("请输入年龄: ");
        String age = sc.nextLine();
        System.out.print("请输入居住地: ");
        String add = sc.nextLine();

        //创建学生对象
        Student s = new Student(sid, name, age, add);

        //学生对象添加到集合中
        arr.add(s);

        System.out.println("学生添加成功！");
    }

    //判断学号是否已经存在
    public static boolean isExisted(ArrayList<Student> arr, String sid) {
        for (int i = 0; i < arr.size(); i++) {
            Student student = arr.get(i);
            if (student.getSid().equals(sid)) {
                return true;
            }
        }
        return false;
    }

    //查看学生
    public static void showAllStudents(ArrayList<Student> arr) {
        //先判断集合中是否有数据，如果没有显示提示信息
        if (arr.size() == 0) {
            System.out.println("无信息，请先添加信息再查询！");
            return;
        }


        //显示表头
        System.out.println("学号\t\t\t姓名\t\t年龄\t\t居住地");
        //读取集合里的信息
        for (int i = 0; i < arr.size(); i++) {
            Student s = arr.get(i);
            System.out.println(s.getSid() + "\t\t\t" +
                    s.getName() + "\t\t" +
                    s.getAge() + "岁\t\t" +
                    s.getAddress());
        }
    }

    //删除学生
    public static void deletStudent(ArrayList<Student> arr) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要删除的学生学号: ");
        String sid = sc.nextLine();

        //遍历集合找到， .remove()删除
        for (int i = 0; i < arr.size(); i++) {
            Student student = arr.get(i);
            if (student.getSid().equals(sid)) {  //.equals比较字符串内容
                arr.remove(student);
                System.out.println("删除学生成功！");
                return;
            }
        }
        //遍历后没找到，则学号不存在
        System.out.println("输入的学号不存在！");

    }

    //修改学生
    public static void updateStudent(ArrayList<Student> arr) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要修改的学生学号: ");
        String sid = sc.nextLine();


        //遍历集合找到修改的学生，.set()修改
        for (int i = 0; i < arr.size(); i++) {
            Student stuold = arr.get(i);
            if (stuold.getSid().equals(sid)) {  //找到学生
                System.out.print("请输入新的学生姓名: ");
                String name = sc.nextLine();
                System.out.print("请输入新的学生年龄: ");
                String age = sc.nextLine();
                System.out.print("请输入新的学生居住地: ");
                String add = sc.nextLine();

                //创建新的学生对象
                Student stunew = new Student(sid, name, age, add);
                arr.set(i, stunew);
                System.out.println("修改学生信息成功！");
                return;
            }
        }
        //遍历集合未找到学号
        System.out.println("未找到要修改的学生学号，请检查！");
    }
}
