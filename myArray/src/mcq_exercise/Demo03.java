package mcq_exercise;

/*
 * 百钱百鸡问题（穷举法）
 *  公鸡一只5钱  母鸡一只3钱  小鸡三只1钱
 *  问：如何用100钱买100鸡
 *
 *  x + y + z = 100
 *  5x + 3y + z/3 = 100
 *  0<=x<=20 0<=y<=33 0<=z<=300
 */
public class Demo03 {
    public static void main(String[] args) {
        for (int x = 0; x <= 20; x++) {
            for (int y = 0; y <= 33; y++) {
                int z = 100 - x - y;

                if (z % 3 == 0 && 5 * x + 3 * y + z / 3 == 100) {
                    System.out.println(x + "," + y + "," + z);
                }
            }
        }
    }
}
