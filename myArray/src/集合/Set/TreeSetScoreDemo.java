package 集合.Set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 比较器排序
 */
public class TreeSetScoreDemo {
    private String name;
    private int math;
    private int eng;

    public TreeSetScoreDemo(String name, int math, int eng) {
        this.name = name;
        this.math = math;
        this.eng = eng;
    }

    public TreeSetScoreDemo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    /***********************************************************/
    public static void main(String[] args) {
        TreeSet<TreeSetScoreDemo> ts = new TreeSet<>(new Comparator<TreeSetScoreDemo>() {
            @Override
            public int compare(TreeSetScoreDemo o1, TreeSetScoreDemo o2) {
                int total1 = o1.getEng() + o1.getMath();
                int total2 = o2.getEng() + o2.getMath();
                //主要条件，一般给出
                int num = total2 - total1; //总成绩降序排列
                //次要条件，一般是分析出来的。逐条添加
                int num2 = num == 0 ? o1.getEng() - o2.getEng() : num; //总分相同，比较单科
                int num3 = num2 == 0 ? o1.getName().compareTo(o2.getName()) : num2; //总分单科都相同，比较姓名
                return num3;
            }
        });
        TreeSetScoreDemo s1 = new TreeSetScoreDemo("stuA",98,85);
        TreeSetScoreDemo s2 = new TreeSetScoreDemo("stuB",64,50);
        TreeSetScoreDemo s3 = new TreeSetScoreDemo("stuC",75,65);
        TreeSetScoreDemo s4 = new TreeSetScoreDemo("stuD",98,85);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);

        for (TreeSetScoreDemo s : ts) {
            System.out.println(s.getName() + "," + s.getMath() + "," + s.getEng());
        }

    }
}
