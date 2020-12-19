package jicheng;
 /*
  手机类

  方法重写

  私有方法不能被继承


  */
public class Phone {

    public void call(String name){
        System.out.println("给" + name + "打电话");
    }
    public void send(String M){
        System.out.println("Send Message!");
    }

    //private修饰，不能被子类获取
//     private void method() {
//         System.out.println("Fu method!");
//     }

     void method(){
         System.out.println("Fu method!");
     }
}
