package 异常;
/**
 * 自定义异常
 *
 *    继承自Exception 编译时异常，必须显式处理
 *    继承自RuntimeException 运行时异常，可以不显示处理
 *
 * ===
 * throws和throw的区别：（可能性 与 动作 的区别
 *     throws在方法声明后，跟异常类名；throw在方法体内，跟异常对象名
 *     throws抛出的异常由方法调用者来处理；throw由方法体内语句处理
 *
 */
public class ScoreException extends Exception { //自定义分数异常

    public ScoreException() {
    }

    public ScoreException(String message) {
        super(message);
    }


    //测试
    public static void main(String[] args) throws ScoreException{
        int score = 120;
        if(score<0 || score >100){
//            throw new ScoreException(); 异常的无参构造方法
            throw new ScoreException("分数有误，应该在0-100之间");  //throw语句抛出 带参构造方法
        } else {
            System.out.println("分数正常");
        }
    }
}
