package 集合;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 洗牌、发牌、看牌
 */
public class PokerTest {
    public static void main(String[] args) {
        //牌盒
        ArrayList<String> array = new ArrayList<>();

        //装牌
        String[] colors = {"♥", "♠", "♦", "♣"}; // 花色
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (String color : colors) {
            for (String number : numbers) {
                array.add(color + number);
            }
        }
        array.add("小王");
        array.add("大王");

//        System.out.println(array);
//        System.out.println(array.size());

        //洗牌
        Collections.shuffle(array);

        //发牌，取余操作
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dparray = new ArrayList<>(); //底牌
        for (int i = 0; i < array.size(); i++) {
            String poker = array.get(i);
            if (i >= array.size() - 3) {  //最后三张
                dparray.add(poker);
            } else if (i % 3 == 0) { //用%来分牌
                player1.add(poker);
            } else if (i % 3 == 1) {
                player2.add(poker);
            } else if (i % 3 == 2) {
                player3.add(poker);
            }
        }

        //看牌
        System.out.println("player1:" + player1);
        System.out.println("player2:" + player2);
        System.out.println("player3:" + player3);
        System.out.println("底牌:" + dparray);


    }
}
